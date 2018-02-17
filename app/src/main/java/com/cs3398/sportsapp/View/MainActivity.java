package com.cs3398.sportsapp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import com.cs3398.sportsapp.Controller.AuthenticateLogIn;
import com.cs3398.sportsapp.R;

public class MainActivity extends AppCompatActivity {
    private EditText name, password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AuthenticateLogIn authenticator = new AuthenticateLogIn();

        name = (EditText)findViewById(R.id.etUserName);
        password = (EditText)findViewById(R.id.etPassword);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(authenticator.validate(name.getText().toString(),password.getText().toString())){
                    Intent intent = new Intent(MainActivity.this,Home.class);
                    startActivity(intent);
                }
            }
        });
    }
}
