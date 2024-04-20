package org.example.Service;

import org.example.integrationdatabase.crud.AnswerOptionCrud;
import org.example.integrationdatabase.crud.QuestionsCrud;
import org.example.model.Question;
import org.example.model.AnswerOption;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.Service.MenuService.askOption;
import static org.example.integrationdatabase.menu.Menu.setUpOptions;

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
            default:
                System.out.println("Enter a valid option");
        }
        return flag;
    }

    private static void loadQuestions() throws SQLException {
        answerOptionCrud.selectDataAnswers();
        questionsCrud.selectDataQuestions();
    }

    public static void createQuestions() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        for (int i = 1; i <= 25; i++) {
            System.out.println("Insert a question");
            Question question = new Question();
            question.setId_question(i);
            System.out.println("Insert the question description");
            question.setQuestion_description(scanner.nextLine());
            question.setCategory(selectCategory());
            questionsCrud.createQuestion(question);
            System.out.println("Remember the first option will be the true answer");
            for (int j = 1; j <= 4; j++) {
                AnswerOption answerOption = new AnswerOption();
                answerOption.setIdQuestion(i);
                answerOption.setIdOption(j);
                System.out.println("Enter the description of the option");
                answerOption.setOptionDescription(scanner.nextLine());
                if (j == 1) {
                    answerOption.setTrue(true);
                } else {
                    answerOption.setTrue(false);
                }
                answerOptionCrud.createAnswerOption(answerOption);
            }
        }
    }

    private static String selectCategory() {
        boolean flag = true;
        while (flag) {
            System.out.println("Select the category of the question");
            System.out.println("1. Very easy");
            System.out.println("2. Easy");
            System.out.println("3. Medium");
            System.out.println("4. Difficult");
            System.out.println("5. Very difficult");
            int option = askOption();
            switch (option) {
                case 1:
                    return "Very easy";
                case 2:
                    return "Easy";
                case 3:
                    return "Medium";
                case 4:
                    return "Difficult";
                case 5:
                    return "Very difficult";
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        }
        return "";
    }
}
