package org.example.Service;

import org.example.model.AnswerOption;
import org.example.model.Player;
import org.example.model.Question;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.Service.MenuService.askOption;
import static org.example.Service.PlayerService.validatePlayer;
import static org.example.Service.QuestionOptionService.loadQuestions;
import static org.example.Service.ServiceConstants.*;
import static org.example.model.AnswerOption.answers;
import static org.example.model.Question.*;

public class GameHistoryService {
    public static void startGame() throws SQLException {
        Player player;
        List<AnswerOption> optionsToChoose;
        int roundNumber = 1;
        boolean flag = true;

        loadQuestionsByDifficulty();
        player = validatePlayer();
        System.out.println("Welcome to Question Answer Contest");
        while (flag) {
            System.out.println("Round " + roundNumber);
            optionsToChoose = showQuestion(roundNumber);
            System.out.println("Select the answer");
            int answer = askOption();
            flag = checkAnswer(answer, optionsToChoose);

            roundNumber++;
        }

    }

    private static boolean checkAnswer(int answer, List<AnswerOption> options) {
        if (options.get(answer - 1).getIsTrue() == 1) {
            System.out.println("Congratulations, the answer is correct");
            return true;
        } else {
            System.out.println("The answer is wrong");
            System.out.println("you have lost");
            return false;
        }
    }

    private static List<AnswerOption> showQuestion(int round) {
        int randomQuestion = (int) (Math.random() * 5);
        int randomOptions = (int) (Math.random() * (4 - 1 + 1)) + 1;
        List<AnswerOption> options = new ArrayList<>();
        options.clear();
        if (round == 1) {
            Question question = veryEasyQuestions.get(randomQuestion);
            String questionDesc = question.getQuestionDescription();
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).getIdQuestion() == question.getIdQuestion()) {
                    options.add(answers.get(i));
                }
            }
            System.out.println(questionDesc);
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + ". " + options.get(i).getOptionDescription());
            }
            return options;
        } else if (round == 2) {
            Question question = easyQuestions.get(randomQuestion);
            String questionDesc = question.getQuestionDescription();
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).getIdQuestion() == question.getIdQuestion()) {
                    options.add(answers.get(i));
                }
            }
            System.out.println(questionDesc);
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + ". " + options.get(i).getOptionDescription());
            }
            return options;
        }else if (round == 3) {
            Question question = mediumQuestions.get(randomQuestion);
            String questionDesc = question.getQuestionDescription();
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).getIdQuestion() == question.getIdQuestion()) {
                    options.add(answers.get(i));
                }
            }
            System.out.println(questionDesc);
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + ". " + options.get(i).getOptionDescription());
            }
            return options;
        }else if (round == 4) {
            Question question = difficultQuestions.get(randomQuestion);
            String questionDesc = question.getQuestionDescription();
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).getIdQuestion() == question.getIdQuestion()) {
                    options.add(answers.get(i));
                }
            }
            System.out.println(questionDesc);
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + ". " + options.get(i).getOptionDescription());
            }
            return options;
        }else if (round == 5) {
            Question question = veryDifficultQuestions.get(randomQuestion);
            String questionDesc = question.getQuestionDescription();
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).getIdQuestion() == question.getIdQuestion()) {
                    options.add(answers.get(i));
                }
            }
            System.out.println(questionDesc);
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + ". " + options.get(i).getOptionDescription());
            }
            return options;
        }
        return null;

    }

    public static void loadQuestionsByDifficulty() throws SQLException {
        loadQuestions();
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getCategory().equalsIgnoreCase(VERY_EASY)) {
                veryEasyQuestions.add(questions.get(i));
            } else if (questions.get(i).getCategory().equalsIgnoreCase(EASY)) {
                easyQuestions.add(questions.get(i));
            } else if (questions.get(i).getCategory().equalsIgnoreCase(MEDIUM)) {
                mediumQuestions.add(questions.get(i));
            } else if (questions.get(i).getCategory().equalsIgnoreCase(DIFFICULT)) {
                difficultQuestions.add(questions.get(i));
            } else if (questions.get(i).getCategory().equalsIgnoreCase(VERY_DIFFICULT)) {
                veryDifficultQuestions.add(questions.get(i));
            }
        }
    }

}
