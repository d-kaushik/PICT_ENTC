package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class splash_screen extends login {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        }

    @Override
    public void onBackPressed() {

        //super.onBackPressed();
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            Thread mythread = new Thread()
            {
                @Override
                public void run()
                {
                    try{
                        sleep(1000);


                        if(mAuth.getCurrentUser().getEmail().equals("teachers.pict@gmail.com")){
                            Intent intent=new Intent(getApplicationContext(),Teachers_login.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                        Intent intent=new Intent(getApplicationContext(),Front.class);
                        startActivity(intent);
                        finish();}
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            mythread.start();

        }
        else
        {
            Thread mythread = new Thread()
            {
                @Override
                public void run()
                {
                    try{
                        sleep(1000);



                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            mythread.start();
        }
        }
    }




