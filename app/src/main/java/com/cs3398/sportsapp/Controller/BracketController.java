package com.cs3398.sportsapp.Controller;

import java.util.ArrayList;
import java.util.Scanner;
import com.cs3398.sportsapp.Model.*;

public class BracketController {
    static ArrayList<Bracket> currentBrackets = new ArrayList<>();
    static ArrayList<Bracket> completedBrackets = new ArrayList<>();

    public ArrayList<Bracket> getCurrentBrackets() {
        return currentBrackets;
    }
    public ArrayList<Bracket> getCompletedBrackets() {
        return completedBrackets;
    }

    public static void addCurrentBrackets(Bracket bracket) {
        currentBrackets.add(bracket);
    }
    public void addCompletedBrackets(Bracket bracket) {
        //search for index by name, then remove index
        int i = 0;
        int tempIndex = 0;
        for (Bracket b : currentBrackets) {
            if(b.getBracketName() == bracket.getBracketName())
                    tempIndex = i;
        }
        currentBrackets.remove(i);
        completedBrackets.add(bracket);
    }
}
