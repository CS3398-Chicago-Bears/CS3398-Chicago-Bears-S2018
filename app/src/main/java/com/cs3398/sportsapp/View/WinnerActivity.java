package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.cs3398.sportsapp.Model.Bracket;
import com.cs3398.sportsapp.Model.DBHandlerBracket;
import com.cs3398.sportsapp.R;

import java.util.ArrayList;

public class WinnerActivity extends AppCompatActivity {
    private Button winnerButton;
    private TextView winnerFinal;
    private String bracketName, player1, player2, player3, player4, player5,
            player6, player7, player8;
    private String r1winner1, r1winner2, r1winner3, r1winner4;
    private String r1loser1, r1loser2, r1loser3, r1loser4;
    private String r2winner1, r2winner2;
    private String r2loser1, r2loser2;
    private String r3winner, r3loser;
    private int currentRound = 4;
    private DBHandlerBracket databaseHelper;
    private Bracket bracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_bracket);
        Intent intent = getIntent();
        winnerButton = (Button) findViewById(R.id.winner_button);

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
        bracket = new Bracket();
        databaseHelper = new DBHandlerBracket(WinnerActivity.this);
        winnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                ArrayList<String> currentBracketList = new ArrayList<String>();
                ArrayList<String> completedBracketList = new ArrayList<String>();
                currentBracketList.addAll(firstArrayList);
                completedBracketList.addAll(firstArrayList1);

                currentBracketList.remove(bracketName);
                completedBracketList.add(bracketName);

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
                bracket.setFinalWinner(r3winner);
                bracket.setFinalLoser(r3loser);
                bracket.setCurrentRound(currentRound);
                databaseHelper.updateBracket(bracket);

                Intent intent = new Intent(WinnerActivity.this, BracketActivity.class);
                intent.putExtra("bracketName", bracketName);
                intent.putStringArrayListExtra("currentBracketList", currentBracketList);
                intent.putStringArrayListExtra("completedBracketList", completedBracketList);
                startActivity(intent);
            }
        });
    }
}