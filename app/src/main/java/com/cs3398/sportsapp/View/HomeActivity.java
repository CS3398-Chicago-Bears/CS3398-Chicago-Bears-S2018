package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.R;



public class HomeActivity extends AppCompatActivity {
    private Button search, bracket, profile, friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        search = (Button)findViewById(R.id.search);
        bracket = (Button)findViewById(R.id.bracket);
        profile = (Button)findViewById(R.id.profile);
        friends = (Button)findViewById(R.id.friends);
//        DBHandler db = new DBHandler(HomeActivity.this);
//        TextView t = (TextView)findViewById(R.id.textView4);
//        t.setText(String.valueOf(db.getUser("miguel").getLongitude()));
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,SearchActivity.class);
                startActivity(intent);

            }
        });

        bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(HomeActivity.this,BracketActivity.class);
                    startActivity(intent);

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,ProfileActivity.class);
                startActivity(intent);

            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,FriendsListActivity.class);
                startActivity(intent);

            }
        });

    }
}
