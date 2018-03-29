package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.cs3398.sportsapp.R;

public class FirstRoundActivity extends AppCompatActivity {
    private Button round1ContinueButton;
    String name1, name2, name3, name4, name5, name6, name7, name8;
    private CheckBox user1, user2, user3, user4, user5, user6, user7, user8;
    String winner1, winner2, winner3, winner4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_first_bracket);
        Intent intent = getIntent();
        round1ContinueButton = (Button) findViewById(R.id.first_round_continue);

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
                /*if (user1.isChecked())
                    winner1 = user1.getText().toString();
                else
                    winner1 = user2.getText().toString();
                if (user3.isChecked())
                    winner2 = user3.getText().toString();
                else
                    winner2 = user4.getText().toString();
                if (user5.isChecked())
                    winner3 = user5.getText().toString();
                else
                    winner3 = user6.getText().toString();
                if (user7.isChecked())
                    winner4 = user7.getText().toString();
                else
                    winner4 = user8.getText().toString();
*/
                Intent intent = new Intent(FirstRoundActivity.this, SecondRoundActivity.class);
                intent.putExtra("winner1", winner1);
                intent.putExtra("winner2", winner2);
                intent.putExtra("winner3", winner3);
                intent.putExtra("winner4", winner4);

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
                }
            }
        });
        user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner1 = user2.getText().toString();
                }
            }
        });
        user3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner2 = user3.getText().toString();
                }
            }
        });
        user4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner2 = user4.getText().toString();
                }
            }
        });
        user5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner3 = user5.getText().toString();
                }
            }
        });
        user6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner3 = user6.getText().toString();
                }
            }
        });
        user7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner4 = user7.getText().toString();
                }
            }
        });
        user8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    winner4 = user8.getText().toString();
                }
            }
        });
    }
}