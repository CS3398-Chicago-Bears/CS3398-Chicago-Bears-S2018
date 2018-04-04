package com.cs3398.sportsapp.Model;

import java.util.ArrayList;
import java.util.Scanner;
import com.cs3398.sportsapp.Model.*;

public class Bracket{
    private String bracketName;
    private String player1, player2, player3, player4, player5, player6, player7, player8;
    private String r1winner1, r1winner2, r1winner3, r1winner4;
    private String r2winner1, r2winner2;
    private int currentRound;

    public void addUser(String user1, String user2, String user3, String user4,
                        String user5, String user6, String user7, String user8) {
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

    public void addUser(String user1, String user2, String user3, String user4) {
        r1winner1 = user1;
        r1winner2 = user2;
        r1winner3 = user3;
        r1winner4 = user4;
        currentRound = 2;
    }

    public void addUser(String user1, String user2) {
        r2winner1 = user1;
        r2winner2 = user2;
        currentRound = 3;
    }

    public void setCurrentRound(int curRound) {
        currentRound = curRound;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setBracketName(String newName) {
        bracketName = newName;
    }

    public String getBracketName() {
        return bracketName;
    }
}
