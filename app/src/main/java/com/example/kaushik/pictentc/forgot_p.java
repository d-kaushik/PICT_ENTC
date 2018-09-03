package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgot_p extends AppCompatActivity {

    Button fp_confirm;
    EditText otp,pass,con_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_p);

        otp=(EditText)findViewById(R.id.forgot_otp);
        pass=(EditText)findViewById(R.id.forgot_pass);
        con_pass=(EditText)findViewById(R.id.forgot_confirmpass);
        fp_confirm=(Button)findViewById(R.id.forgot_checkotp);
        fp_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm();
            }
        });
    }

    private void confirm()
    {
        String otp1=otp.getText().toString().trim();
        if(checkotp(otp1))
        {
            Toast.makeText(this,"OTP Verified",Toast.LENGTH_SHORT).show();
        }
    }
    private boolean checkotp(String otp1)
    {
        if(TextUtils.isEmpty(otp1))
        {
            Toast.makeText(this,"Please Enter OTP !",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public void click(View view)
    {
        if(TextUtils.isEmpty(pass.getText()))
        {
            pass.setError("Enter Password");
        }
        if(TextUtils.isEmpty(con_pass.getText()))
        {
            con_pass.setError("Confirm Password");
        }
        if(pass.getText().length()!=0 && pass.getText().length()<6)
        {
            pass.setError("Password should have minimum six characters");
        }
        if(pass.getText().length()>5 && con_pass.getText().length()>5  )
        {
            if(pass.getText().toString().equals(con_pass.getText().toString()))
            {
                Intent intent=new Intent(this,login.class);
                startActivity(intent);
            }


        }
        else if(pass.getText().toString()!=con_pass.getText().toString())
        {
            Toast.makeText(this,"Password doesn't matched",Toast.LENGTH_SHORT).show();
        }

    }

}
