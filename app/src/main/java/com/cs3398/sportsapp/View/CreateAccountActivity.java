package com.cs3398.sportsapp.View;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;

import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.Model.User;
import com.cs3398.sportsapp.R;

public class CreateAccountActivity extends AppCompatActivity {
    private Button create;
    private EditText uName, pWord;
    private Spinner dropdown;
    private DBHandler databaseHelper;
    private User user;
    private NestedScrollView nestedScrollView;
    private double lat;
    private double longt;
    static final int REQUEST_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        nestedScrollView = findViewById(R.id.nestedScrollView);
        create = (Button) findViewById(R.id.btCreate);
        uName = (EditText) findViewById(R.id.etUserName);
        pWord = (EditText) findViewById(R.id.etPassword);
        dropdown = (Spinner) findViewById(R.id.spinner);
        user = new User();
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }else {
            final Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            lat = location.getLatitude();
            longt = location.getLongitude();
        }
//create a list of items for the spinner.
        String[] items = new String[]{"Beginner", "Intermediate", "Pro"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        databaseHelper = new DBHandler(CreateAccountActivity.this);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!databaseHelper.checkUser(uName.getText().toString().trim())){
                    //user.setUserName("Hi");
                    user.setUserName(uName.getText().toString());
                    user.setPassword(pWord.getText().toString());
                    user.setSkillLevel(dropdown.getSelectedItem().toString());
                    user.setLatitude(lat);
                    user.setLongitude(longt);
                    databaseHelper.addUser(user);
                    Intent i = new Intent(CreateAccountActivity.this,MainActivity.class);
                    startActivity(i);
                }
                else{
                    Snackbar.make(nestedScrollView, "User already exists", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}
