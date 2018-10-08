package com.example.kaushik.pictentc;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Year_BE extends AppCompatActivity {
    String Year,Sub;
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    NavigationView nav_view;
    path path=new path();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year__be);
        Bundle b=getIntent().getExtras();
        Year=b.getString("Year");

        dl=(DrawerLayout)findViewById(R.id.dl);
        abdt=new ActionBarDrawerToggle(this,dl, R.string.open, R.string.close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        nav_view=(NavigationView)findViewById(R.id.nav_view);

        if(savedInstanceState==null)
        {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new fragment_te()).commit();
            nav_view.setCheckedItem(R.id.be_vlsi);
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();

                if(id==R.id.be_vlsi)
                {
                    Sub="VLSI";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"VLSI",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_ai)
                {
                    Sub="AI";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"AI",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_ave)
                {
                    Sub="AVE";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"AVE",Toast.LENGTH_SHORT).show();
                }
               else if(id==R.id.be_bcs)
                {
                    Sub="BCS";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"BCS",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_bsp)
                {
                    Sub="BSP";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"BSP",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_cns)
                {
                    Sub="CNS";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"CNS",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_dip)
                {
                    Sub="DIP";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"DIP",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_emt)
                {
                    Sub="RMT";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"RMT",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_epd)
                {
                    Sub="EPD";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"EPD",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_esrtos)
                {
                    Sub="ESRTOS";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"ESRTOS",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_mc)
                {
                    Sub="MC";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"MC",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_iot)
                {
                    Sub="IOT";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"IOT",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_namo)
                {
                    Sub="NAMO";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"NAMO",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_plc)
                {
                    Sub="PLC";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"PLC",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_project)
                {
                    Sub="Project";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"Project",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_sasp)
                {
                    Sub="SASP";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"SASP",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_sc)
                {
                    Sub="SC";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_BE.this,"SC",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_wn)
                {
                    Sub="WN";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();

                    Toast toast= Toast.makeText(Year_BE.this,"WN",Toast.LENGTH_SHORT);
                    toast.show();
                }



                dl.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
