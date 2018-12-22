package com.example.kaushik.pictentc;

import android.app.ActionBar;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Front extends AppCompatActivity {

    private DrawerLayout dl;
    path path1=new path();
    int i,val;
    String val1;
    FirebaseDatabase firebaseDatabase;
    private ActionBarDrawerToggle abdt;
    NotificationManagerCompat notificationManagerCompat;

    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        dl=(DrawerLayout)findViewById(R.id.dl);
        abdt=new ActionBarDrawerToggle(this,dl, R.string.open, R.string.close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        final NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();

                if(id==R.id.notice)
                {
                    Intent intent=new Intent(Front.this,Notice.class);
                    startActivity(intent);


                }
                if(id==R.id.logout)
                {
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                dl.closeDrawer(GravityCompat.START);

                return true;
            }
        });
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);
        final SharedPreferences.Editor editor=pref.edit();
        final List<file> notifies;
        notifies=new ArrayList<>();
        firebaseDatabase=FirebaseDatabase.getInstance();
        final DatabaseReference reference=firebaseDatabase.getReference().child("Notification");
        final DatabaseReference reference1=firebaseDatabase.getReference().child("Notice_notif");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.exists()){
                    name=dataSnapshot.getKey();
                    val1=dataSnapshot.getValue().toString();
                    val=Integer.parseInt(val1);
                    if(!(pref.contains(name))){
                        editor.putInt(name,val);
                        editor.commit();
                    }
                    if(pref.getInt(name,1)==0){
                        sendOnchannel1(name);
                        editor.remove(name);
                        editor.putInt(name,1);
                        editor.commit();
                    }

                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot postsnap:dataSnapshot.getChildren()){
                        name=postsnap.getKey();
                        sendOnchannel1(name);
                    }
                }
                Toast.makeText(getApplicationContext(),"changed",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        reference1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if(dataSnapshot.exists()){
                    name=dataSnapshot.getKey();
                    val1=dataSnapshot.getValue().toString();
                    val=Integer.parseInt(val1);
                    if(!(pref.contains(name))){
                        editor.putInt(name,val);
                        editor.commit();
                    }
                    if(pref.getInt(name,1)==0){
                        sendOnchannel2(name);
                        editor.remove(name);
                        editor.putInt(name,1);
                        editor.commit();
                    }

                }

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

            }
        });





    }
    public void onClick(View view)
    {
        if(view.getId()==R.id.but_se)
        {
            Intent intent=new Intent(this,Year_SE.class);
            intent.putExtra("Year","SE");
            path1.setYear("SE");
            startActivity(intent);
        }
        else if(view.getId()==R.id.but_te)
        {
            Intent intent=new Intent(this,Year_TE.class);
            intent.putExtra("Year","TE");
            path1.setYear("TE");
            startActivity(intent);
        }
        else if(view.getId()==R.id.but_be)
        {
            Intent intent=new Intent(this,Year_BE.class);
            intent.putExtra("Year","BE");
            path1.setYear("BE");
            startActivity(intent);
        }



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
    public void sendOnchannel2(String name){
        notificationManagerCompat = NotificationManagerCompat.from(this);
        String titl="Notice:";
        String msg=name;
        Intent intent=new Intent(this,Notice.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this,App.Channel_notice_id)
                .setSmallIcon(R.drawable.student)
                .setContentTitle(titl)
                .setContentText(msg)
                .setContentIntent(contentIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        notificationManagerCompat.notify(i,notification);

        if(i==100){
            i=0;
        }
        else{
            i++;
        }
    }
    public void sendOnchannel1(String name){
        notificationManagerCompat = NotificationManagerCompat.from(this);
        String titl="New file added";
        String msg=name+" uploaded";
        Intent intent=new Intent(this,Front.class);
        PendingIntent contentIntent=PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this,App.Channel_file_id)
                .setSmallIcon(R.drawable.student)
                .setContentTitle(titl)
                .setContentText(msg)
                .setContentIntent(contentIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        notificationManagerCompat.notify(i,notification);

        if(i==100){
            i=0;
        }
        else{
            i++;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,login.class));
        }
        if(!(FirebaseAuth.getInstance().getCurrentUser().isEmailVerified())){
            finish();
            startActivity(new Intent(this,verify.class));

        }


    }
}
