package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import com.cs3398.sportsapp.R;

public class FirstRoundActivity extends AppCompatActivity {
    String name1, name2, name3, name4, name5, name6, name7, name8;
    CheckBox user1, user2, user3, user4, user5, user6, user7, user8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_first_bracket);
        Intent intent = getIntent();

        name1 = intent.getExtras().getString("player1");
        name2 = intent.getExtras().getString("player2");
        name3 = intent.getExtras().getString("player3");
        name4 = intent.getExtras().getString("player4");
        name5 = intent.getExtras().getString("player5");
        name6 = intent.getExtras().getString("player6");
        name7 = intent.getExtras().getString("player7");
        name8 = intent.getExtras().getString("player8");

        user1 = (CheckBox)findViewById(R.id.first_round_player_1);
        user2 = (CheckBox)findViewById(R.id.first_round_player_2);
        user3 = (CheckBox)findViewById(R.id.first_round_player_3);
        user4 = (CheckBox)findViewById(R.id.first_round_player_4);
        user5 = (CheckBox)findViewById(R.id.first_round_player_5);
        user6 = (CheckBox)findViewById(R.id.first_round_player_6);
        user7 = (CheckBox)findViewById(R.id.first_round_player_7);
        user8 = (CheckBox)findViewById(R.id.first_round_player_8);

        //user1.setTextColor(Color.RED);
        user1.setText(name1);
        user2.setText(name2);
        user3.setText(name3);
        user4.setText(name4);
        user5.setText(name5);
        user6.setText(name6);
        user7.setText(name7);
        user8.setText(name8);



    }
}
/*
public void selectItem(View view){
    boolean checked = ((CheckBox) view).isChecked();
    switch (view.getId()){
        case R.id.first_round_player_1:
            if(checked) {
                selection.add("Player 1");

            }
    }
    */

