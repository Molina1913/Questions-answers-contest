package org.example.integrationdatabase.crud;

import org.example.integrationdatabase.mysql.MySqlOperation;
import org.example.model.AnswerOption;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.integrationdatabase.mysql.MySqlConstants.*;
import static org.example.model.AnswerOption.answers;

public class AnswerOptionCrud {
    MySqlOperation mySqlOperation;

    public AnswerOptionCrud() {
        mySqlOperation=new MySqlOperation();
    }

    public void createAnswerOption(AnswerOption answerOption){
        mySqlOperation.executeSqlStatementVoid(String.format(CREATE_ANSWER_OPTION, answerOption.getIdOption(), answerOption.getIdQuestion(),
                answerOption.getOptionDescription(), answerOption.getIsTrue()));
    }
    public void selectDataAnswers() throws SQLException {
        mySqlOperation.setSqlStatement(String.format(SELECT, ANSWER));
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet=mySqlOperation.getResulset();
        fillAnswers(resultSet);
    }
    private void fillAnswers(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int idOption = resultSet.getInt("id_option");
            int idQuestion = resultSet.getInt("id_question");
            String optionsDescription = resultSet.getString("option_description");
            byte isTrue = resultSet.getByte("is_true");

            AnswerOption answerOption=new AnswerOption(idOption, idQuestion, optionsDescription, isTrue);
            answers.add(answerOption);
        }
    }
}
