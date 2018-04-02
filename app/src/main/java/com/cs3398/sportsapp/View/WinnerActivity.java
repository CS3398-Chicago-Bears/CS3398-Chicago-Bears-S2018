package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cs3398.sportsapp.Controller.BracketController;
import com.cs3398.sportsapp.R;

public class WinnerActivity extends AppCompatActivity {
    private Button winnerButton;
    String name1;
    TextView winnerFinal;
    String winner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_bracket);
        Intent intent4 = getIntent();
        winnerButton = (Button) findViewById(R.id.winner_button);

        name1 = intent4.getExtras().getString("final_winner");

        winnerFinal = (TextView) findViewById(R.id.winner_bracket);

        winnerFinal.setText(name1);

        winnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(WinnerActivity.this, BracketActivity.class);
                startActivity(intent);
            }
        });
    }
}