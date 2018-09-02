package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void click(View view) {
        if (view.getId() == R.id.sign_up) {
            Intent intent = new Intent(this, signup.class);
            startActivity(intent);
        } else if (view.getId() == R.id.login) {
            Intent intent = new Intent(this, main.class);
            startActivity(intent);
        } else if (view.getId() == R.id.forgot_password) {
            Intent intent = new Intent(this, forgot_p.class);
            startActivity(intent);
        }

    }
}

