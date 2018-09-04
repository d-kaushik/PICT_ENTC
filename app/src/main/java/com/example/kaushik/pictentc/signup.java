package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText fname,lname,otp,enroll_no,roll_no,email,mob,pass,con_pass;
    Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fname=(EditText)findViewById(R.id.sign_fName);
        lname=(EditText)findViewById(R.id.sign_lname);
        otp=(EditText)findViewById(R.id.sign_otp);
        sign=(Button)findViewById(R.id.sign_signup);
        enroll_no=(EditText)findViewById(R.id.sign_enrollNo);
        roll_no=(EditText)findViewById(R.id.sign_rollNo);
        email=(EditText)findViewById(R.id.sign_email);
        mob=(EditText)findViewById(R.id.sign_phone);
        pass=(EditText)findViewById(R.id.pass);
        con_pass=(EditText)findViewById(R.id.con_pass);
    }


    public void click(View view)
    {
        if(check())
        {
            Intent intent=new Intent(this,login.class);
            startActivity(intent);
        }
    }
    private boolean check() {
        int k = 0,y=1,z=1,g=1,u=1;
        
        if (fname.getText().toString().isEmpty()) {
            fname.setError("Enter first name");
            k++;
        }
        if (lname.getText().toString().isEmpty()) {
            lname.setError("Enter last name");
            k++;
        }
        if (otp.getText().toString().isEmpty()) {
            otp.setError("Enter OTP");
            k++;
        }
        if (enroll_no.getText().toString().isEmpty()) {
            enroll_no.setError("Enter enrollment number");
            k++;
        }
        if(enroll_no.getText().toString().startsWith("E2K"))
        {
            g=0;
        }
        if(g!=0 && enroll_no.getText().toString().length()!=0)
        {
            enroll_no.setError("Enter VALID enrollment number");
        }
        if (roll_no.getText().toString().isEmpty()) {
            roll_no.setError("Enter roll number");
            k++;
        }
        if(roll_no.getText().toString().length()>=4 && roll_no.getText().toString().length()<6)
        {
            u=0;
        }
        if(u!=0 && roll_no.getText().toString().length()!=0)
        {
            roll_no.setText("Enter VALID roll number");
        }
        if (email.getText().toString().isEmpty()) {
            email.setError("Enter E-mail address");
            k++;
        }
        if(email.getText().toString().endsWith(".com")&& email.getText().toString().length()!=0)
        {
            z=0;
        }
        if(z!=0)
        {
            email.setError("Enter valid E-mail address");
            k++;
        }
        if (mob.getText().toString().isEmpty()) {
            mob.setError("Enter mobile number");
            k++;
        }
        if((mob.getText().toString().length()<10 || mob.getText().toString().length()>10) && mob.getText().toString().length()!=0)
        {
            mob.setError("Enter the VALID mobile number");
            k++;
        }
        if (pass.getText().toString().isEmpty()) {
            pass.setError("Enter Password");
            k++;
        }
        if (pass.getText().toString().length() != 0 && pass.getText().toString().length() < 7) {
            pass.setError("Password should have minimum six characters or symbol or digit");
            k++;
        }
        if (enroll_no.getText().toString().length() != 11) {
            enroll_no.setError("Enter valid Enrollment number");
            k++;
        }
        if(pass.getText().toString().equals(con_pass.getText().toString()))
        {
            y=0;
        }
        if (y!=0 && fname.getText().toString().length() != 0 && lname.getText().toString().length() != 0 && email.getText().toString().length() != 0 && enroll_no.getText().toString().length() != 0 && roll_no.getText().toString().length() != 0
                && mob.getText().toString().length() != 0 && otp.getText().toString().length() != 0 && pass.getText().toString().length() != 0 && con_pass.getText().toString().length() != 0) {
            Toast.makeText(this, "Password doesn't matched", Toast.LENGTH_SHORT).show();
            k++;
        }
        if(k==0)
        {
            return true;
        }
        else return false;
    }
}
