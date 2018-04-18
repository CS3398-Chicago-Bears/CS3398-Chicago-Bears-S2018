package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.cs3398.sportsapp.Controller.BracketController;
import com.cs3398.sportsapp.Model.Bracket;
import com.cs3398.sportsapp.Model.DBHandlerBracket;
import com.cs3398.sportsapp.R;

import java.util.ArrayList;

public class SavedThirdRoundActivity extends AppCompatActivity {
    private Button round3ContinueButton, round3SaveButton;
    private CheckBox user1, user2;
    private String bracketName, player1, player2, player3, player4, player5,
            player6, player7, player8;
    private String r1winner1, r1winner2, r1winner3, r1winner4;
    private String r1loser1, r1loser2, r1loser3, r1loser4;
    private String r2winner1, r2winner2;
    private String r2loser1, r2loser2;
    private String r3winner, r3loser;
    private int currentRound = 3;
    private DBHandlerBracket databaseHelper;
    private Bracket bracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_round_3);
        bracket = new Bracket();

        Intent intent = getIntent();
        bracketName = intent.getExtras().getString("bracketName");
        databaseHelper = new DBHandlerBracket(SavedThirdRoundActivity.this);
        bracket = databaseHelper.getBracket(bracketName);

        player1 = bracket.getPlayer1();
        player2 = bracket.getPlayer2();
        player3 = bracket.getPlayer3();
        player4 = bracket.getPlayer4();
        player5 = bracket.getPlayer5();
        player6 = bracket.getPlayer6();
        player7 = bracket.getPlayer7();
        player8 = bracket.getPlayer8();
        r1winner1 = bracket.getR1winner1();
        r1winner2 = bracket.getR1winner2();
        r1winner3 = bracket.getR1winner3();
        r1winner4 = bracket.getR1winner4();
        r1loser1 = bracket.getR1loser1();
        r1loser2 = bracket.getR1loser2();
        r1loser3 = bracket.getR1loser3();
        r1loser4 = bracket.getR1loser4();
        r2winner1 = bracket.getR2winner1();
        r2winner2 = bracket.getR2winner2();
        r2loser1 = bracket.getR2loser1();
        r2loser2 = bracket.getR2loser2();

        round3ContinueButton = (Button)findViewById(R.id.saved_third_round_continue);
        round3SaveButton = (Button)findViewById(R.id.saved_third_round_save);

        user1 = (CheckBox)findViewById(R.id.saved_third_round_player_1);
        user2 = (CheckBox)findViewById(R.id.saved_third_round_player_2);

        user1.setText(r2winner1);
        user2.setText(r2winner2);

        checkBoxListeners3();

        round3ContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                ArrayList<String> currentBracketList = new ArrayList<String>();
                ArrayList<String> completedBracketList = new ArrayList<String>();
                currentBracketList.addAll(firstArrayList);
                completedBracketList.addAll(firstArrayList1);

                Intent intent = new Intent(SavedThirdRoundActivity.this,WinnerActivity.class);
                intent.putExtra("currentBracketList", currentBracketList);
                intent.putExtra("completedBracketList", completedBracketList);
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

        bracket = new Bracket();
        databaseHelper = new DBHandlerBracket(SavedThirdRoundActivity.this);
        round3SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");
                int addIndex = 0;

                ArrayList<String> currentBracketList = new ArrayList<String>();
                ArrayList<String> completedBracketList = new ArrayList<String>();
                currentBracketList.addAll(firstArrayList);
                completedBracketList.addAll(firstArrayList1);

                for(String str : currentBracketList) {
                    if(str.equals(bracketName)) { addIndex = 1; }
                    break;
                }
                if(addIndex != 1) { currentBracketList.add(bracketName); }

                bracket.setBracketName(bracketName);
                bracket.setPlayer1(player1);
                bracket.setPlayer2(player2);
                bracket.setPlayer3(player3);
                bracket.setPlayer4(player4);
                bracket.setPlayer5(player5);
                bracket.setPlayer6(player6);
                bracket.setPlayer7(player7);
                bracket.setPlayer8(player8);
                bracket.setR1winner1(r1winner1);
                bracket.setR1winner2(r1winner2);
                bracket.setR1winner3(r1winner3);
                bracket.setR1winner4(r1winner4);
                bracket.setR1loser1(r1loser1);
                bracket.setR1loser2(r1loser2);
                bracket.setR1loser3(r1loser3);
                bracket.setR1loser4(r1loser4);
                bracket.setR2winner1(r2winner1);
                bracket.setR2winner2(r2winner2);
                bracket.setR2loser1(r2loser1);
                bracket.setR2loser2(r2loser2);
                bracket.setFinalWinner("");
                bracket.setFinalLoser("");
                bracket.setCurrentRound(currentRound);
                databaseHelper.updateBracket(bracket);

                Intent intent = new Intent(SavedThirdRoundActivity.this,BracketActivity.class);
                intent.putExtra("bracketName", bracketName);
                intent.putExtra("currentBracketList", currentBracketList);
                intent.putExtra("completedBracketList", completedBracketList);
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