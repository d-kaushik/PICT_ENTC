package com.example.kaushik.pictentc;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class Year_SE extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year__se);

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
            nav_view.setCheckedItem(R.id.se_dsa);
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();

                if(id==R.id.se_dsa)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"DSA",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.se_ac)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"AC",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.se_cs)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"CS",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.se_ic)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"IC",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.se_esd)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"ESD",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.se_oop)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"OOP",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.se_m3)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"M-3",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.se_de)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"DE",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.se_ecm)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"ECM",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.se_edc)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"EDC",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.se_emit)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"EMIT",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.se_sns)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_SE.this,"SNS",Toast.LENGTH_SHORT).show();
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
