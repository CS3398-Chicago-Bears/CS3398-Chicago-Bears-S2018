package com.cs3398.sportsapp.Model;

import java.io.Serializable;

public class Bracket implements Serializable{
    private int bID;
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

    public int getbID() { return bID; }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public String getPlayer5() {
        return player5;
    }

    public String getPlayer6() {
        return player6;
    }

    public String getPlayer7() {
        return player7;
    }

    public String getPlayer8() {
        return player8;
    }

    public String getR1loser1() {
        return r1loser1;
    }

    public String getR1loser2() {
        return r1loser2;
    }

    public String getR1loser3() {
        return r1loser3;
    }

    public String getR1loser4() {
        return r1loser4;
    }

    public String getR1winner1() {
        return r1winner1;
    }

    public String getR1winner2() {
        return r1winner2;
    }

    public String getR1winner3() {
        return r1winner3;
    }

    public String getR1winner4() {
        return r1winner4;
    }

    public String getR2winner1() {
        return r2winner1;
    }

    public String getR2winner2() {
        return r2winner2;
    }

    public String getR2loser1() {
        return r2loser1;
    }

    public String getR2loser2() {
        return r2loser2;
    }

    public String getFinalWinner() {
        return finalWinner;
    }

    public String getFinalLoser() {
        return finalLoser;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setbID(int bID) { this.bID = bID; }

    public void setBracketName(String bracketName) {
        this.bracketName = bracketName;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }

    public void setPlayer5(String player5) {
        this.player5 = player5;
    }

    public void setPlayer6(String player6) {
        this.player6 = player6;
    }

    public void setPlayer7(String player7) {
        this.player7 = player7;
    }

    public void setPlayer8(String player8) {
        this.player8 = player8;
    }

    public void setR1loser1(String r1loser1) {
        this.r1loser1 = r1loser1;
    }

    public void setR1loser2(String r1loser2) {
        this.r1loser2 = r1loser2;
    }

    public void setR1loser3(String r1loser3) {
        this.r1loser3 = r1loser3;
    }

    public void setR1loser4(String r1loser4) {
        this.r1loser4 = r1loser4;
    }

    public void setR1winner1(String r1winner1) {
        this.r1winner1 = r1winner1;
    }

    public void setR1winner2(String r1winner2) {
        this.r1winner2 = r1winner2;
    }

    public void setR1winner3(String r1winner3) {
        this.r1winner3 = r1winner3;
    }

    public void setR1winner4(String r1winner4) {
        this.r1winner4 = r1winner4;
    }

    public void setR2winner1(String r2winner1) {
        this.r2winner1 = r2winner1;
    }

    public void setR2winner2(String r2winner2) {
        this.r2winner2 = r2winner2;
    }

    public void setR2loser1(String r2loser1) {
        this.r2loser1 = r2loser1;
    }

    public void setR2loser2(String r2loser2) {
        this.r2loser2 = r2loser2;
    }

    public void setFinalWinner(String finalWinner) {
        this.finalWinner = finalWinner;
    }

    public void setFinalLoser(String finalLoser) {
        this.finalLoser = finalLoser;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
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
