package com.example.savelive;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private DrawerLayout drawer;
    private LatLng location1 = new LatLng(28.6617791,77.1640058);
    private LatLng location2 = new LatLng(28.6805509,77.1983954);
    private LatLng location3 = new LatLng(28.6746, 77.1802);
    private LatLng location4 = new LatLng(28.6806168,77.1853008);
    private LatLng location5 = new LatLng(28.5180713,77.1073736);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.fragment_container);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.naviration_open,R.string.naviration_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        MarkerOptions marker1 = new MarkerOptions()
                .position(location1)
                .title("Ankit,9811114728")
                .icon(setIcon(this,R.drawable.ic_sharp_directions_car_24));
        MarkerOptions marker2 = new MarkerOptions()
                .position(location2)
                .title("Vineet,9582551638")
                .icon(setIcon(this,R.drawable.ic_sharp_directions_car_24));
        MarkerOptions marker3 = new MarkerOptions()
                .position(location3)
                .title("Jagriti,8882703182")
                .icon(setIcon(this,R.drawable.ic_sharp_directions_car_24));
        MarkerOptions marker4 = new MarkerOptions()
                .position(location4)
                .title("Abhijeet,9266052086")
                .icon(setIcon(this,R.drawable.ic_sharp_directions_car_24));
        MarkerOptions marker5 = new MarkerOptions()
                .position(location5)
                .title("Nidhi,7701945897")
                .icon(setIcon(this,R.drawable.ic_baseline_directions_car_24));
        googleMap.addMarker(marker1);
        googleMap.addMarker(marker2);
        googleMap.addMarker(marker3);
        googleMap.addMarker(marker4);
        googleMap.addMarker(marker5);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location4));
        Toast.makeText(MapsActivity.this, "Location Saved", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onBackPressed()
    {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    public BitmapDescriptor setIcon(Activity context, int drawableID){
        Drawable drawable = ActivityCompat.getDrawable(context, drawableID);
        drawable.setBounds(0,0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
