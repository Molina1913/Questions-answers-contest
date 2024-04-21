package org.example.Service;

import org.example.integrationdatabase.crud.PlayerCrud;
import org.example.model.Player;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.Service.ServiceConstants.ENTER_PLAYER_ID;
import static org.example.Service.ServiceConstants.ENTER_PLAYER_NAME;
import static org.example.model.Player.players;

public class PlayerService {
    static PlayerCrud playerCrud= new PlayerCrud();

    public PlayerService() {
        playerCrud = new PlayerCrud();
    }
    public static Player validatePlayer() throws SQLException {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println(ENTER_PLAYER_ID);
        String id = scanner.nextLine();
        if(players.isEmpty()){
            playerCrud.selectDataPlayers();
        }
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getId().equalsIgnoreCase(id)){
                return players.get(i);
            }
        }
        return createPlayer(id);
    }
    public static Player createPlayer(String id) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println(ENTER_PLAYER_NAME);
        String name = scanner.nextLine();
        Player player=new Player(id, name);
        playerCrud.createPlayer(player);
        return player;
    }
}
