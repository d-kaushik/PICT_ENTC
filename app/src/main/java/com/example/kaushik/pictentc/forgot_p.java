package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.net.Inet4Address;

public class forgot_p extends AppCompatActivity {

    Button submit;
    EditText username;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_p);
        username=(EditText)findViewById(R.id.forgot_username);
        submit=(Button)findViewById(R.id.forgot_submit);
        progressBar=(ProgressBar)findViewById(R.id.forgot_progress);


        mAuth=FirebaseAuth.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=username.getText().toString().trim();
                if (username.getText().toString().isEmpty()) {
                    username.setError("Enter E-mail address");
                    username.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
                {
                    username.setError("Enter valid E-mail address");
                    username.requestFocus();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(forgot_p.this,"Reset Email sent.",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(forgot_p.this,login.class));
                        }else{
                            Toast.makeText(forgot_p.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

        });

    }



}
