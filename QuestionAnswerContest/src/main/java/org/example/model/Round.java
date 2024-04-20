package org.example.model;

public class Round {
    private int id;
    private int prize;

    public Round() {
    }

    public Round(int id, int prize) {
        this.id = id;
        this.prize = prize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}
