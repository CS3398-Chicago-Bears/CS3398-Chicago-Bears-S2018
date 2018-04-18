package com.cs3398.sportsapp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;

import com.cs3398.sportsapp.Controller.AuthenticateLogIn;
import com.cs3398.sportsapp.Model.Bracket;
import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private EditText name, password;
    private Button login, createNewAccount;
    public static DBHandler databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AuthenticateLogIn authenticator = new AuthenticateLogIn();


        name = (EditText)findViewById(R.id.etUserName);
        password = (EditText)findViewById(R.id.etPassword);
        login = (Button)findViewById(R.id.login);
        createNewAccount = (Button)findViewById(R.id.newAccount);
        databaseHelper = new DBHandler(MainActivity.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            verifyFromSQLite();
            }
        });

        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view) {
            Intent intent = new Intent(MainActivity.this,CreateAccountActivity.class);
            startActivity(intent);
            }
        });


    }
    private void verifyFromSQLite(){
        NestedScrollView nestedScrollView = (NestedScrollView)findViewById(R.id.nestedScrollView);

        if(databaseHelper.checkUser(name.getText().toString(), password.getText().toString())){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            intent.putExtra("userName", name.getText().toString());
            startActivity(intent);
        }
        else{
            Snackbar.make(nestedScrollView, getString(R.string.error_valid_name_password), Snackbar.LENGTH_LONG).show();
        }
    }
}
