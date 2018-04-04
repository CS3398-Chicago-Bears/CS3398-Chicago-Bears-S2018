package com.cs3398.sportsapp.View;

import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.Model.User;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import com.cs3398.sportsapp.R;
import com.cs3398.sportsapp.Model.DBHandler;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;



/**
 * Created by Guy on 2/19/2018.
 */

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        DBHandler db = new DBHandler(ProfileActivity.this);
        String userName = getIntent().getStringExtra("userName");
        User u = db.getUser(userName);


        Button msg = findViewById(R.id.button2);
        final TextView name = findViewById(R.id.textView21);
        final TextView sports = findViewById(R.id.textView19);
        final TextView record = findViewById(R.id.textView18);
        final TextView location = findViewById(R.id.textView16);
        final TextView skill = findViewById(R.id.textView20);
        final CheckBox basketball = findViewById(R.id.basketballBox);
        final CheckBox baseball = findViewById(R.id.baseballBox);
        final CheckBox football = findViewById(R.id.footballBox);
        final SearchView search = findViewById(R.id.searchView);
        Button submit = findViewById(R.id.button3);
        //User user = DBHandler.getUser();
        User u1 = new User();
        u1.setUserName("Taylor Mauldin");
        name.setText(u1.getUserName());

        u1.addSportsPreference("Basketball");
        u1.addSportsPreference("Baseball");
        u1.addSportsPreference("Football");
        String [] preferences = u1.getSportsPreference().split("\n");
        for (String s : preferences) {
            if (s.equals("Basketball")) {
                basketball.setChecked(true);
            }
            if (s.equals("Baseball")) {
                baseball.setChecked(true);
            }
            if (s.equals("Football")) {
                football.setChecked(true);
            }
        }

        u1.setWins(0);
        u1.setLosses(0);
        String recordStr = u1.getWins() + " - " + u1.getLosses();
        record.setText(recordStr);

        u1.setSkillLevel("Pro");
        String skillLevelStr = u1.getSkillLevel();
        skill.setText(skillLevelStr);

        u1.setLatitude(30.1593586);
        u1.setLongitude(-97.8341264);
        String locationStr = u1.getLatitude() + " , " + u1.getLongitude();
        location.setText(locationStr);
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(ProfileActivity.this, SearchUsernameActivity.class);
                String message = search.getQuery().toString();
                if (!search.getQuery().toString().equals("")) {
                    i.putExtra("QUERY", message);
                    startActivity(i);

                }
            }
        });

        msg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                AlertDialog.Builder msgBox = new AlertDialog.Builder(ProfileActivity.this);
                msgBox.setTitle("Message: " + name.getText());
                msgBox.setMessage("Enter Message");
                final EditText input = new EditText(ProfileActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                msgBox.setView(input);


                msgBox.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                msgBox.setPositiveButton("Send",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                //WILL ADD MESSAGING LATER
                            }
                        });

                msgBox.show();

            }
        });
    }



}

