package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.Model.User;
import com.cs3398.sportsapp.R;

import java.util.ArrayList;


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

        final String userName = getIntent().getStringExtra("userName");
//        DBHandler db = new DBHandler(HomeActivity.this);
//        TextView t = (TextView)findViewById(R.id.textView4);
//        User u = db.getUser(userName);
//        t.setText(u.getUserName() + " "+ u.getLatitude()+" "+String.valueOf(u.getLongitude()));
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this,SearchActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);

            }
        });

        bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getIntent().getExtras() != null) {
                    ArrayList<String> bracketList = new ArrayList<String>();

                    Intent intent = new Intent(HomeActivity.this,BracketActivity.class);
                    intent.putExtra("userName", userName);
                    intent.putExtra("bracketList", bracketList);
                    startActivity(intent);
                }

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,ProfileActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);

            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,FriendsListActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);

            }
        });

    }
}
