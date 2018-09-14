package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
    public void onClick(View view)
    {
        if(view.getId()==R.id.but_se)
        {
            Intent intent=new Intent(this,se.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.but_te)
        {
            Intent intent=new Intent(this,te.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.but_be)
        {
            Intent intent=new Intent(this,be.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.teachers_login)
        {
            Intent intent=new Intent(this,teachers_login.class);
            startActivity(intent);
        }
    }
}
