package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.cs3398.sportsapp.R;


public class NewBracketActivity extends AppCompatActivity {
    private Button create, backNewBracket;
    private EditText name1, name2, name3, name4, name5, name6, name7, name8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbracket);

        name1 = (EditText)findViewById(R.id.name1);
        name2 = (EditText)findViewById(R.id.name2);
        name3 = (EditText)findViewById(R.id.name3);
        name4 = (EditText)findViewById(R.id.name4);
        name5 = (EditText)findViewById(R.id.name5);
        name6 = (EditText)findViewById(R.id.name6);
        name7 = (EditText)findViewById(R.id.name7);
        name8 = (EditText)findViewById(R.id.name8);

        create = (Button)findViewById(R.id.addPlayerDone);
        backNewBracket = (Button)findViewById(R.id.backNewBracket);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewBracketActivity.this,NewBracketActivity.class);
                startActivity(intent);
            }
        });
        backNewBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewBracketActivity.this,BracketActivity.class);
                startActivity(intent);
            }
        });

    }
}
