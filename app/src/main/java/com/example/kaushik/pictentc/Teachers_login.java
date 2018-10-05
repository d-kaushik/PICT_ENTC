package com.example.kaushik.pictentc;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Teachers_login extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner_sub,spinner_year,spinner_type;
    //ProgressBar progressBar;
    Button button_upload, button_select;
    TextView status;
    FirebaseStorage storage;
    FirebaseDatabase database;
    Uri pdfUri;//URL for local storage
    ProgressDialog progressDialog;
    String year,sub,type;

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_login2);

        //progressBar=(ProgressBar)findViewById(R.id.teacher_login_progress);
        //progressBar.setVisibility(View.GONE);
        button_upload = (Button) findViewById(R.id.teacher_login_but_upload);
        button_select = (Button) findViewById(R.id.teacher_login_but_select);
        status = (TextView) findViewById(R.id.tl_stat);
        storage = FirebaseStorage.getInstance();//returns obj of firebase storage
        database = FirebaseDatabase.getInstance();

        button_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Teachers_login.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    selectFile();
                } else {
                    ActivityCompat.requestPermissions(Teachers_login.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 4);

                }
            }
        });
        button_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pdfUri != null) {
                    upLoadFile(pdfUri);
                } else {
                    Toast.makeText(getApplicationContext(), "Select a file", Toast.LENGTH_LONG).show();
                }

            }
        });


        spinner_year = (Spinner) findViewById(R.id.teacher_login_spinner_year);
        spinner_sub = (Spinner) findViewById(R.id.teacher_login_spinner_subject);
        spinner_type = (Spinner) findViewById(R.id.teacher_login_spinner_type);

        ArrayAdapter<CharSequence> adapter_year = ArrayAdapter.createFromResource(this, R.array.Year, R.layout.support_simple_spinner_dropdown_item);
        adapter_year.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_year.setAdapter(adapter_year);
        spinner_year.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter_type = ArrayAdapter.createFromResource(this, R.array.type, R.layout.support_simple_spinner_dropdown_item);
        adapter_type.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_type.setAdapter(adapter_type);
        spinner_type.setOnItemSelectedListener(this);
    }

    private void upLoadFile(Uri pdfUri) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File...");
        progressDialog.setProgress(0);
        progressDialog.show();
        year=spinner_year.getSelectedItem().toString();
        sub=spinner_sub.getSelectedItem().toString();
        type=spinner_type.getSelectedItem().toString();

        final String fileName = System.currentTimeMillis() + ".pdf";
        final String fileName1= System.currentTimeMillis()+"";
        StorageReference storageReference = storage.getReference();//root path
        storageReference.child("Uploads").child(year).child(sub).child(type).child(fileName).putFile(pdfUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        String url = taskSnapshot.getDownloadUrl().toString();
                        //store in database
                        DatabaseReference databaseReference = database.getReference();
                        databaseReference.child(year).child(sub).child(type).child(fileName1).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "File Uploaded", Toast.LENGTH_LONG).show();
                                    progressDialog.dismiss();
                                } else {
                                    Toast.makeText(getApplicationContext(), "File Not Uploaded", Toast.LENGTH_LONG).show();

                                }
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "File Not Uploaded", Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                //track progress
                //progress bar
                int currentProgress = (int) (100 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());

                progressDialog.setProgress(currentProgress);

            }

        });



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 4 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            selectFile();
        } else {
            Toast.makeText(getApplicationContext(), "Please provide permission", Toast.LENGTH_LONG).show();
        }
    }

    private void selectFile() {
        Intent intent = new Intent();
        //for pdf and ppt
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);//fetch files
        startActivityForResult(intent, 5);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //user has selected the file or not checking
        if (requestCode == 5 && resultCode == RESULT_OK && data != null) {
            pdfUri = data.getData();//URI of selected file
            Toast.makeText(getApplicationContext(),"File Selected:" + data.getData().getLastPathSegment(),Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "Please Select a File", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position).toString().trim().equals("SE")) {


            ArrayAdapter<CharSequence> adapter_sub = ArrayAdapter.createFromResource(this, R.array.SE, R.layout.support_simple_spinner_dropdown_item);
            adapter_sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_sub.setAdapter(adapter_sub);
            spinner_sub.setOnItemSelectedListener(this);
        } else if (parent.getItemAtPosition(position).toString().trim().equals("TE"))
        {

            ArrayAdapter<CharSequence> adapter_sub = ArrayAdapter.createFromResource(this, R.array.TE, R.layout.support_simple_spinner_dropdown_item);
            adapter_sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_sub.setAdapter(adapter_sub);
            spinner_sub.setOnItemSelectedListener(this);

        }
        else if (parent.getItemAtPosition(position).toString().trim().equals("BE"))
        {

            ArrayAdapter<CharSequence> adapter_sub = ArrayAdapter.createFromResource(this, R.array.BE, R.layout.support_simple_spinner_dropdown_item);
            adapter_sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner_sub.setAdapter(adapter_sub);
            spinner_sub.setOnItemSelectedListener(this);

        }
        status.setText(spinner_year.getSelectedItem().toString()+" "+spinner_sub.getSelectedItem().toString()+" "+spinner_type.getSelectedItem().toString());


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


   public void onClick(View view)
    {
        Intent intent=new Intent(this,Front.class);
        startActivity(intent);
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
