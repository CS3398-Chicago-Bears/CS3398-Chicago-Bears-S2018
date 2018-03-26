package com.cs3398.sportsapp.Controller;

import java.util.ArrayList;
import java.util.Scanner;
import com.cs3398.sportsapp.Model.*;

public class BracketController {
    private String inputName;

    Scanner sc = new Scanner(System.in);
    ArrayList<String> PlayerList = new ArrayList<>();

    public void setUserList(ArrayList userList) {
        PlayerList = userList;
    }

    public ArrayList<String> getUserList() {
        return PlayerList;
    }

    public void addUser() {
        /*User User1 = new User();
        System.out.println("Enter a name");
        inputName = sc.nextLine();
        User1.setUserName(inputName);

        PlayerList.add(inputName);
        */
    }

    public void createBracket() {

    }
}
