package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

public class Teachers_login extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner_sub;
    ProgressBar progressBar;
    Button button_upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_login2);

        //progressBar=(ProgressBar)findViewById(R.id.teacher_login_progress);
        //progressBar.setVisibility(View.GONE);
        button_upload=(Button)findViewById(R.id.teacher_login_but_upload);

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
        switch (view.getId()){
            case R.id.teacher_login_txt_student_gui:{
                finish();
                startActivity(new Intent(this,Front.class));
                break;
            }
            case R.id.teacher_login_but_upload:{
                //
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.teachers_login_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        switch (id)
        {
            case R.id.teacher_login_logout:
            {
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        }


        return super.onOptionsItemSelected(item);
    }



}
