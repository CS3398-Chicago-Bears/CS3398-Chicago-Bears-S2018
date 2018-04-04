package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cs3398.sportsapp.R;

public class CurrentBracketsActivity extends AppCompatActivity {
    private Button backCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_brackets);

        backCurrent = (Button)findViewById(R.id.current_bracket_back);

        backCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CurrentBracketsActivity.this, BracketActivity.class);
                startActivity(intent);
            }
        });    }
}
