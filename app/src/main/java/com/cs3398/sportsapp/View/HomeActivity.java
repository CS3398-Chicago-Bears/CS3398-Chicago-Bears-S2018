package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cs3398.sportsapp.R;

public class HomeActivity extends AppCompatActivity {
    private Button search, bracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //search = (Button)findViewById(R.id.search);
        bracket = (Button)findViewById(R.id.button2);

        bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(HomeActivity.this,BracketActivity.class);
                    startActivity(intent);

            }
        });
    }
}
