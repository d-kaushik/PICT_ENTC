package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class verify extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button verify;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        textView=(TextView)findViewById(R.id.Status);
        mAuth=FirebaseAuth.getInstance();
        verify=(Button)findViewById(R.id.verify_Verify);
        progressBar=(ProgressBar)findViewById(R.id.progressbar1);
        findViewById(R.id.verify_Verify).setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.verify_Verify:{
                userVerify();
                break;
            }
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,login.class));
        }
    }

    private void userVerify() {
        progressBar.setVisibility(View.VISIBLE);
        mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    startActivity(new Intent(verify.this,login.class));
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.teachers_login_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.teacher_login_logout: {
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
