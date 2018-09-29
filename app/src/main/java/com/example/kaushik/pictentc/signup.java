package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class signup extends AppCompatActivity implements View.OnClickListener {

    EditText fname,lname,otp,enroll_no,roll_no,email,mob,pass,con_pass;
    Button sign;
    String name;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fname=(EditText)findViewById(R.id.sign_fName);
        lname=(EditText)findViewById(R.id.sign_lname);
        sign=(Button)findViewById(R.id.sign_signup);
        enroll_no=(EditText)findViewById(R.id.sign_enrollNo);
        roll_no=(EditText)findViewById(R.id.sign_rollNo);
        email=(EditText)findViewById(R.id.sign_email);
        mob=(EditText)findViewById(R.id.sign_phone);
        pass=(EditText)findViewById(R.id.pass);
        con_pass=(EditText)findViewById(R.id.con_pass);
        mAuth = FirebaseAuth.getInstance();
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        //clicklisteners
        findViewById(R.id.sign_signup).setOnClickListener(this);
        //pass.setEnabled(false);
        //con_pass.setEnabled(false);
    }



    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.sign_signup:{
                registerUser();
                break;
            }

        }
    }

    private void registerUser() {
        final String f_name=fname.getText().toString().trim();
        final String l_name=lname.getText().toString().trim();
        final String name=(f_name+' '+l_name);
        final String mail=email.getText().toString().trim();
        final String enroll=enroll_no.getText().toString().trim();
        String passw=pass.getText().toString().trim();
        String con_passw=con_pass.getText().toString().trim();
        final String phone=mob.getText().toString().trim();
        //Validation
        if (f_name.isEmpty()) {
            fname.setError("Enter first name");
            fname.requestFocus();
            return;
        }
        if (lname.getText().toString().isEmpty()) {
            lname.setError("Enter last name");
            lname.requestFocus();
            return;
        }
        if (enroll_no.getText().toString().isEmpty()) {
            enroll_no.setError("Enter enrollment number");
            enroll_no.requestFocus();
            return;
        }
        if((!(enroll_no.getText().toString().startsWith("E2K")) && enroll_no.getText().toString().length()!=0)) {
            enroll_no.setError("Enter VALID enrollment number");
            enroll_no.requestFocus();
            return;
        }
        if (roll_no.getText().toString().isEmpty()) {
            roll_no.setError("Enter roll number");
            roll_no.requestFocus();
            return;
        }
        if((!(roll_no.getText().toString().length()>=4 && roll_no.getText().toString().length()<6)) && roll_no.getText().toString().length()!=0)
        {
            roll_no.setText("Enter VALID roll number");
            roll_no.requestFocus();
            return;
        }
        if (email.getText().toString().isEmpty()) {
            email.setError("Enter E-mail address");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
        {
            email.setError("Enter valid E-mail address");
            email.requestFocus();
            return;
        }
        if (mob.getText().toString().isEmpty()) {
            mob.setError("Enter mobile number");
            mob.requestFocus();
            return;
        }
        if((mob.getText().toString().length()<10 || mob.getText().toString().length()>10) && mob.getText().toString().length()!=0)
        {
            mob.setError("Enter the VALID mobile number");
            mob.requestFocus();
            return;
        }
        if (pass.getText().toString().isEmpty()) {
            pass.setError("Enter Password");
            pass.requestFocus();
            return;
        }
        if (pass.getText().toString().length() != 0 && pass.getText().toString().length() < 7) {
            pass.setError("Password should have minimum six characters or symbol or digit");
            pass.requestFocus();
            return;
        }
        if (enroll_no.getText().toString().length() != 11) {
            enroll_no.setError("Enter valid Enrollment number");
            enroll_no.requestFocus();
            return;
        }

        if (!(pass.getText().toString().equals(con_pass.getText().toString())) && fname.getText().toString().length() != 0 && lname.getText().toString().length() != 0 && email.getText().toString().length() != 0 && enroll_no.getText().toString().length() != 0 && roll_no.getText().toString().length() != 0
                && mob.getText().toString().length() != 0 && otp.getText().toString().length() != 0 && pass.getText().toString().length() != 0 && con_pass.getText().toString().length() != 0) {
            Toast.makeText(this, "Password doesn't matched", Toast.LENGTH_SHORT).show();
            return;

        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(mail,passw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            User user = new User(
                                    name,
                                    mail,
                                    phone,enroll);
                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if(task.isSuccessful()){
                                        Intent intent=new Intent(signup.this, verify.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                        finish();
                                        Toast.makeText(getApplicationContext(),"USER registered",Toast.LENGTH_LONG).show();

                                    }
                                }
                            });

                        } else if(task.getException() instanceof FirebaseAuthUserCollisionException){
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(),"USER already registered",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }


    /*public void click(View view)
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
    }*/


}
