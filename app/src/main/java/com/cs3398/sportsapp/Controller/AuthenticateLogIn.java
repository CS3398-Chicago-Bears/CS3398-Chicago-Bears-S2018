package com.cs3398.sportsapp.Controller;



public class AuthenticateLogIn {

    public boolean validate(String uName, String pWord){
        if(uName.equals("Admin") && pWord.equals("Admin")){
            return true;
        }
        else
            return false;
    }

}
