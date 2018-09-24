package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.login_username);
        password=(EditText)findViewById(R.id.login_password);
    }

    public void click(View view) {
        if (view.getId() == R.id.sign_up)
        {
            Intent intent = new Intent(this, signup.class);
            startActivity(intent);

        }
        else if (view.getId() == R.id.login)
        {
            if((username.getText().toString().trim().equals("KD"))&&(password.getText().toString().trim().equals("123456")))
            {
                Intent intent=new Intent(this,Teachers_login.class);
                startActivity(intent);
                finish();
            }
            else if(check())
            {

                Intent intent = new Intent(this, Front.class);
                startActivity(intent);
                finish();
            }

        } else if (view.getId() == R.id.forgot_password) {
            Intent intent = new Intent(this, forgot_p.class);
            startActivity(intent);
            finish();
        }


    }
    private boolean check()
    {
        int k=0,g=1;
        if (username.getText().toString().isEmpty()) {
            username.setError("Enter username");
            k++;
        }
        if(username.getText().toString().startsWith("E2K"))
        {
            g=0;
        }
        if(g!=0 && username.getText().toString().length()!=0)
        {
            username.setError("Enter VALID username");
            k++;
        }
        if (password.getText().toString().isEmpty()) {
            password.setError("Enter Password");
            k++;
        }
        if (username.getText().toString().length() != 11) {
            username.setError("Enter valid Enrollment number");
            k++;
        }
        if (password.getText().toString().length() != 0 && password.getText().toString().length() < 7) {
            Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show();
            k++;
        }
        if(k==0)
        {
            return true;
        }
        else return false;
    }
}

//#3F51B5