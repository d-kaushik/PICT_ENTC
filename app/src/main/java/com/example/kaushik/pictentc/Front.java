package com.example.kaushik.pictentc;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Front extends AppCompatActivity {

    private DrawerLayout dl;
    path path1=new path();

    private ActionBarDrawerToggle abdt;
    String Year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        dl=(DrawerLayout)findViewById(R.id.dl);
        abdt=new ActionBarDrawerToggle(this,dl, R.string.open, R.string.close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        final NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);

        //ActionBar bar=getActionBar();
        //bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#131337")));


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();

                if(id==R.id.notice)
                {
                    Intent intent=new Intent(Front.this,Notice.class);
                    startActivity(intent);


                }
                if(id==R.id.logout)
                {
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                dl.closeDrawer(GravityCompat.START);

                return true;
            }
        });



    }
    public void onClick(View view)
    {
        if(view.getId()==R.id.but_se)
        {
            Intent intent=new Intent(this,Year_SE.class);
            intent.putExtra("Year","SE");
            path1.setYear("SE");
            startActivity(intent);
        }
        else if(view.getId()==R.id.but_te)
        {
            Intent intent=new Intent(this,Year_TE.class);
            intent.putExtra("Year","TE");
            path1.setYear("TE");
            startActivity(intent);
        }
        else if(view.getId()==R.id.but_be)
        {
            Intent intent=new Intent(this,Year_BE.class);
            intent.putExtra("Year","BE");
            path1.setYear("BE");
            startActivity(intent);
        }



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,login.class));
        }
        if(!(FirebaseAuth.getInstance().getCurrentUser().isEmailVerified())){
            finish();
            startActivity(new Intent(this,verify.class));

        }
    }
}
