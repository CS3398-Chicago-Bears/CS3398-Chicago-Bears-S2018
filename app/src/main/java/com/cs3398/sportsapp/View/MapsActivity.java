package com.cs3398.sportsapp.View;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.json.*;


import com.cs3398.sportsapp.Model.DBHandler;
import com.cs3398.sportsapp.Model.User;
import com.cs3398.sportsapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, OnInfoWindowClickListener {

    private GoogleMap mMap;
    public static DBHandler databaseHelper;



    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(MapsActivity.this,ProfileActivity.class);
        intent.putExtra("userName", marker.getTitle());
        System.out.println(marker.getTitle());
        startActivity(intent);
    }
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
        final String location = getIntent().getStringExtra("location");
        System.out.println(location);
        googleMap.setOnInfoWindowClickListener(this);
        int zip;

        LatLng mapZoom;
        try {
            zip = Integer.parseInt(location);
        }catch (NumberFormatException e) {
            //mapZoom = new LatLng(29.890435, -97.929908);
            zip = 0;
        }
        System.out.println(zip);

        User u = db.getUser(userName);
        mMap = googleMap;
        float zoom = 11;
        Button back = (Button)findViewById(R.id.back);

        int[] austin = {78610, 78613, 78617, 78641, 78652, 78653, 78660, 78664,
                78681, 78701, 78702, 78703, 78704, 78705, 78712, 78717, 78719,
                78721, 78722, 78723, 78724, 78725, 78726, 78727, 78728, 78729, 78730,
                78731, 78732, 78733, 78734, 78735, 78736, 78737, 78738, 78739, 78741, 78742, 78744,
                78745, 78746, 78747, 78748, 78749, 78750, 78751, 78752, 78753, 78754, 78756, 78757, 78758, 78759};
        for(int i = 0; i < austin.length; i++) {

                if (austin[i] == zip) {
                    mapZoom = new LatLng(30.284933, -97.729750);
                    zoom = 10;
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mapZoom, zoom));
                    break;


            }

        }
        if (zip == 78130) {
            mapZoom = new LatLng(29.703420, -98.125266);
            zoom = 10;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mapZoom, zoom));
        }
        if (zip == 78666) {
            mapZoom = new LatLng(29.879924, -97.940300);
            zoom = 10;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mapZoom, zoom));
        }
        if (zip == 78640) {
            mapZoom = new LatLng(29.987747, -97.877012);
            zoom = 10;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mapZoom, zoom));
        }

        LatLng taylor = new LatLng(29.893385, -97.916649);
        LatLng miguel = new LatLng(29.893872, -97.933557);
        LatLng mason = new LatLng(29.876854, -97.936828);
        LatLng james = new LatLng(29.878745, -97.920107);
        LatLng sydney = new LatLng(29.8884, -97.9384);
        LatLng jeffrey = new LatLng(u.getLatitude(), u.getLongitude());
        mMap.addMarker(new MarkerOptions().position(sydney).title("Dr.Lehr's favorite Chicago bears"));
        mMap.addMarker(new MarkerOptions().position(jeffrey).title(userName).snippet(u.getSkillLevel() + " - football"));


        mMap.addMarker(new MarkerOptions().position(taylor).title("Taylor"));
        mMap.addMarker(new MarkerOptions().position(miguel).title("Miguel"));
        mMap.addMarker(new MarkerOptions().position(mason).title("Mason"));
        mMap.addMarker(new MarkerOptions().position(james).title("James"));

        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mapZoom, zoom));


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
