package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText username,password;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.login_username);
        password=(EditText)findViewById(R.id.login_password);
        mAuth=FirebaseAuth.getInstance();
        //OnCLickListeners
        findViewById(R.id.sign_up).setOnClickListener(this);
        findViewById(R.id.forgot_password).setOnClickListener(this);
        findViewById(R.id.login).setOnClickListener(this);
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(this,Front.class));
        }
    }

    private void userLogin() {
        String mail=username.getText().toString().trim();
        String passw=password.getText().toString().trim();
        final FirebaseUser user= mAuth.getCurrentUser();
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
        if (password.getText().toString().isEmpty()) {
            password.setError("Enter Password");
            password.requestFocus();
            return;
        }
        if (password.getText().toString().length() != 0 && password.getText().toString().length() < 7) {
            password.setError("Password should have minimum six characters or symbol or digit");
            password.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(mail,passw).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    finish();
                    Intent intent=new Intent(login.this, Front.class);
                    startActivity(intent);
                    /*if(user.isEmailVerified()){
                        finish();
                        Intent intent=new Intent(login.this, Front.class);
                        startActivity(intent);
                    }
                    else{
                        finish();
                        Toast.makeText(getApplicationContext(),"VERIFY USER EMAIL",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(login.this,verify.class));
                    }
*/

                } else {
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void teachersLogin() {
        String mail=username.getText().toString().trim();
        String passw=password.getText().toString().trim();
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
        if (password.getText().toString().isEmpty()) {
            password.setError("Enter Password");
            password.requestFocus();
            return;
        }
        if (password.getText().toString().length() != 0 && password.getText().toString().length() < 7) {
            password.setError("Password should have minimum six characters or symbol or digit");
            password.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(mail,passw).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    finish();
                    Intent intent=new Intent(login.this, Teachers_login.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//back does not come to login
                    startActivity(intent);


                } else {
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_up:
            {
                finish();
                Intent intent = new Intent(this, signup.class);
                startActivity(intent);
                break;

            }
            case R.id.forgot_password:
            {
                finish();
                Intent intent = new Intent(this, forgot_p.class);
                startActivity(intent);
                break;
            }
            case R.id.login:
            {
                if((username.getText().toString().trim().equals("teachers.entc@pict.edu")))
                {
                    teachersLogin();
                }
                else
                {
                    userLogin();
                }
                break;
            }

        }
    }








}

//#3F51B5