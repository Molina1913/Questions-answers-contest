package org.example.integrationdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBase {
    public void configureDataBaseConnection();

    public void executeSqlStatement();

    int executeSqlStatementVoidForKeys(String sentencia);

    public void executeSqlStatementVoid();
    public int executeSqlStatementVoidForKeys();
    public ResultSet getResulset();

    public void close();

    public void printResulset()throws SQLException;
    public void executeSqlStatementVoid(String sentencia);
}
