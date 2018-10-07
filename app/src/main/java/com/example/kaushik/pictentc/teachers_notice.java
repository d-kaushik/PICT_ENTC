package com.example.kaushik.pictentc;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class teachers_notice extends AppCompatActivity {

    Button select,upload;
    EditText file_name;
    FirebaseStorage storage;
    FirebaseDatabase database;
    Uri pdfUri;//URL for local storage
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_notice);

        select=(Button)findViewById(R.id.tln_select_file);
        upload=(Button)findViewById(R.id.tln_upload_file);
        file_name=(EditText)findViewById(R.id.tln_file_name);
        storage = FirebaseStorage.getInstance();//returns obj of firebase storage
        database = FirebaseDatabase.getInstance();

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(teachers_notice.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    //selectFile();
                } else {
                    ActivityCompat.requestPermissions(teachers_notice.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 4);

                }
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pdfUri != null) {
                    //upLoadFile(pdfUri);
                } else {
                    Toast.makeText(getApplicationContext(), "Select a file", Toast.LENGTH_LONG).show();
                }

            }
        });
    }


}
