package com.example.helppl;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.helppl.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private final int FINE_PERMISSION_CODE = 1;
    private GoogleMap mMap;

    Location currentLocation;

    FusedLocationProviderClient fusedLocationProviderClient;
    private ActivityMapsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();
    }

    private void getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
           ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_PERMISSION_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    currentLocation = location;
                    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.map);
                    mapFragment.getMapAsync(MapsActivity.this);
                }
            }
        });
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
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng c1 = new LatLng(48.88717899047174, 2.373166988777541);
        mMap.addMarker(new MarkerOptions().position(c1).title("Centre d'hébergement"));
        LatLng c2 = new LatLng(48.84327885145583, 2.2737228672904664);
        mMap.addMarker(new MarkerOptions().position(c2).title("Le Fleuron"));
        LatLng c3 = new LatLng(48.85210898185713, 2.366515026598478);
        mMap.addMarker(new MarkerOptions().position(c3).title("Accueil de jour femmes"));
        LatLng c4 = new LatLng(48.854230986374546, 2.3998399648814654);
        mMap.addMarker(new MarkerOptions().position(c4).title("GROUPE SOS Solidarités - CHRS Buzenval"));
        LatLng c5 = new LatLng(48.82804801633026, 2.3649050306365496);
        mMap.addMarker(new MarkerOptions().position(c5).title("Centre Municipal d'Aide Sociale"));
        LatLng c6 = new LatLng(48.886522980819706, 2.319387021623271);
        mMap.addMarker(new MarkerOptions().position(c6).title("Foyer d'Hébergement du Centre Scientifique de l'Académie Polonaise des Sciences"));
        LatLng c7 = new LatLng(48.82654400953396, 2.3689069703076484);
        mMap.addMarker(new MarkerOptions().position(c7).title("Association Aurore"));
        LatLng c8 = new LatLng(48.89290600963537, 2.3213700122765033);
        mMap.addMarker(new MarkerOptions().position(c8).title("Permanence sociale d'accueil Gauthey (CASVP)"));
        LatLng c10 = new LatLng(48.83780098931763, 2.310892968583346);
        mMap.addMarker(new MarkerOptions().position(c10).title("Coallia Hébergement"));
        LatLng c9 = new LatLng(48.8823640061926, 2.348080958401823);
        mMap.addMarker(new MarkerOptions().position(c9).title("SOS Habitat et Soins"));
        LatLng maPosition = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        mMap.addMarker(new MarkerOptions().position(maPosition).title("Ma localisation"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(maPosition,11 ));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == FINE_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getLastLocation();
            }
            else{
                Toast.makeText(this, "La permission de géocalisation a été refusée, veuillez l'accepter",Toast.LENGTH_LONG).show();
            }
        }
    }
}