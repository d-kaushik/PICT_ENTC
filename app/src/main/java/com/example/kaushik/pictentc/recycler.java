package com.example.kaushik.pictentc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 06-10-2018.
 */

public class recycler extends AppCompatActivity implements Adapter.OnItemClickListener{
    String Year,Sub,option;
    RecyclerView recyclerView;
    path path=new path();
    String key;
    FirebaseStorage mStorage;
    ValueEventListener mDBListener;
    private List<file> mfiles;
    Adapter mAdapter;


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
        mfiles=new ArrayList<>();
        //custom adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(recycler.this));
        mAdapter=new Adapter(recycler.this,mfiles);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(recycler.this);
        mStorage=FirebaseStorage.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        reference=databaseReference.child("Uploads").child(Year).child(Sub).child(option);
        mDBListener=reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mfiles.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    file file = postSnapshot.getValue(file.class);
                    file.setMkey(postSnapshot.getKey());
                    mfiles.add(file);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(recycler.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,"CLICK AT"+position,Toast.LENGTH_LONG).show();
    }



    @Override
    public void onDeleteClick(int position) {
        file selectedItem=mfiles.get(position);
        final String selectedKey=selectedItem.getMkey();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        reference=databaseReference.child("Uploads").child(Year).child(Sub).child(option);
        StorageReference storageReference=mStorage.getReferenceFromUrl(selectedItem.getUrl());


        storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                reference.child(selectedKey).removeValue();
                Toast.makeText(recycler.this, "File Deleted", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
