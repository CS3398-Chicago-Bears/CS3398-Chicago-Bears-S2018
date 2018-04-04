package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cs3398.sportsapp.R;

public class BracketActivity extends AppCompatActivity {
    private Button newBracket, currentBracket, completedBracket, backBracket;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracket);
        final String userName = getIntent().getStringExtra("userName");

        newBracket = (Button)findViewById(R.id.newBracket);
        currentBracket = (Button)findViewById(R.id.current);
        completedBracket = (Button)findViewById(R.id.completed);
        backBracket = (Button)findViewById(R.id.backbracket);

        newBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BracketActivity.this, NewBracketActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });

        currentBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BracketActivity.this, CurrentBracketsActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });

        completedBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BracketActivity.this, CompletedBracketsActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });

        backBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BracketActivity.this, HomeActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });
    }
}
