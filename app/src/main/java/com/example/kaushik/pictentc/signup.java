package com.example.kaushik.pictentc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText fname,lname,otp;
    Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fname=(EditText)findViewById(R.id.sign_fName);
        lname=(EditText)findViewById(R.id.sign_lname);
        otp=(EditText)findViewById(R.id.sign_otp);
        sign=(Button)findViewById(R.id.sign_signup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });

    }
    private void submit()
    {
        String onetimepassword=otp.getText().toString().trim();
        if(checkotp(onetimepassword))
        {
            Toast.makeText(this,"Sign up Completed !",Toast.LENGTH_SHORT).show();
        }
    }
    private boolean checkotp(String onetimepassword)
    {
        if(TextUtils.isEmpty(onetimepassword))
        {
            Toast.makeText(this,"Please Enter OTP !",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
