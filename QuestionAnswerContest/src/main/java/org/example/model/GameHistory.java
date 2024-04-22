package org.example.model;

import java.util.List;

public class GameHistory {
    private int idHistory;
    private String idPlayer;
    private int idQuestion;
    private int idOption;
    private int idRound;
    private List<Question> questions;

    public GameHistory() {
    }

    public GameHistory(String idPlayer, int idQuestion, int idOption, int idRound) {
        this.idPlayer = idPlayer;
        this.idQuestion = idQuestion;
        this.idOption = idOption;
        this.idRound = idRound;
    }

    public GameHistory(int idHistory, String idPlayer, int idQuestion, int idOption, int idRound, List<Question> questions) {
        this.idHistory = idHistory;
        this.idPlayer = idPlayer;
        this.idQuestion = idQuestion;
        this.idOption = idOption;
        this.idRound = idRound;
        this.questions = questions;
    }

    public int getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(int idHistory) {
        this.idHistory = idHistory;
    }

    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdOption() {
        return idOption;
    }

    public void setIdOption(int idOption) {
        this.idOption = idOption;
    }

    public int getIdRound() {
        return idRound;
    }

    public void setIdRound(int idRound) {
        this.idRound = idRound;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
