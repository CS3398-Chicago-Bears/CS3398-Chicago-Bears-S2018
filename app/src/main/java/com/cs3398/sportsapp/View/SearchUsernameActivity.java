package com.cs3398.sportsapp.View;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.Model.User;
import com.cs3398.sportsapp.R;

import java.util.List;

public class SearchUsernameActivity extends AppCompatActivity {
    private String query = "";
    private DBHandler db;
    private String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_username);

        TextView userList = findViewById(R.id.textView3);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            query = extras.getString("QUERY");
            uname = extras.getString("userName");
        }

        db = new DBHandler(SearchUsernameActivity.this);
        List<User> u = db.searchUsers("t");
        StringBuilder allUsers = new StringBuilder();
        for (User user : u) {
            allUsers.append(user.getUserName());
        }
        userList.setText(allUsers.toString());

    }

}
