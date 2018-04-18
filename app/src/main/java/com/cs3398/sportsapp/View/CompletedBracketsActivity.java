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

public class CompletedBracketsActivity extends AppCompatActivity {
    private Button backCurrent, continueCurrent;
    private String bracketName;
    private DBHandlerBracket databaseHelper;
    private Bracket bracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_brackets);

        databaseHelper = new DBHandlerBracket(CompletedBracketsActivity.this);
        bracket = new Bracket();

        final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("completedBracketList");

        ArrayList<String> bList = new ArrayList<String>();
        bList.addAll(firstArrayList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bList);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.completed_bracket_spinner);
        sItems.setAdapter(adapter);

        bracketName = sItems.getSelectedItem().toString();
        bracket = databaseHelper.getBracket(bracketName);

        continueCurrent = (Button)findViewById(R.id.completed_bracket_continue);
        backCurrent = (Button)findViewById(R.id.completed_bracket_back);



        continueCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                ArrayList<String> currentBracketList = new ArrayList<String>();
                ArrayList<String> completedBracketList = new ArrayList<String>();
                currentBracketList.addAll(firstArrayList);
                completedBracketList.addAll(firstArrayList1);

            Intent intent = new Intent(CompletedBracketsActivity.this, BracketActivity.class);
            intent.putExtra("currentBracketList", currentBracketList);
            intent.putExtra("completedBracketList", completedBracketList);
            intent.putExtra("bracketName", bracketName);
            startActivity(intent);
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

            Intent intent = new Intent(CompletedBracketsActivity.this, BracketActivity.class);
            intent.putExtra("currentBracketList", currentBracketList);
            intent.putExtra("completedBracketList", completedBracketList);
            intent.putExtra("bracketName", bracketName);
            startActivity(intent);
            }
        });
    }
}
