package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cs3398.sportsapp.Model.Bracket;
import com.cs3398.sportsapp.R;

import java.util.ArrayList;

public class BracketActivity extends AppCompatActivity {
    private Button newBracket, currentBracket, completedBracket, backBracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracket);
        final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
        final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

        ArrayList<String> currBracketList = new ArrayList<String>();
        final ArrayList<String> complBracketList = new ArrayList<String>();
        currBracketList.addAll(firstArrayList);
        complBracketList.addAll(firstArrayList1);

        final String bracketName = getIntent().getStringExtra("bracketName");
        newBracket = (Button)findViewById(R.id.newBracket);
        currentBracket = (Button)findViewById(R.id.current);
        completedBracket = (Button)findViewById(R.id.completed);
        backBracket = (Button)findViewById(R.id.backbracket);

        newBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                ArrayList<String> currentBracketList = new ArrayList<String>();
                currentBracketList.addAll(firstArrayList);
                ArrayList<String> completedBracketList = new ArrayList<String>();
                completedBracketList.addAll(firstArrayList1);

                Intent intent = new Intent(BracketActivity.this,NewBracketActivity.class);
                intent.putExtra("bracketName", bracketName);
                intent.putExtra("currentBracketList", currentBracketList);
                intent.putExtra("completedBracketList", completedBracketList);
                startActivity(intent);
            }
        });

        currentBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bracketName != null) {
                    final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                    final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                    ArrayList<String> currentBracketList = new ArrayList<String>();
                    currentBracketList.addAll(firstArrayList);
                    ArrayList<String> completedBracketList = new ArrayList<String>();
                    completedBracketList.addAll(firstArrayList1);

                    Intent intent = new Intent(BracketActivity.this, CurrentBracketsActivity.class);
                    intent.putExtra("bracketName", bracketName);
                    intent.putExtra("currentBracketList", currentBracketList);
                    intent.putExtra("completedBracketList", completedBracketList);
                    startActivity(intent);
                }
                else {
                    final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                    final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                    ArrayList<String> currentBracketList = new ArrayList<String>();
                    currentBracketList.addAll(firstArrayList);
                    ArrayList<String> completedBracketList = new ArrayList<String>();
                    completedBracketList.addAll(firstArrayList1);

                    Intent intent = new Intent(BracketActivity.this, BracketActivity.class);
                    intent.putExtra("currentBracketList", currentBracketList);
                    intent.putExtra("completedBracketList", completedBracketList);
                    startActivity(intent);
                }
            }
        });

        completedBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bracketName != null && complBracketList != null) {
                    final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                    final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                    ArrayList<String> currentBracketList = new ArrayList<String>();
                    currentBracketList.addAll(firstArrayList);
                    ArrayList<String> completedBracketList = new ArrayList<String>();
                    completedBracketList.addAll(firstArrayList1);

                    Intent intent = new Intent(BracketActivity.this, CompletedBracketsActivity.class);
                    intent.putExtra("bracketName", bracketName);
                    intent.putExtra("currentBracketList", currentBracketList);
                    intent.putExtra("completedBracketList", completedBracketList);
                    startActivity(intent);
                }
                else {
                    final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                    final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                    ArrayList<String> currentBracketList = new ArrayList<String>();
                    currentBracketList.addAll(firstArrayList);
                    ArrayList<String> completedBracketList = new ArrayList<String>();
                    completedBracketList.addAll(firstArrayList1);

                    Intent intent = new Intent(BracketActivity.this, BracketActivity.class);
                    intent.putExtra("bracketName", bracketName);
                    intent.putExtra("currentBracketList", currentBracketList);
                    intent.putExtra("completedBracketList", completedBracketList);
                    startActivity(intent);
                }
            }
        });

        backBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("currentBracketList");
                final ArrayList<String> firstArrayList1 = getIntent().getStringArrayListExtra("completedBracketList");

                ArrayList<String> currentBracketList = new ArrayList<String>();
                currentBracketList.addAll(firstArrayList);
                ArrayList<String> completedBracketList = new ArrayList<String>();
                completedBracketList.addAll(firstArrayList1);

                Intent intent = new Intent(BracketActivity.this,HomeActivity.class);
                intent.putExtra("bracketName", bracketName);
                intent.putExtra("currentBracketList", currentBracketList);
                intent.putExtra("completedBracketList", completedBracketList);
                startActivity(intent);
            }
        });
    }
}
