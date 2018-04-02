package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.cs3398.sportsapp.R;

public class SecondRoundActivity extends AppCompatActivity {
    private Button round2ContinueButton;
    String name1, name2, name3, name4;
    CheckBox user1, user2, user3, user4;
    String winner1, winner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_second_bracket);
        Intent intent2 = getIntent();
        round2ContinueButton = (Button)findViewById(R.id.second_round_continue);

        name1 = intent2.getExtras().getString("winner1");
        name2 = intent2.getExtras().getString("winner2");
        name3 = intent2.getExtras().getString("winner3");
        name4 = intent2.getExtras().getString("winner4");

        user1 = (CheckBox)findViewById(R.id.second_round_player_1);
        user2 = (CheckBox)findViewById(R.id.second_round_player_2);
        user3 = (CheckBox)findViewById(R.id.second_round_player_3);
        user4 = (CheckBox)findViewById(R.id.second_round_player_4);

        user1.setText(name1);
        user2.setText(name2);
        user3.setText(name3);
        user4.setText(name4);

        checkBoxListeners2();

        round2ContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SecondRoundActivity.this,ThirdRoundActivity.class);
                intent.putExtra("winner1", winner1);
                intent.putExtra("winner2", winner2);
                startActivity(intent);
            }
        });
    }

    public void checkBoxListeners2() {
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
    }
}