package org.example.Service;

import org.example.integrationdatabase.crud.AnswerOptionCrud;
import org.example.integrationdatabase.crud.QuestionsCrud;
import org.example.model.Question;
import org.example.model.AnswerOption;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.Service.MenuService.askOption;
import static org.example.Service.ServiceConstants.*;
import static org.example.menu.Menu.difficultyMenu;
import static org.example.menu.Menu.setUpOptions;
import static org.example.model.AnswerOption.answers;
import static org.example.model.Question.questions;

public class QuestionOptionService {
    static AnswerOptionCrud answerOptionCrud = new AnswerOptionCrud();
    static QuestionsCrud questionsCrud = new QuestionsCrud();

    public QuestionOptionService() {
    }

    public static void setUpGame() throws SQLException {
        int option;
        boolean flag = true;
        while (flag) {
            setUpOptions();
            option = askOption();
            flag = selectSetUpOption(option, flag);
        }
    }

    private static boolean selectSetUpOption(int option, boolean flag) throws SQLException {
        switch (option) {
            case 1:
                loadQuestions();
                break;
            case 2:
                createQuestions();
                break;
            case 0:
                flag=false;
                break;
            default:
                System.out.println(VALID_OPTION);
        }
        return flag;
    }

    public static void loadQuestions() throws SQLException {
        if(answers.isEmpty()){
            answerOptionCrud.selectDataAnswers();
        }
        if(questions.isEmpty()){
            questionsCrud.selectDataQuestions();
        }
    }

    public static void createQuestions() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        for (int i = 1; i <= 25; i++) {
            System.out.println(INSERT_QUESTION);
            Question question = new Question();
            question.setIdQuestion(i);
            System.out.println(INSERT_QUESTION_DESCRIPTION);
            question.setQuestionDescription(scanner.nextLine());
            question.setCategory(selectCategory());
            System.out.println(TRUE_ANSWER);
            for (int j = 1; j <= 4; j++) {
                AnswerOption answerOption = new AnswerOption();
                answerOption.setIdQuestion(i);
                answerOption.setIdOption(j);
                System.out.println(DESCRIPTION_OPTION);
                answerOption.setOptionDescription(scanner.nextLine());
                if (j == 1) {
                    answerOption.setIsTrue((byte) 1);
                } else {
                    answerOption.setIsTrue((byte) 0);
                }
                answerOptionCrud.createAnswerOption(answerOption);
            }
            questionsCrud.createQuestion(question);
        }
    }

    private static String selectCategory() {
        boolean flag = true;
        while (flag) {
            difficultyMenu();
            int option = askOption();
            switch (option) {
                case 1:
                    return VERY_EASY;
                case 2:
                    return EASY;
                case 3:
                    return MEDIUM;
                case 4:
                    return DIFFICULT;
                case 5:
                    return VERY_DIFFICULT;
                default:
                    System.out.println(VALID_OPTION);
                    break;
            }
        }
        return "";
    }
}
