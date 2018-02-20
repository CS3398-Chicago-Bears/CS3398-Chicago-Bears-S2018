package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cs3398.sportsapp.R;

public class BracketActivity extends AppCompatActivity {
    private Button newBracket;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracket);

        newBracket = (Button)findViewById(R.id.button4);

        newBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BracketActivity.this, NewBracketActivity.class);
                startActivity(intent);
            }
        });
    }
}
