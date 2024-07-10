package com.example.uasno3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uasno3.Model.DatabaseHelper;

public class Delete extends AppCompatActivity{
    private EditText nim;
    private Button deleteButton, displayMenu, insertMenu;
    private DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        deleteButton = findViewById(R.id.DeleteButton);
        displayMenu = findViewById(R.id.DisplayMenu);
        insertMenu = findViewById(R.id.InsertMenu);
        nim = findViewById(R.id.deleteNim);
        dbHelper = new DatabaseHelper(this);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nim = nim.getText().toString();
                if (Nim.isEmpty()) {
                    Toast.makeText(Delete.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean result = dbHelper.deleteMahasiswa(Nim);
                    if (result) {
                        Toast.makeText(Delete.this, "Delete Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Delete.this, "Delete failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        displayMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Delete.this, Display.class);
                startActivity(intent);
            }
        });

        insertMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Delete.this, Insert.class);
                startActivity(intent);
            }
        });


    }


}
