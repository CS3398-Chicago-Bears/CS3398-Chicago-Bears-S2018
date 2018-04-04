package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.Model.User;
import com.cs3398.sportsapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        DBHandler db = new DBHandler(MapsActivity.this);
        final String userName = getIntent().getStringExtra("userName");
        User u = db.getUser(userName);
        mMap = googleMap;
        float zoom = 10;
        Button back = (Button)findViewById(R.id.back);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(29.8884, -97.9384);
        LatLng jeffrey = new LatLng(u.getLatitude(), u.getLongitude());
        mMap.addMarker(new MarkerOptions().position(sydney).title("Dr.Lehr's favorite Chicago bears"));
        mMap.addMarker(new MarkerOptions().position(jeffrey).title("Jeff's house"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jeffrey, zoom));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapsActivity.this,SearchActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });
    }
}
