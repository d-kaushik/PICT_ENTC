package com.example.kaushik.pictentc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class signup extends AppCompatActivity implements View.OnClickListener {

    EditText fname,lname,otp,enroll_no,roll_no,email,mob,pass,con_pass;
    Button sign;
    int count,t;
    String enroll_chk;
    ValueEventListener DBListener;
    String name;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference,reference;

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
        if (chk_enroll()) {
            enroll_no.setError("Enrollment Number exists");
            enroll_no.requestFocus();
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

        if (!(passw.equals(con_passw))) {
            con_pass.setError("Password doesn't match");
            con_pass.requestFocus();
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
                                    .child(user.enroll)//FirebaseAuth.getInstance().getCurrentUser().getUid())
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
    public boolean chk_enroll(){
        String enroll=enroll_no.getText().toString().trim();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        reference=databaseReference.child("Users").child(enroll);
        ValueEventListener eventListener=new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    t=0;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        if(t==0){
            return true;
        }
        else{
            return false;
        }

    }
}
