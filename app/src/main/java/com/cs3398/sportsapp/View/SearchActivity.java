package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.cs3398.sportsapp.R;



public class SearchActivity extends AppCompatActivity {
    private Button search, backSearch, map;
    private EditText searchLocation;
    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);




        search = (Button)findViewById(R.id.searchSearch);
        backSearch = (Button)findViewById(R.id.backSearch);
        searchLocation = (EditText)findViewById(R.id.enterLocationText);
        map = (Button)findViewById(R.id.mapButton);

        final String userName = getIntent().getStringExtra("userName");
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this,MapsActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this,SearchActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });

        backSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this,HomeActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });

    }
}
