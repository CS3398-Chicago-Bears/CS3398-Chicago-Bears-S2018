package com.cs3398.sportsapp.View;

import com.cs3398.sportsapp.Model.User;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.cs3398.sportsapp.R;
import java.util.ArrayList;

/**
 * Created by Guy on 2/19/2018.
 */

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        Button test = (Button)findViewById(R.id.button1);
        final TextView name = (TextView)findViewById(R.id.textView);
        TextView sports = (TextView)findViewById(R.id.textView3);
        final Spinner comboBox = (Spinner) findViewById(R.id.spinner);

        test.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                User u1 = new User();
                u1.setFirstName("Taylor");
                u1.setLastName("Mauldin");
                u1.addSportsPreference("Basketball");
                u1.addSportsPreference("Soccer");
                u1.setWins(3);
                u1.setLosses(3);

                String newName = u1.getFirstName()+" "+u1.getLastName();
                name.setText(newName);

                StringBuilder addSports = new StringBuilder();
                for(int i = 0; i < u1.getSportsPreference().size(); i++) {
                    if (i != 0) {
                        addSports.append(", ");
                    }
                    addSports.append(u1.getSportsPreference().get(i));
                }

                // NOT DONE
            }
        });
    }



}

