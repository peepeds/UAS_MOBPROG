package com.example.uasno3;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import com.example.uasno3.Control.Adapter;
import com.example.uasno3.Model.DatabaseHelper;
import com.example.uasno3.Model.Mahasiswa;

import java.util.List;

public class Display extends AppCompatActivity {

    private RecyclerView recyclerViewMahasiswa;
    private Adapter adapter;
    private DatabaseHelper dbHelper;
    //private Button displayMenu, insertMenu, deleteMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        recyclerViewMahasiswa = findViewById(R.id.recyclerViewMahasiswa);
//        insertMenu = findViewById(R.id.InsertMenu);
//        deleteMenu = findViewById(R.id.DeleteMenu);
        dbHelper = new DatabaseHelper(this);


        List<Mahasiswa> mahasiswaList = dbHelper.getMahasiswa();


        recyclerViewMahasiswa.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, mahasiswaList);
        recyclerViewMahasiswa.setAdapter(adapter);




    }

}
