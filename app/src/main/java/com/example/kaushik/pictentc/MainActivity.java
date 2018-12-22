package com.example.kaushik.pictentc;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        username=(EditText)findViewById(R.id.login_username);
        password=(EditText)findViewById(R.id.login_password);
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        //InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(editText.getWindowToken(),InputMethodManager.RESULT_HIDDEN);
    }
    /*
    @Override
    public void onBackPressed() {

        //super.onBackPressed();
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){

            startActivity(new Intent(this,Front.class));
            finish();
        }
    }*/
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
                    Intent intent=new Intent(MainActivity.this, Front.class);
                    startActivity(intent);
                    /*if(user.isEmailVerified()){
                        finish();
                        Intent intent1=new Intent(login.this, Front.class);
                        startActivity(intent1);
                    }
                    else if(!(user.isEmailVerified())){
                        finish();
                        Toast.makeText(getApplicationContext(),"VERIFY USER EMAIL",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(login.this,verify.class));
                    }*/


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
                    Toast.makeText(getApplicationContext(),mAuth.getCurrentUser().getEmail(),Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(MainActivity.this, Teachers_login.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//back does not come to login
                    startActivity(intent);


                } else {
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void click(View view)
    {
        if(view.getId()==R.id.sign_up)
        {
            Intent intent=new Intent(this,signup.class);
            startActivity(intent);
            
        }
        else if(view.getId()==R.id.login_username)
        {
            Intent intent=new Intent(this,login.class);
            startActivity(intent);
            finish();
        }

        else if(view.getId()==R.id.forgot_password)
        {
            Intent intent=new Intent(this,forgot_p.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.login){
            if((username.getText().toString().trim().equals("teachers.pict@gmail.com")))
            {
                teachersLogin();
            }
            else
            {
                userLogin();
            }
        }


    }


}
