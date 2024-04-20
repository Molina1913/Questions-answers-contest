package org.example.model;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;

public class Question {
    public static List<Question> questions=new ArrayList<>();
    private int id_question;
    private String question_description;
    private String category;

    public Question() {
    }

    public Question(int id_question, String question_description, String category) {
        this.id_question = id_question;
        this.question_description = question_description;
        this.category = category;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getQuestion_description() {
        return question_description;
    }

    public void setQuestion_description(String question_description) {
        this.question_description = question_description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
