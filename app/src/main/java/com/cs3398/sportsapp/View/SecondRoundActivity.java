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

public class SecondRoundActivity extends AppCompatActivity {
    private Button round2ContinueButton, round2SaveButton;
    CheckBox user1, user2, user3, user4;
    String bracketName, player1, player2, player3, player4, player5,
            player6, player7, player8;
    String r1winner1, r1winner2, r1winner3, r1winner4;
    String r1loser1, r1loser2, r1loser3, r1loser4;
    String r2winner1, r2winner2;
    String r2loser1, r2loser2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_second_bracket);
        Intent intent = getIntent();
        round2ContinueButton = (Button)findViewById(R.id.second_round_continue);
        round2SaveButton = (Button)findViewById(R.id.second_round_save);
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

        user1 = (CheckBox)findViewById(R.id.second_round_player_1);
        user2 = (CheckBox)findViewById(R.id.second_round_player_2);
        user3 = (CheckBox)findViewById(R.id.second_round_player_3);
        user4 = (CheckBox)findViewById(R.id.second_round_player_4);

        user1.setText(r1winner1);
        user2.setText(r1winner2);
        user3.setText(r1winner3);
        user4.setText(r1winner4);

        checkBoxListeners2();

        round2ContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SecondRoundActivity.this,ThirdRoundActivity.class);
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
                intent.putExtra("userName", userName);

                startActivity(intent);
            }
        });

        round2SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondRoundActivity.this,BracketActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });
    }

    public void checkBoxListeners2() {
        user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    r2winner1 = user1.getText().toString();
                    r2loser1 = user2.getText().toString();
                }
            }
        });
        user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    r2winner1 = user2.getText().toString();
                    r2loser1 = user1.getText().toString();
                }
            }
        });
        user3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    r2winner2 = user3.getText().toString();
                    r2loser2 = user4.getText().toString();
                }
            }
        });
        user4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    r2winner2 = user4.getText().toString();
                    r2loser2 = user3.getText().toString();
                }
            }
        });
    }
}