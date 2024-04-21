package org.example.integrationdatabase.crud;

import org.example.integrationdatabase.mysql.MySqlOperation;
import org.example.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.integrationdatabase.mysql.MySqlConstants.*;
import static org.example.model.Question.questions;

public class QuestionsCrud {
    MySqlOperation mySqlOperation;

    public QuestionsCrud() {
        mySqlOperation=new MySqlOperation();
    }
    public void createQuestion(Question question){
        mySqlOperation.executeSqlStatementVoid(String.format(CREATE_QUESTION, question.getIdQuestion(),
                question.getQuestionDescription(), question.getCategory()));
    }
    public void selectDataQuestions() throws SQLException {
        mySqlOperation.setSqlStatement(String.format(SELECT, QUESTION));
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet=mySqlOperation.getResulset();
        fillQuestions(resultSet);
    }
    private void fillQuestions(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int idQuestion = resultSet.getInt("id_question");
            String questionDescription = resultSet.getString("question_description");
            String category = resultSet.getString("category");

            Question question=new Question(idQuestion, questionDescription, category);
            questions.add(question);
        }
    }
}
