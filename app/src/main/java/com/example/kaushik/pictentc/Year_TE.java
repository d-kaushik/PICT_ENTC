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
    String Year,Sub;
    path path=new path();

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year__te);
        Bundle b=getIntent().getExtras();
        Year=b.getString("Year");

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

                if(id==R.id.te_mc )
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
                    Toast.makeText(Year_TE.this,Year+" "+Sub,Toast.LENGTH_SHORT).show();
                }

                else if(id==R.id.te_dsp)
                {
                    Sub="DSP";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_TE.this,"DSP",Toast.LENGTH_SHORT).show();
                }

                else if(id==R.id.te_dc)
                {
                    Sub="DC";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_TE.this,"DC",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_em)
                {
                    Sub="EM";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_TE.this,"EM",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_mecx)
                {
                    Sub="MECX";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_TE.this,"MECX",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_esd)
                {
                    Sub="ESD";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_TE.this,"ESD",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_es)
                {
                    Sub="ES and Mini Project";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_TE.this,"ES and Mini Project",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_itccn)
                {
                    Sub="ITCCN";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_TE.this,"ITCCN",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_pe)
                {
                    Sub="PE";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_TE.this,"PE",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_bm)
                {
                    Sub="BM";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_TE.this,"BM",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_spos)
                {   Sub="SPOS";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_TE.this,"SPOS",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.te_ap)
                {
                    Sub="AP";
                    //
                    fragment_te info=new fragment_te();
                    Bundle bundle=new Bundle();
                    bundle.putString("Year",Year);
                    bundle.putString("Sub",Sub);
                    info.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            info).commit();
                    Toast.makeText(Year_TE.this,"AP",Toast.LENGTH_SHORT).show();
                }

                dl.closeDrawer(GravityCompat.START);

                return true;
            }

        });


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
