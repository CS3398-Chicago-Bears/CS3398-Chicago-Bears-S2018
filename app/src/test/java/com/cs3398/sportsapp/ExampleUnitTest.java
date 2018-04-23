package com.cs3398.sportsapp;

import com.cs3398.sportsapp.Controller.AuthenticateLogIn;
import com.cs3398.sportsapp.Model.User;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void user_isCorrect() throws Exception {
        User user = new User();

        String name = "jeff";
        user.setUserName(name);
        assertEquals(name, user.getUserName());
    }

    @Test
    public void user_isIncorrect() throws Exception {
        User user = new User();
        String name = "Jeff";
        String name2 = "Miguel";
        user.setUserName(name);
        assertNotEquals(name2, user.getUserName());
    }

    @Test
    public void validate_user_isTrue() throws Exception {
        AuthenticateLogIn auth = new AuthenticateLogIn();
        String name = "Admin";
        String pass = "Admin";

        assertTrue(auth.validate(name, pass));
    }

    @Test
    public void validate_user_isFalse() throws Exception {
        AuthenticateLogIn auth = new AuthenticateLogIn();
        String name = "Admin";
        String pass = "Not Admin";

        assertFalse(auth.validate(name, pass));
    }
}