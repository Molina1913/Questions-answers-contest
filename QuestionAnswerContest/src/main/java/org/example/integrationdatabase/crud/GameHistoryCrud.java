package org.example.integrationdatabase.crud;

import org.example.integrationdatabase.mysql.MySqlOperation;
import org.example.model.GameHistory;
import org.example.model.Player;

import static org.example.integrationdatabase.mysql.MySqlConstants.CREATE_GAME_HISTORY;
import static org.example.integrationdatabase.mysql.MySqlConstants.CREATE_PLAYER;

public class GameHistoryCrud {
    MySqlOperation mySqlOperation;

    public GameHistoryCrud() {
        mySqlOperation = new MySqlOperation();
    }
    public void createHistory(GameHistory history){
        mySqlOperation.executeSqlStatementVoid(String.format(CREATE_GAME_HISTORY, history.getIdPlayer(), history.getIdQuestion(),
                history.getIdOption(), history.getIdRound()));
    }
}
