package com.example.uasno3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uasno3.Model.DatabaseHelper;

public class Insert extends AppCompatActivity {
    private EditText nama , Nim , matkul , Ipk;
    private Button insertButton, displayMenu, deleteMenu;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        // Inisialisasi EditText
        nama = findViewById(R.id.insertNama);
        Nim = findViewById(R.id.insertNim);
        matkul = findViewById(R.id.insertMatkul);
        Ipk = findViewById(R.id.insertIpk);

        // Inisialisasi DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Inisialisasi Button
        insertButton = findViewById(R.id.insertButton);
        displayMenu = findViewById(R.id.DisplayMenu);
        deleteMenu = findViewById(R.id.DeleteMenu);

        // Set OnClickListener untuk insertButton
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nama = nama.getText().toString();
                String NIM = Nim.getText().toString();
                String Matkul = matkul.getText().toString();
                String StringIPK = Ipk.getText().toString();
                boolean validate = true ;

                if (Nama.isEmpty() || NIM.isEmpty() || Matkul.isEmpty() || StringIPK.isEmpty()) {
                    Toast.makeText(Insert.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean result = dbHelper.addMahasiswa(Nama, NIM, StringIPK, Matkul);
//                    if(NIM.length()!=10){
//                        Toast.makeText(Insert.this, "BINUS NIM must be 10 characters", Toast.LENGTH_SHORT).show();
//                    }
                    if(Double.parseDouble(StringIPK)>4){
                        validate = false;
                        Toast.makeText(Insert.this, "IPK cann't be greater than 4", Toast.LENGTH_SHORT).show();
                    }
                    if(dbHelper.checkMahasiswa(NIM)){
                        validate = false;
                        Toast.makeText(Insert.this, "NIM already exists", Toast.LENGTH_SHORT).show();
                    }

                    if (result && validate){
                        Toast.makeText(Insert.this, "Insert Successful", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        // Set OnClickListener untuk displayMenu
        displayMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Insert.this, Display.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener untuk deleteMenu
        deleteMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Insert.this, Delete.class);
                startActivity(intent);
            }
        });
    }
}
