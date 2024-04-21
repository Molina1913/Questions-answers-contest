package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
    public static List<Question> questions = new ArrayList<>();
    public static List<Question> veryEasyQuestions = new ArrayList<>();
    public static List<Question> easyQuestions = new ArrayList<>();
    public static List<Question> mediumQuestions = new ArrayList<>();
    public static List<Question> difficultQuestions = new ArrayList<>();
    public static List<Question> veryDifficultQuestions = new ArrayList<>();
    private int idQuestion;
    private String questionDescription;
    private String category;

    public Question() {
    }

    public Question(int idQuestion, String questionDescription, String category) {
        this.idQuestion = idQuestion;
        this.questionDescription = questionDescription;
        this.category = category;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
