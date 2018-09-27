package com.example.kaushik.pictentc;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class Teachers_login extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner_sub;
    ProgressBar progressBar;
    Button button_upload,button_select;
    TextView status;
    FirebaseStorage storage;
    FirebaseDatabase database;
    Uri pdfUri;//URL for local storage



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_login2);

        //progressBar=(ProgressBar)findViewById(R.id.teacher_login_progress);
        //progressBar.setVisibility(View.GONE);
        button_upload=(Button)findViewById(R.id.teacher_login_but_upload);
        button_select=(Button)findViewById(R.id.teacher_login_but_select);
        status=(TextView)findViewById(R.id.tl_status);
        storage=FirebaseStorage.getInstance();//returns obj of firebase storage
        database=FirebaseDatabase.getInstance();

        button_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Teachers_login.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectFile();
                }else{
                    ActivityCompat.requestPermissions(Teachers_login.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},4);

                }
            }
        });





        Spinner spinner_year=(Spinner)findViewById(R.id.teacher_login_spinner_year);
        spinner_sub=(Spinner)findViewById(R.id.teacher_login_spinner_subject);
        Spinner spinner_type=(Spinner)findViewById(R.id.teacher_login_spinner_type);

        ArrayAdapter<CharSequence>adapter_year=ArrayAdapter.createFromResource(this,R.array.Year,R.layout.support_simple_spinner_dropdown_item);
        adapter_year.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_year.setAdapter(adapter_year);
        spinner_year.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence>adapter_type=ArrayAdapter.createFromResource(this,R.array.type,R.layout.support_simple_spinner_dropdown_item);
        adapter_type.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_type.setAdapter(adapter_type);
        spinner_type.setOnItemSelectedListener(this);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==4&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
            selectFile();
        }
        else{
            Toast.makeText(getApplicationContext(),"Please provide permission",Toast.LENGTH_LONG).show();
        }
    }

    private void selectFile() {
        Intent intent=new Intent();
        //for pdf and ppt
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);//fetch files
        startActivityForResult(intent,5);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //user has selected the file or not checking
        if(requestCode==5 && resultCode==RESULT_OK && data!=null){

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getItemAtPosition(position).toString().trim().equals("SE"))
        {


                ArrayAdapter<CharSequence>adapter_sub=ArrayAdapter.createFromResource(this,R.array.SE,R.layout.support_simple_spinner_dropdown_item);
                adapter_sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                spinner_sub.setAdapter(adapter_sub);
                spinner_sub.setOnItemSelectedListener(this);
        }
        else if(parent.getItemAtPosition(position).toString().trim().equals("TE"))
        {

            ArrayAdapter<CharSequence>adapter_sub=ArrayAdapter.createFromResource(this,R.array.TE,R.layout.support_simple_spinner_dropdown_item);
            adapter_sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_sub.setAdapter(adapter_sub);
            spinner_sub.setOnItemSelectedListener(this);

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void onClick(View view)
    {
        Intent intent=new Intent(this,Front.class);
        startActivity(intent);
    }



}
