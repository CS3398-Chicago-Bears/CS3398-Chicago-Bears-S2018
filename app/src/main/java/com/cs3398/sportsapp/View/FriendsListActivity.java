package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.Model.DBHandlerFriends;
import com.cs3398.sportsapp.Model.User;
import com.cs3398.sportsapp.R;

public class FriendsListActivity extends AppCompatActivity {
    Button back, add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);
        back = (Button)findViewById(R.id.back);
        add = (Button)findViewById(R.id.button4);
        final TextView text = (TextView)findViewById(R.id.textView9);
        final String userName = getIntent().getStringExtra("userName");
        final DBHandlerFriends fdb = new DBHandlerFriends(this);
        final DBHandler db = new DBHandler(this);
        final User sender = db.getUser(userName);
        final User receiver = db.getUser("Teddy");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FriendsListActivity.this,HomeActivity.class);
                intent.putExtra("userName",userName);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fdb.addRequest(sender,receiver);
            }
        });

        if(fdb.getStatus(sender,receiver) == 0){
            text.setText("Friend Request Pending");
        }



    }
}
