package org.keycloak.examples.authenticator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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


    @Deprecated
    public static String getRandomQuestion() {
        Random r = new Random();
        String[] questions = secretQuestionResponses.keySet().toArray(new String[]{});
        return questions[r.nextInt(secretQuestionResponses.size())];
    }

    public static QuestionVO getRandomQuestion(List<QuestionVO> questions) {
        Objects.requireNonNull(questions, "The questions can not be null");
        if (questions.isEmpty()) {
            throw new IllegalArgumentException("The questions can no be empty");
        }

        Random r = new Random();
        return questions.get(r.nextInt(secretQuestionResponses.size()));
    }

    public static List<QuestionVO> getQuestions(String user, String system) {
        List<QuestionVO> questionVOS = new ArrayList<>();
        questionVOS.add(new QuestionVO("What is your mom's first name", "yaquelin"));
        questionVOS.add(new QuestionVO("What is your pet name", "bella"));
        questionVOS.add(new QuestionVO("How old were you in 1992", "7"));
        questionVOS.add(new QuestionVO("How is the real name of American Captain", "Steven Grant Rogers"));

        return questionVOS;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static public class QuestionVO {
        private String question;
        private String answer;
    }
}
