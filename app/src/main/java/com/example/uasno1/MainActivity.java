package com.example.uasno1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap gmap;
    private Button BINUS, BRAGA, ALUN2, GAZIBU;
    LatLng kampusBinus = new LatLng(-6.9153653, 107.5886954);
    LatLng braga = new LatLng(-6.9178283, 107.6045685);
    LatLng alunAlunBandung = new LatLng(-6.9218295, 107.6021967);
    LatLng lapanganGazibu = new LatLng(-6.9002779, 107.6161296);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        BINUS = findViewById(R.id.Binus);
        BRAGA = findViewById(R.id.Braga);
        ALUN2 = findViewById(R.id.Alun);
        GAZIBU = findViewById(R.id.Gazibu);


        BINUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recenterMap(kampusBinus, "Kampus Binus Bandung");
            }
        });
        BRAGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recenterMap(braga, "Braga");
            }
        });
        GAZIBU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recenterMap(lapanganGazibu, "Lapangan Gazibu");
            }
        });
        ALUN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recenterMap(alunAlunBandung, "Alun-Alun Kota Bandung");
            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gmap = googleMap;

        // Menambahkan marker untuk setiap lokasi
        gmap.addMarker(new MarkerOptions().position(kampusBinus).title("Kampus Binus Bandung"));
        gmap.addMarker(new MarkerOptions().position(braga).title("Braga"));
        gmap.addMarker(new MarkerOptions().position(alunAlunBandung).title("Alun-Alun Kota Bandung"));
        gmap.addMarker(new MarkerOptions().position(lapanganGazibu).title("Lapangan Gazibu"));


        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(kampusBinus, 13));
    }

    private void recenterMap(LatLng latLng, String title) {
        gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        Toast.makeText(this, "Centered on " + title, Toast.LENGTH_SHORT).show();
    }
}
