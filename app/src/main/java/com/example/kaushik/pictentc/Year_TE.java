package com.example.kaushik.pictentc;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

public class Year_TE extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year__te);

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
            nav_view.setCheckedItem(R.id.te_mc);
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();

                if(id==R.id.te_mc)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"MC",Toast.LENGTH_SHORT).show();
                }

                else if(id==R.id.te_dsp)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"DSP",Toast.LENGTH_SHORT).show();
                }

                else if(id==R.id.te_dc)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"DC",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_em)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"EM",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_mecx)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"MECX",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_esd)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"ESD",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_es)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"ES and Mini Project",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_itccn)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"ITCCN",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_pe)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"PE",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_bm)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"BM",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_spos)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"SPOS",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_ap)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new fragment_te()).commit();
                    Toast.makeText(Year_TE.this,"AP",Toast.LENGTH_SHORT).show();
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
