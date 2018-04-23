package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.cs3398.sportsapp.Model.Bracket;
import com.cs3398.sportsapp.Model.DBHandlerBracket;
import com.cs3398.sportsapp.R;

import java.util.ArrayList;

public class CurrentBracketsActivity extends AppCompatActivity {
    private Button backCurrent, continueCurrent;
    private String bracketName;
    private DBHandlerBracket databaseHelper;
    private Bracket bracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_brackets);
        final String userName = getIntent().getStringExtra("userName");

        databaseHelper = new DBHandlerBracket(CurrentBracketsActivity.this);
        bracket = new Bracket();

        final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");

        ArrayList<String> bList = new ArrayList<String>();
        bList.addAll(firstArrayList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bList);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.current_bracket_spinner);
        sItems.setAdapter(adapter);

        bracketName = sItems.getSelectedItem().toString();
        bracket = databaseHelper.getBracket(bracketName);

        continueCurrent = (Button)findViewById(R.id.current_bracket_continue);
        backCurrent = (Button)findViewById(R.id.current_bracket_back);



        continueCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bracket.getCurrentRound() == 1) {
                    final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                    final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                    ArrayList<String> currentBracketList = new ArrayList<String>();
                    ArrayList<String> completedBracketList = new ArrayList<String>();
                    currentBracketList.addAll(firstArrayList);
                    completedBracketList.addAll(firstArrayList1);

                    Intent intent = new Intent(CurrentBracketsActivity.this, SavedFirstRoundActivity.class);
                    intent.putExtra("currentBracketList", currentBracketList);
                    intent.putExtra("completedBracketList", completedBracketList);
                    intent.putExtra("bracketName", bracketName);
                    intent.putExtra("userName", userName);
                    startActivity(intent);
                }
                else if(bracket.getCurrentRound() == 2) {
                    final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                    final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                    ArrayList<String> currentBracketList = new ArrayList<String>();
                    ArrayList<String> completedBracketList = new ArrayList<String>();
                    currentBracketList.addAll(firstArrayList);
                    completedBracketList.addAll(firstArrayList1);

                    Intent intent = new Intent(CurrentBracketsActivity.this, SavedSecondRoundActivity.class);
                    intent.putExtra("currentBracketList", currentBracketList);
                    intent.putExtra("completedBracketList", completedBracketList);
                    intent.putExtra("bracketName", bracketName);
                    intent.putExtra("userName", userName);
                    startActivity(intent);
                }
                else if(bracket.getCurrentRound() == 3) {
                    final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                    final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                    ArrayList<String> currentBracketList = new ArrayList<String>();
                    ArrayList<String> completedBracketList = new ArrayList<String>();
                    currentBracketList.addAll(firstArrayList);
                    completedBracketList.addAll(firstArrayList1);

                    Intent intent = new Intent(CurrentBracketsActivity.this, SavedThirdRoundActivity.class);
                    intent.putExtra("currentBracketList", currentBracketList);
                    intent.putExtra("completedBracketList", completedBracketList);
                    intent.putExtra("bracketName", bracketName);
                    intent.putExtra("userName", userName);
                    startActivity(intent);
                }
            }
        });

        backCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                ArrayList<String> currentBracketList = new ArrayList<String>();
                ArrayList<String> completedBracketList = new ArrayList<String>();
                currentBracketList.addAll(firstArrayList);
                completedBracketList.addAll(firstArrayList1);

                Intent intent = new Intent(CurrentBracketsActivity.this, BracketActivity.class);
                intent.putExtra("currentBracketList", currentBracketList);
                intent.putExtra("completedBracketList", completedBracketList);
                intent.putExtra("bracketName", bracketName);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });
    }
}
