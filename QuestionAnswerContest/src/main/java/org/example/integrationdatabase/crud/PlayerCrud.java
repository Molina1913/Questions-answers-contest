package org.example.integrationdatabase.crud;

import org.example.integrationdatabase.mysql.MySqlOperation;
import org.example.model.Player;
import org.example.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.integrationdatabase.mysql.MySqlConstants.*;
import static org.example.model.Player.players;
import static org.example.model.Question.questions;

public class PlayerCrud {
    MySqlOperation mySqlOperation;

    public PlayerCrud() {
        mySqlOperation=new MySqlOperation();
    }
    public void createPlayer(Player player){
        mySqlOperation.executeSqlStatementVoid(String.format(CREATE_PLAYER, player.getId(), player.getName()));
    }
    public void selectDataPlayers() throws SQLException {
        mySqlOperation.setSqlStatement(String.format(SELECT, PLAYER));
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet=mySqlOperation.getResulset();
        fillPlayers(resultSet);
    }
    private void fillPlayers(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");

            Player player=new Player(id, name);
            players.add(player);
        }
    }
}
