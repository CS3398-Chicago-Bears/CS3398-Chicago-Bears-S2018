package com.cs3398.sportsapp.View;

import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.Model.User;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.cs3398.sportsapp.R;
import com.cs3398.sportsapp.Model.DBHandler;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Guy on 2/19/2018.
 */

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        Button msg = findViewById(R.id.button2);
        final TextView name = findViewById(R.id.textView21);
        final TextView sports = findViewById(R.id.textView19);
        final TextView record = findViewById(R.id.textView18);
        final TextView location = findViewById(R.id.textView16);
        final TextView skill = findViewById(R.id.textView20);
        //User user = DBHandler.getUser();
        User u1 = new User();
        u1.setUserName("Taylor Mauldin");
        name.setText(u1.getUserName());

        u1.addSportsPreference("Basketball");
        u1.addSportsPreference("Baseball");
        u1.addSportsPreference("Football");
        sports.setText(u1.getSportsPreference());

        u1.setWins(69);
        u1.setLosses(3);
        String recordStr = u1.getWins() + " - " + u1.getLosses();
        record.setText(recordStr);

        u1.setSkillLevel(1);
        String skillLevelStr = Integer.toString(u1.getSkillLevel());
        skill.setText(skillLevelStr);

        u1.setLatitude(123.45);
        u1.setLongitude(567.89);
        String locationStr = u1.getLatitude() + " , " + u1.getLongitude();
        location.setText(locationStr);

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

