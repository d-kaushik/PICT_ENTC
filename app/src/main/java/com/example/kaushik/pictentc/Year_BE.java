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

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year__be);

        dl=(DrawerLayout)findViewById(R.id.dl);
        abdt=new ActionBarDrawerToggle(this,dl, R.string.open, R.string.close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        final NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);

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
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"VLSI",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_ai)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"AI",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_ave)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"AVE",Toast.LENGTH_SHORT).show();
                }
               else if(id==R.id.be_bcs)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"BCS",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_bsp)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"BSP",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_cns)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"CNS",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_dip)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"DIP",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_emt)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"RMT",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_epd)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"EPD",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_esrtos)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"ESRTOS",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_mc)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"MC",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_iot)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"IOT",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_namo)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"NAMO",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_plc)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"PLC",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_project)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"Project",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_sasp)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"SASP",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_sc)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_BE.this,"SC",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.be_wn)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
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
