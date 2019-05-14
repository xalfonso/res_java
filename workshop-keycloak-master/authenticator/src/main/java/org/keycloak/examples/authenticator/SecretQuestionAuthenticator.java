/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.keycloak.examples.authenticator;

import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.AuthenticationFlowError;
import org.keycloak.authentication.Authenticator;
import org.keycloak.common.util.ServerCookie;
import org.keycloak.models.AuthenticatorConfigModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserCredentialModel;
import org.keycloak.models.UserModel;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class SecretQuestionAuthenticator implements Authenticator {

    public static final String CREDENTIAL_TYPE = "secret_question";

    protected boolean hasCookie(AuthenticationFlowContext context) {
        Cookie cookie = context.getHttpRequest().getHttpHeaders().getCookies().get("SECRET_QUESTION_ANSWERED");
        boolean result = cookie != null;
        if (result) {
            System.out.println("Bypassing secret question because cookie is set");
        }
        return result;
    }

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        if (hasCookie(context)) {
            context.success();
            return;
        }

        //TODO I need to get the system
        List<SecretQuestionsUtil.QuestionVO> questions = SecretQuestionsUtil.getQuestions(context.getUser().getId(), "SOT");
        if (!questions.isEmpty()) {
            SecretQuestionsUtil.QuestionVO randomQuestion = SecretQuestionsUtil.getRandomQuestion(questions);

            UserCredentialModel input = new UserCredentialModel();
            input.setType(SecretQuestionCredentialProvider.SECRET_QUESTION);
            input.setValue(randomQuestion.getAnswer());
            context.getSession().userCredentialManager().updateCredential(context.getRealm(), context.getUser(), input);

            Response challenge = context.form().setAttribute("question", randomQuestion.getQuestion()).createForm("secret-question.ftl");
            context.challenge(challenge);

            System.out.println("Se selecciono lo pregunta: " + randomQuestion.getQuestion());
            System.out.println("Con respuesta: " + randomQuestion.getAnswer());
        }


    }

    @Override
    public void action(AuthenticationFlowContext context) {
        MultivaluedMap<String, String> formData = context.getHttpRequest().getDecodedFormParameters();
        if (formData.containsKey("cancel")) {
            context.cancelLogin();
            return;
        }
        boolean validated = validateAnswer(context);
        if (!validated) {
            //TODO I need to get the system
            List<SecretQuestionsUtil.QuestionVO> questions = SecretQuestionsUtil.getQuestions(context.getUser().getId(), "SOT");
            if (!questions.isEmpty()) {
                SecretQuestionsUtil.QuestionVO randomQuestion = SecretQuestionsUtil.getRandomQuestion(questions);

                UserCredentialModel input = new UserCredentialModel();
                input.setType(SecretQuestionCredentialProvider.SECRET_QUESTION);
                input.setValue(randomQuestion.getAnswer());
                context.getSession().userCredentialManager().updateCredential(context.getRealm(), context.getUser(), input);


                Response challenge = context.form()
                        .setError("La respuesta es incorrecta")
                        .setAttribute("question", randomQuestion.getQuestion())
                        .createForm("secret-question.ftl");
                context.failureChallenge(AuthenticationFlowError.INVALID_CREDENTIALS, challenge);

                System.out.println("Se selecciono  lo pregunta (Second): " + randomQuestion.getQuestion());
                System.out.println("Con respuesta (Second): " + randomQuestion.getAnswer());
                return;
            }
        }
        setCookie(context);
        context.success();
    }

    protected void setCookie(AuthenticationFlowContext context) {
        AuthenticatorConfigModel config = context.getAuthenticatorConfig();
        int maxCookieAge = 30;// 30 seconds
        if (config != null) {
            maxCookieAge = Integer.valueOf(config.getConfig().get("cookie.max.age"));
        }
        URI uri = context.getUriInfo().getBaseUriBuilder().path("realms").path(context.getRealm().getName()).build();
        addCookie("SECRET_QUESTION_ANSWERED", "true",
                uri.getRawPath(),
                null, null,
                maxCookieAge,
                false, true);
    }

    public static void addCookie(String name, String value, String path, String domain, String comment, int maxAge, boolean secure, boolean httpOnly) {
        HttpResponse response = ResteasyProviderFactory.getContextData(HttpResponse.class);
        StringBuffer cookieBuf = new StringBuffer();
        ServerCookie.appendCookieValue(cookieBuf, 1, name, value, path, domain, comment, maxAge, secure, httpOnly);
        String cookie = cookieBuf.toString();
        response.getOutputHeaders().add(HttpHeaders.SET_COOKIE, cookie);
    }


    protected boolean validateAnswer(AuthenticationFlowContext context) {
        MultivaluedMap<String, String> formData = context.getHttpRequest().getDecodedFormParameters();
        String secretAnswer = formData.getFirst("secret_answer");
        //String secretQuestion = formData.getFirst("secret_question");
        UserCredentialModel input = new UserCredentialModel();
        input.setType(SecretQuestionCredentialProvider.SECRET_QUESTION);
        input.setValue(secretAnswer);
        System.out.println("Se va a verificar la respuesta: " + secretAnswer);
        return context.getSession().userCredentialManager().isValid(context.getRealm(), context.getUser(), input);
        //return SecretQuestionsUtil.validate(secretQuestion, secretAnswer);
    }

    @Override
    public boolean requiresUser() {
        return true;
    }

    @Override
    public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
        return true;
    }

    @Override
    public void setRequiredActions(KeycloakSession keycloakSession, RealmModel realmModel, UserModel userModel) {

    }

    @Override
    public void close() {

    }
}
