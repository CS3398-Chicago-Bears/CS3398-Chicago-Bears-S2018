package com.cs3398.sportsapp.Model;

import java.util.ArrayList;

public class User {
    private int uID;
    private String userName;
    private String password;
    private ArrayList<String> sportsPreference = new ArrayList<String>();
    private String skillLevel;
    private int wins;
    private int losses;

    // In place of zip code
    private double latitude;
    private double longitude;

    //Change from String to 'Bracket' type
    private ArrayList<String> brackets;

    public int getuID() {
        return uID;
    }

    public String getUserName(){return userName;}
    public String getPassword(){return password;}

    public String getSportsPreference() {
        StringBuilder sports = new StringBuilder();
        for(int i = 0; i < sportsPreference.size(); i++) {
            sports.append(sportsPreference.get(i));
            if (i != sportsPreference.size() - 1) {
                sports.append("\n");
            }
        }

        return sports.toString();
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
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

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
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