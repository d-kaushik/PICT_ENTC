package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class Teachers_login extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private static final int PICK_IMAGE_REQUEST=123;
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

    public void button_click(View view)
    {
        //if(view.getId()==R.id.teacher_login_but_upload)
        //{
            //progressBar.setVisibility(view.VISIBLE);
        //}

        //Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
        //startActivity(intent);
        showFileChooser();
    }
    public void onClick(View view)
    {
        Intent intent=new Intent(this,Front.class);
        startActivity(intent);
    }
    private void showFileChooser()
    {
        Intent intent=new Intent();
        intent.setType("pdf/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select PDF"),PICK_IMAGE_REQUEST);
    }



}
