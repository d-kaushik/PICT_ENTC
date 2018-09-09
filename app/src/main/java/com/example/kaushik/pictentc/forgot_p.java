package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;

public class forgot_p extends AppCompatActivity {

    Button fp_confirm;
    EditText otp,pass,con_pass,username;
    int count=0;

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
        username=(EditText)findViewById(R.id.sign_enrollNo);
    }



    private void confirm()
    {
        if(checkotp(otp))
        {
            Toast.makeText(this,"OTP Verified",Toast.LENGTH_SHORT).show();
            count++;
        }
    }
    private boolean checkotp(EditText otp)
    {
        int k=0,g=1;
        if (username.getText().toString().isEmpty()) {
            username.setError("Enter enrollment number");
            k++;
        }
        if(username.getText().toString().startsWith("E2K")&& username.getText().toString().length()==11)
        {
            g=0;
        }
        if(g!=0 && username.getText().toString().length()!=0)
        {
            username.setError("Enter VALID enrollment number");
            k++;
        }
        if(otp.getText().toString().isEmpty())
        {
            otp.setText("Enter OTP");
            k++;
        }
        if(k==0)
        {
            return true;
        }
        else return false;
    }
    public void click(View view)
    {
        if(check())
        {
            Intent intent=new Intent(this,login.class);
            startActivity(intent);
        }

    }
    private boolean check()
    {
        int k=0,u=0;
        if(count==0)
        {
            Toast.makeText(this,"Confirm OTP ",Toast.LENGTH_SHORT).show();
        }
        if (count==1)
        {
            if(TextUtils.isEmpty(pass.getText()))
            {
                pass.setError("Enter Password");
                k++;
            }
            if(TextUtils.isEmpty(con_pass.getText()))
            {
                con_pass.setError("Confirm Password");
                k++;
            }
            if(pass.getText().length()!=0 && pass.getText().length()<6)
            {
                pass.setError("Password should have minimum six characters");
                k++;
            }
            if(pass.getText().toString().equals(con_pass.getText().toString()))
            {
                u=1;
            }
            if(u!=1 && pass.getText().length()>5 )
            {
                    con_pass.setError("Password doesn't match");
                    k++;
            }
            if(k==0)
            {
                return true;
            }
            else return false;
        }
        else return false;
    }

}
