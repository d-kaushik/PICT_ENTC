package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash_screen extends login {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread mythread = new Thread()
        {
            @Override
            public void run()
            {
                try{
                    sleep(1000);
                    //if(save==0)
                    //{
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    //}
                    //else
                    //{
                      //  Intent intent=new Intent(getApplicationContext(),main.class);
                        //startActivity(intent);
                    //}
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
