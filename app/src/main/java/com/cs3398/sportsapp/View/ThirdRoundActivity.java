package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.cs3398.sportsapp.Controller.BracketController;
import com.cs3398.sportsapp.Model.Bracket;
import com.cs3398.sportsapp.R;

public class ThirdRoundActivity extends AppCompatActivity {
    private Button round3ContinueButton, round3SaveButton;
    CheckBox user1, user2;
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
        setContentView(R.layout.activity_round_third_bracket);
        Intent intent = getIntent();
        round3ContinueButton = (Button)findViewById(R.id.third_round_continue);
        round3SaveButton = (Button)findViewById(R.id.third_round_save);

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

        user1 = (CheckBox)findViewById(R.id.third_round_player_1);
        user2 = (CheckBox)findViewById(R.id.third_round_player_2);

        user1.setText(r2winner1);
        user2.setText(r2winner2);

        checkBoxListeners3();

        round3ContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ThirdRoundActivity.this,WinnerActivity.class);
                intent.putExtra("bracketName", bracketName);
                intent.putExtra("player1", player1);
                intent.putExtra("player2", player2);
                intent.putExtra("player3", player3);
                intent.putExtra("player4", player4);
                intent.putExtra("player5", player5);
                intent.putExtra("player6", player6);
                intent.putExtra("player7", player7);
                intent.putExtra("player8", player8);
                intent.putExtra("r1winner1", r1winner1);
                intent.putExtra("r1winner2", r1winner2);
                intent.putExtra("r1winner3", r1winner3);
                intent.putExtra("r1winner4", r1winner4);
                intent.putExtra("r1loser1", r1loser1);
                intent.putExtra("r1loser2", r1loser2);
                intent.putExtra("r1loser3", r1loser3);
                intent.putExtra("r1loser4", r1loser4);
                intent.putExtra("r2winner1", r2winner1);
                intent.putExtra("r2winner2", r2winner2);
                intent.putExtra("r2loser1", r2loser1);
                intent.putExtra("r2loser2", r2loser2);
                intent.putExtra("final_winner", r3winner);
                intent.putExtra("final_loser", r3loser);

                startActivity(intent);
            }
        });
        round3SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdRoundActivity.this,BracketActivity.class);
                startActivity(intent);
            }
        });
    }

    public void checkBoxListeners3() {
        user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    r3winner = user1.getText().toString();
                    r3loser = user2.getText().toString();
                }
            }
        });
        user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    r3winner = user2.getText().toString();
                    r3loser = user1.getText().toString();
                }
            }
        });
    }
}