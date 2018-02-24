package com.cs3398.sportsapp.Model;

import java.util.ArrayList;

public class User {
    private int uID;
    private String userName;
    private String password;
    private ArrayList<String> sportsPreference;
    private int skillLevel;
    private int wins;
    private int losses;

    // In place of zip code
    private float latitude;
    private float longitude;

    //Change from String to 'Bracket' type
    private ArrayList<String> brackets;

    public int getuID() {
        return uID;
    }

    public String getUserName(){return userName;}
    public String getPassword(){return password;}

    public String getSportsPreference() {
        for (String s : sportsPreference) {
            // Will change as needed. Only returns first string for now.
            return s;
        }
        return "placeholder";
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public int getLosses() {
        return losses;
    }

    public int getWins() {
        return wins;
    }

    public ArrayList<String> getBracket() {
        return brackets;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public void addSportsPreference(String sportsPreference) {
        this.sportsPreference.add(sportsPreference);
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setBracket(ArrayList<String> bracket) {
        brackets = bracket;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setUserName(String Name){this.userName = Name;}

    public void setPassword(String Password){this.password = Password;}
}