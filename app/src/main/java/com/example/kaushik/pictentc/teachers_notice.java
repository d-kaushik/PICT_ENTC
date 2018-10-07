package com.example.kaushik.pictentc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class teachers_notice extends AppCompatActivity {

    Button select,upload;
    EditText file_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_notice);

        select=(Button)findViewById(R.id.tln_select_file);
        upload=(Button)findViewById(R.id.tln_upload_file);
        file_name=(EditText)findViewById(R.id.tln_file_name);
    }
}
