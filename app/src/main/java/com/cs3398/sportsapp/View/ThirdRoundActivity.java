package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.cs3398.sportsapp.R;

public class ThirdRoundActivity extends AppCompatActivity {
    private Button round3ContinueButton;
    String name1, name2;
    CheckBox user1, user2;
    String winner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_third_bracket);
        Intent intent3 = getIntent();
        round3ContinueButton = (Button)findViewById(R.id.third_round_continue);

        name1 = intent3.getExtras().getString("winner1");
        name2 = intent3.getExtras().getString("winner2");

        user1 = (CheckBox)findViewById(R.id.third_round_player_1);
        user2 = (CheckBox)findViewById(R.id.third_round_player_2);

        user1.setText(name1);
        user2.setText(name2);

        checkBoxListeners3();

        round3ContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ThirdRoundActivity.this,WinnerActivity.class);
                intent.putExtra("final_winner", winner1);
                startActivity(intent);
            }
        });
    }

    public void checkBoxListeners3() {
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
    }
}