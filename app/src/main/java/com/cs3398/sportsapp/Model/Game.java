package com.cs3398.sportsapp.Model;

import com.cs3398.sportsapp.Model.User;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Guy on 2/20/2018.
 */

public class Game {
    private String sport;
    private User player1;
    private User player2;
    private Date date;
    private int outcome;
    private boolean inBracket;

    public Game(User player1, User player2, String sport, Date date) {
        this.player1 = player1;
        this.player2 = player2;
        this.sport = sport;

        // Need to change date to a user-selected time, using a pop-up calendar or something.
        this.date = Calendar.getInstance().getTime();
    }

    public String getSport() {
        return sport;
    }

    public User getPlayer1() {
        return player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public int getOutcome() {
        return outcome;
    }

    public boolean isInBracket() {
        return inBracket;
    }
}
