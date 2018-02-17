package com.cs3398.sportsapp.Controller;

import java.util.ArrayList;
import java.util.Scanner;
import com.cs3398.sportsapp.Model.*;

public class BracketController {
    private User User;
    private String inputName;

    Scanner sc = new Scanner(System.in);
    ArrayList<User> UserList = new ArrayList<User>();

    public void addUser() {
        User User1 = new User();
        System.out.println("Enter a name");
        inputName = sc.nextLine();
        User1.setFirstName(inputName);

        UserList.add(User1);
    }


    public void createBracket() {

    }

}
