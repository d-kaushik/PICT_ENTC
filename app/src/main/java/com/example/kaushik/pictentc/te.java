package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class te extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_te);
    }
    public void onClick(View view)
    {
        if(view.getId()==R.id.mc)
        {
            Intent intent=new Intent(this,mc.class);
            startActivity(intent);
        }

    }

}
