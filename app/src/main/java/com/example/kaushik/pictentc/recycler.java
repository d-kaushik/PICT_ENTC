package com.example.kaushik.pictentc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by hp on 06-10-2018.
 */

public class recycler extends AppCompatActivity {
    String Year,Sub,option;
    RecyclerView recyclerView;
    path path=new path();

    DatabaseReference databaseReference,reference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        Bundle b=getIntent().getExtras();
        Year=path.getYear();
        Sub=b.getString("Sub");
        option=b.getString("option");
        recyclerView=findViewById(R.id.recyclerView);
        //custom adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(recycler.this));
        Adapter adapter=new Adapter(recyclerView,recycler.this,new ArrayList<String>(),new ArrayList<String>());
        recyclerView.setAdapter(adapter);






        databaseReference= FirebaseDatabase.getInstance().getReference();
        reference=databaseReference.child("Uploads").child(Year).child(Sub).child(option);
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                file file1=new file();
                file1=dataSnapshot.getValue(file.class);
                String fileName=file1.getFileName();
                String url=file1.getUrl();
                ((Adapter)recyclerView.getAdapter()).update(fileName,url);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(recycler.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

}
