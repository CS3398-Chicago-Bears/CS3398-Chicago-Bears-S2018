package com.cs3398.sportsapp.View;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

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
        final String userName = getIntent().getStringExtra("userName");
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
        mMap = googleMap;
        float zoom = 11;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(29.8884, -97.9384);
        LatLng jeffrey = new LatLng(30.1593586, -97.8341264);
        LatLng taylor = new LatLng(29.893385, -97.916649);
        LatLng miguel = new LatLng(29.893872, -97.933557);
        LatLng mason = new LatLng(29.876854, -97.936828);
        LatLng james = new LatLng(29.878745, -97.920107);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Dr.Lehr's favorite Chicago bears"));
        mMap.addMarker(new MarkerOptions().position(jeffrey).title("Jeff"));
        mMap.addMarker(new MarkerOptions().position(taylor).title("Taylor"));
        mMap.addMarker(new MarkerOptions().position(miguel).title("Miguel"));
        mMap.addMarker(new MarkerOptions().position(mason).title("Mason"));
        mMap.addMarker(new MarkerOptions().position(james).title("James"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(james, zoom));
    }
}
