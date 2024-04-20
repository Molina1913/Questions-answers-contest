package org.example.integrationdatabase.crud;

import org.example.integrationdatabase.mysql.MySqlOperation;
import org.example.model.Player;

import static org.example.integrationdatabase.mysql.MySqlConstants.CREATE_PLAYER;

public class PlayerCrud {
    MySqlOperation mySqlOperation;

    public PlayerCrud() {
        mySqlOperation=new MySqlOperation();
    }
    public void createPlayer(Player player){
        mySqlOperation.executeSqlStatementVoid(String.format(CREATE_PLAYER, player.getId(), player.getName()));
    }
}
