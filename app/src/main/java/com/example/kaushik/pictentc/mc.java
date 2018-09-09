package com.example.kaushik.pictentc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class mc extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc);

    }
    public void changefrag(View view)
    {
        Fragment fragment;

        if(view==findViewById(R.id.mc_assign))
        {

        }
        if (view==findViewById(R.id.mc_unit_test))
        {

        }
        if(view==findViewById(R.id.mc_university_ppr))
        {

        }
        if(view==findViewById(R.id.mc_other))
        {

        }
    }
}
