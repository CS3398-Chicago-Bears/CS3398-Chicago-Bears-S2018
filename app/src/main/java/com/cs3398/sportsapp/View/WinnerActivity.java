package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cs3398.sportsapp.Controller.BracketController;
import com.cs3398.sportsapp.R;

public class WinnerActivity extends AppCompatActivity {
    private Button winnerButton;
    TextView winnerFinal;
    String bracketName, player1, player2, player3, player4, player5,
            player6, player7, player8;
    String r1winner1, r1winner2, r1winner3, r1winner4;
    String r1loser1, r1loser2, r1loser3, r1loser4;
    String r2winner1, r2winner2;
    String r2loser1, r2loser2;
    String r3winner, r3loser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_bracket);
        Intent intent = getIntent();
        winnerButton = (Button) findViewById(R.id.winner_button);
        final String userName = getIntent().getStringExtra("userName");

        bracketName = intent.getExtras().getString("bracketName");
        player1 = intent.getExtras().getString("player1");
        player2 = intent.getExtras().getString("player2");
        player3 = intent.getExtras().getString("player3");
        player4 = intent.getExtras().getString("player4");
        player5 = intent.getExtras().getString("player5");
        player6 = intent.getExtras().getString("player6");
        player7 = intent.getExtras().getString("player7");
        player8 = intent.getExtras().getString("player8");
        r1winner1 = intent.getExtras().getString("r1winner1");
        r1winner2 = intent.getExtras().getString("r1winner2");
        r1winner3 = intent.getExtras().getString("r1winner3");
        r1winner4 = intent.getExtras().getString("r1winner4");
        r1loser1 = intent.getExtras().getString("r1loser1");
        r1loser2 = intent.getExtras().getString("r1loser2");
        r1loser3 = intent.getExtras().getString("r1loser3");
        r1loser4 = intent.getExtras().getString("r1loser4");
        r2winner1 = intent.getExtras().getString("r2winner1");
        r2winner2 = intent.getExtras().getString("r2winner2");
        r2loser1 = intent.getExtras().getString("r2loser1");
        r2loser2 = intent.getExtras().getString("r2loser2");
        r3winner = intent.getExtras().getString("final_winner");
        r3loser = intent.getExtras().getString("final_loser");

        winnerFinal = (TextView) findViewById(R.id.winner_bracket);

        winnerFinal.setText(r3winner);

        winnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(WinnerActivity.this, BracketActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });
    }
}