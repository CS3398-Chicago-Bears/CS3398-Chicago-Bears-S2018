package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.cs3398.sportsapp.R;


public class NewBracketActivity extends AppCompatActivity {
    private Button create, backNewBracket;
    EditText user1, user2, user3, user4, user5, user6, user7, user8;
    String player1, player2, player3, player4, player5, player6, player7, player8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbracket);

        create = (Button)findViewById(R.id.addPlayerDone);
        backNewBracket = (Button)findViewById(R.id.backNewBracket);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user1 = (EditText)findViewById(R.id.name1);
                user2 = (EditText)findViewById(R.id.name2);
                user3 = (EditText)findViewById(R.id.name3);
                user4 = (EditText)findViewById(R.id.name4);
                user5 = (EditText)findViewById(R.id.name5);
                user6 = (EditText)findViewById(R.id.name6);
                user7 = (EditText)findViewById(R.id.name7);
                user8 = (EditText)findViewById(R.id.name8);

                player1 = user1.getText().toString();
                player2 = user2.getText().toString();
                player3 = user3.getText().toString();
                player4 = user4.getText().toString();
                player5 = user5.getText().toString();
                player6 = user6.getText().toString();
                player7 = user7.getText().toString();
                player8 = user8.getText().toString();


                Intent intent = new Intent(NewBracketActivity.this,FirstRoundActivity.class);
                intent.putExtra("player1", player1);
                intent.putExtra("player2", player2);
                intent.putExtra("player3", player3);
                intent.putExtra("player4", player4);
                intent.putExtra("player5", player5);
                intent.putExtra("player6", player6);
                intent.putExtra("player7", player7);
                intent.putExtra("player8", player8);
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
