package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class AnswerOption {
    public static List<AnswerOption> answers=new ArrayList<>();
    private int idOption;
    private int idQuestion;
    private String OptionDescription;
    private boolean isTrue;

    public AnswerOption() {
    }

    public AnswerOption(int idOption, int idQuestion, String optionDescription, boolean isTrue) {
        this.idOption = idOption;
        this.idQuestion = idQuestion;
        OptionDescription = optionDescription;
        this.isTrue = isTrue;
    }

    public int getIdOption() {
        return idOption;
    }

    public void setIdOption(int idOption) {
        this.idOption = idOption;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getOptionDescription() {
        return OptionDescription;
    }

    public void setOptionDescription(String optionDescription) {
        OptionDescription = optionDescription;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
