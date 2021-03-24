package com.example.formactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   Button btnSave,btnDelete;
   EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete= findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                //Untuk membuat Title
                alertDialogBuilder.setTitle("Peringatan!!!");
                //Untuk membuat pesan
                alertDialogBuilder.setMessage("Apakah Anda Yakin Menghapus Data ?")
                        .setIcon(R.drawable.amikom)
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"Data Terhapus", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                //Untuk membuat Dialognya
                AlertDialog alertDialog = alertDialogBuilder.create();
                //Untuk menampilkan
                alertDialog.show();
            }
        });
        etPassword=findViewById(R.id.etPassword);
        etPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPassword.getText().toString().length()==0) {
                    etPassword.setError("Password Tidak Boleh Kosong!");
                }else{
                    Toast.makeText(MainActivity.this,"Password Berhasil",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}