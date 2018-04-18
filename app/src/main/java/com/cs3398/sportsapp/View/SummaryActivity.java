package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cs3398.sportsapp.Controller.BracketController;
import com.cs3398.sportsapp.Model.Bracket;
import com.cs3398.sportsapp.Model.DBHandlerBracket;
import com.cs3398.sportsapp.R;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {
    private Button summaryContinue;
    private TextView r1w1, r1w2, r1w3, r1w4, r1l1, r1l2, r1l3, r1l4,
            r2w1, r2w2, r2l1, r2l2, r3w, r3l;
    private String bracketName;

    private DBHandlerBracket databaseHelper;
    private Bracket bracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_winner);
        Intent intent = getIntent();
        databaseHelper = new DBHandlerBracket(SummaryActivity.this);
        bracket = new Bracket();

        bracketName = intent.getExtras().getString("bracketName");
        bracket = databaseHelper.getBracket(bracketName);

        summaryContinue = (Button) findViewById(R.id.summary_continue);
        r1w1 = (TextView) findViewById(R.id.summary_r1w1);
        r1w2 = (TextView) findViewById(R.id.summary_r1w2);
        r1w3 = (TextView) findViewById(R.id.summary_r1w3);
        r1w4 = (TextView) findViewById(R.id.summary_r1w4);
        r1l1 = (TextView) findViewById(R.id.summary_r1l1);
        r1l2 = (TextView) findViewById(R.id.summary_r1l2);
        r1l3 = (TextView) findViewById(R.id.summary_r1l3);
        r1l4 = (TextView) findViewById(R.id.summary_r1l4);
        r2w1 = (TextView) findViewById(R.id.summary_r2w1);
        r2w2 = (TextView) findViewById(R.id.summary_r2w2);
        r2l1 = (TextView) findViewById(R.id.summary_r2l1);
        r2l2 = (TextView) findViewById(R.id.summary_r2l2);
        r3w = (TextView) findViewById(R.id.summary_r3w1);
        r3l = (TextView) findViewById(R.id.summary_r3l1);

        r1w1.setText(bracketName);
        r1w2.setText(bracket.getR1winner2());
        r1w3.setText(bracket.getR1winner3());
        r1w4.setText(bracket.getR1winner4());
        r1l1.setText(bracket.getR1loser1());
        r1l2.setText(bracket.getR1loser2());
        r1l3.setText(bracket.getR1loser3());
        r1l4.setText(bracket.getR1loser4());
        r2w1.setText(bracket.getR2winner1());
        r2w2.setText(bracket.getR2winner2());
        r2l1.setText(bracket.getR2loser1());
        r2l2.setText(bracket.getR2loser2());
        r3w.setText(bracket.getFinalWinner());
        r3l.setText(bracket.getFinalLoser());


        summaryContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                ArrayList<String> currentBracketList = new ArrayList<String>();
                ArrayList<String> completedBracketList = new ArrayList<String>();
                currentBracketList.addAll(firstArrayList);
                completedBracketList.addAll(firstArrayList1);

                Intent intent = new Intent(SummaryActivity.this, BracketActivity.class);
                intent.putExtra("currentBracketList", currentBracketList);
                intent.putExtra("completedBracketList", completedBracketList);
                intent.putExtra("bracketName", bracketName);
                startActivity(intent);
            }
        });
    }
}