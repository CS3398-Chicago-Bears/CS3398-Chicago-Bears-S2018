package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cs3398.sportsapp.R;

public class CompletedBracketsActivity extends AppCompatActivity {
    private Button backCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_brackets);
        final String userName = getIntent().getStringExtra("userName");

        backCompleted= (Button)findViewById(R.id.completed_bracket_back);

        backCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CompletedBracketsActivity.this, BracketActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });
    }
}
