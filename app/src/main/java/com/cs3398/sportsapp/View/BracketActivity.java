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


        final String bracketName = getIntent().getStringExtra("bracketName");


        newBracket = (Button)findViewById(R.id.newBracket);
        currentBracket = (Button)findViewById(R.id.current);
        completedBracket = (Button)findViewById(R.id.completed);
        backBracket = (Button)findViewById(R.id.backbracket);

        newBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("bracketList");

                ArrayList<String> bracketList = new ArrayList<String>();
                bracketList.addAll(firstArrayList);
                Intent intent = new Intent(BracketActivity.this, NewBracketActivity.class);
                intent.putExtra("bracketName", bracketName);
                intent.putExtra("bracketList", bracketList);
                startActivity(intent);
            }
        });

        currentBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("bracketList");

                ArrayList<String> bracketList = new ArrayList<String>();
                bracketList.addAll(firstArrayList);
                Intent intent = new Intent(BracketActivity.this, CurrentBracketsActivity.class);
                intent.putExtra("bracketName", bracketName);
                intent.putExtra("bracketList", bracketList);
                startActivity(intent);
            }
        });

        completedBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("bracketList");

                ArrayList<String> bracketList = new ArrayList<String>();
                bracketList.addAll(firstArrayList);
                Intent intent = new Intent(BracketActivity.this, CompletedBracketsActivity.class);
                intent.putExtra("bracketName", bracketName);
                intent.putExtra("bracketList", bracketList);
                startActivity(intent);
            }
        });

        backBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> firstArrayList = getIntent().getStringArrayListExtra("bracketList");

                ArrayList<String> bracketList = new ArrayList<String>();
                bracketList.addAll(firstArrayList);
                Intent intent = new Intent(BracketActivity.this, HomeActivity.class);
                intent.putExtra("bracketName", bracketName);
                intent.putExtra("bracketList", bracketList);
                startActivity(intent);
            }
        });
    }
}
