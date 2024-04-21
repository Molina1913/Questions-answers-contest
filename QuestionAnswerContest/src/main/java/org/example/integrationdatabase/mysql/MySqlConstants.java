package org.example.integrationdatabase.mysql;

public class MySqlConstants {
    public static final String MY_SQL_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String CONNECTION_STRING = "jdbc:mysql://%s/%s?user=%s&password=%s";
    public static final String SERVER = "localhost:3306";
    public static final String CREATE_PLAYER = "INSERT INTO contest.player VALUES ('%s', '%s')";
    public static final String SELECT = "SELECT * FROM contest.%s";
    public static final String PLAYER = "player";
    public static final String QUESTION = "questions";
    public static final String ANSWER = "answer_options";
    public static final String CREATE_QUESTION = "INSERT INTO contest.questions VALUES ('%s', '%s', '%s')";
    public static final String CREATE_ANSWER_OPTION = "INSERT INTO contest.answer_options VALUES ('%s', '%s', '%s', '%s')";

}
