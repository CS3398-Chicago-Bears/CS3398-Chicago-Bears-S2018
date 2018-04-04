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

import java.util.ArrayList;


public class FirstRoundActivity extends AppCompatActivity {
    private Button round1ContinueButton, round1SaveButton;
    private CheckBox user1, user2, user3, user4, user5, user6, user7, user8;
    String bracketName, name1, name2, name3, name4, name5, name6, name7, name8;
    String winner1, winner2, winner3, winner4;
    String loser1, loser2, loser3, loser4;

    ArrayList<Bracket> bracketList = new ArrayList<Bracket>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_first_bracket);
        Intent intent = getIntent();
        round1ContinueButton = (Button)findViewById(R.id.first_round_continue);
        round1SaveButton = (Button)findViewById(R.id.first_round_save);

        bracketName = intent.getExtras().getString("bracketName");
        name1 = intent.getExtras().getString("player1");
        name2 = intent.getExtras().getString("player2");
        name3 = intent.getExtras().getString("player3");
        name4 = intent.getExtras().getString("player4");
        name5 = intent.getExtras().getString("player5");
        name6 = intent.getExtras().getString("player6");
        name7 = intent.getExtras().getString("player7");
        name8 = intent.getExtras().getString("player8");

        user1 = (CheckBox) findViewById(R.id.first_round_player_1);
        user2 = (CheckBox) findViewById(R.id.first_round_player_2);
        user3 = (CheckBox) findViewById(R.id.first_round_player_3);
        user4 = (CheckBox) findViewById(R.id.first_round_player_4);
        user5 = (CheckBox) findViewById(R.id.first_round_player_5);
        user6 = (CheckBox) findViewById(R.id.first_round_player_6);
        user7 = (CheckBox) findViewById(R.id.first_round_player_7);
        user8 = (CheckBox) findViewById(R.id.first_round_player_8);

        //user1.setTextColor(Color.RED);
        user1.setText(name1);
        user2.setText(name2);
        user3.setText(name3);
        user4.setText(name4);
        user5.setText(name5);
        user6.setText(name6);
        user7.setText(name7);
        user8.setText(name8);

        checkBoxListeners();

        round1ContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Bracket newBracket = new Bracket(bracketName, name1, name2, name3, name4, name5,
                        name6, name7, name8, winner1, winner2, winner3, winner4, "", "",
                        loser1, loser2, loser3, loser4, "", "");
                bracketList.add(newBracket);
                Bundle bundle = new Bundle();
                bundle.putSerializable("brackets", bracketList);
                */
                Intent intent = new Intent(FirstRoundActivity.this, SecondRoundActivity.class);
                intent.putExtra("bracketName", bracketName);
                intent.putExtra("player1", name1);
                intent.putExtra("player2", name2);
                intent.putExtra("player3", name3);
                intent.putExtra("player4", name4);
                intent.putExtra("player5", name5);
                intent.putExtra("player6", name6);
                intent.putExtra("player7", name7);
                intent.putExtra("player8", name8);
                intent.putExtra("r1winner1", winner1);
                intent.putExtra("r1winner2", winner2);
                intent.putExtra("r1winner3", winner3);
                intent.putExtra("r1winner4", winner4);
                intent.putExtra("r1loser1", loser1);
                intent.putExtra("r1loser2", loser2);
                intent.putExtra("r1loser3", loser3);
                intent.putExtra("r1loser4", loser4);
                //intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        round1SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstRoundActivity.this, BracketActivity.class);
                startActivity(intent);
            }
        });
    }

    public void checkBoxListeners() {
        user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner1 = user1.getText().toString();
                    loser1 = user2.getText().toString();
                }
            }
        });
        user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner1 = user2.getText().toString();
                    loser1 = user1.getText().toString();
                }
            }
        });
        user3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner2 = user3.getText().toString();
                    loser2 = user4.getText().toString();
                }
            }
        });
        user4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner2 = user4.getText().toString();
                    loser2 = user3.getText().toString();
                }
            }
        });
        user5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner3 = user5.getText().toString();
                    loser3 = user6.getText().toString();
                }
            }
        });
        user6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner3 = user6.getText().toString();
                    loser3 = user5.getText().toString();
                }
            }
        });
        user7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner4 = user7.getText().toString();
                    loser4 = user8.getText().toString();
                }
            }
        });
        user8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner4 = user8.getText().toString();
                    loser4 = user7.getText().toString();
                }
            }
        });
    }
}