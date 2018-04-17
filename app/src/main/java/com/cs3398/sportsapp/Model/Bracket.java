package com.cs3398.sportsapp.Model;

import java.io.Serializable;

public class Bracket implements Serializable{
    private String bracketName;
    private String BracketName, player1, player2, player3,
            player4, player5, player6, player7, player8;
    private String r1loser1, r1loser2, r1loser3, r1loser4;
    private String r1winner1, r1winner2, r1winner3, r1winner4;
    private String r2winner1, r2winner2;
    private String r2loser1, r2loser2;
    private String finalWinner, finalLoser;
    private int currentRound;

    public Bracket(){};

    public Bracket(String name, String user1, String user2, String user3, String user4,
                   String user5, String user6, String user7, String user8,
                   String round1winner1, String round1winner2, String round1winner3,
                   String round1winner4, String round2winner1, String round2winner2,
                   String round1loser1, String round1loser2, String round1loser3,
                   String round1loser4, String round2loser1, String round2loser2) {
        bracketName = name;
        player1 = user1;
        player2 = user2;
        player3 = user3;
        player4 = user4;
        player5 = user5;
        player6 = user6;
        player7 = user7;
        player8 = user8;
        r1winner1 = round1winner1;
        r1winner2 = round1winner2;
        r1winner3 = round1winner3;
        r1winner4 = round1winner4;
        r1loser1 = round1loser1;
        r1loser2 = round1loser2;
        r1loser3 = round1loser3;
        r1loser4 = round1loser4;
        r2winner1 = round2winner1;
        r2winner2 = round2winner2;
        r2loser1 = round2loser1;
        r2loser2 = round2loser2;
    }
    public void addPlayers(String name, String user1, String user2, String user3, String user4,
                           String user5, String user6, String user7, String user8) {
        BracketName = name;
        player1 = user1;
        player2 = user2;
        player3 = user3;
        player4 = user4;
        player5 = user5;
        player6 = user6;
        player7 = user7;
        player8 = user8;
        currentRound = 1;
    }

    public void addWinner(String name, String user1, String user2, String user3, String user4) {
        r1winner1 = user1;
        r1winner2 = user2;
        r1winner3 = user3;
        r1winner4 = user4;
        currentRound = 2;
    }

    public void addLoser(String name, String user1, String user2, String user3, String user4) {
        r1loser1 = user1;
        r1loser2 = user2;
        r1loser3 = user3;
        r1loser4 = user4;
    }

    public void addWinner(String name, String user1, String user2) {
        r2winner1 = user1;
        r2winner2 = user2;
        currentRound = 3;
    }

    public void addLoser(String name, String user1, String user2) {
        r2loser1 = user1;
        r2loser2 = user2;
    }

    public void finalWinnerLoser(String name, String user1, String user2) {
        finalWinner = user1;
        finalLoser = user2;
        currentRound = 0;
    }

    public String getBracketName() {
        return bracketName;
    }
}
