package com.example.kaushik.pictentc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        Bundle b=getIntent().getExtras();
        Year=b.getString("Year");
        Sub=b.getString("Sub");
        option=b.getString("option");
        recyclerView=findViewById(R.id.recyclerView);
        //custom adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(recycler.this));
        Adapter adapter=new Adapter(recyclerView,recycler.this,new ArrayList<String>(),new ArrayList<String>());
        recyclerView.setAdapter(adapter);
        String fileName="ABC";
        String url="www.google.co.in";
        ((Adapter)recyclerView.getAdapter()).update(fileName,url);


        databaseReference= FirebaseDatabase.getInstance().getReference("TE");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot post : dataSnapshot.getChildren()){
                    String fileName=post.getKey();
                    Toast.makeText(recycler.this,fileName,Toast.LENGTH_LONG).show();
                    String url=post.getValue(String.class);
                    ((Adapter)recyclerView.getAdapter()).update(fileName,url);



                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(recycler.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }
}
