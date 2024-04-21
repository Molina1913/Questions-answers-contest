package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static List<Player> players = new ArrayList<>();
    private String id;
    private String name;

    public Player() {
    }

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
