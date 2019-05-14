package org.keycloak.examples.authenticator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SecretQuestionsUtil {

    private static Map<String, String> secretQuestionResponses = new HashMap<>();

    static {
        secretQuestionResponses.put("What is your mom's first name", "yaquelin");
        secretQuestionResponses.put("What is your pet name", "bella");
        secretQuestionResponses.put("How old were you in 1992", "7");
        secretQuestionResponses.put("How is the real name of American Captain", "Steven Grant Rogers");
    }

    public static boolean validate(String questions, String response) {
        return secretQuestionResponses.entrySet().stream().anyMatch(entry -> entry.getKey().equals(questions) && entry.getValue().equals(response));
    }


    public static String getRandomQuestion() {
        Random r = new Random();
        String[] questions = secretQuestionResponses.keySet().toArray(new String[]{});
        return questions[r.nextInt(secretQuestionResponses.size())];
    }

}
