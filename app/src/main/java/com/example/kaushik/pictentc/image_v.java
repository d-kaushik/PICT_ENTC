package com.example.kaushik.pictentc;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class image_v extends AppCompatActivity {
    TextView notice;
    ImageView imageView;
    String name,url;
    Uri link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_v);
        Bundle b=getIntent().getExtras();
        url=b.getString("url");
        name=b.getString("name");
        notice=(TextView)findViewById(R.id.im_v_text_notice_name);
        imageView=(ImageView)findViewById(R.id.im_v_image_notice);

    }

    @Override
    protected void onStart() {
        super.onStart();
        notice.setText(name);
        Picasso.with(getApplicationContext()).load(url).fit().centerInside().into(imageView);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.download, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.notice_download: {
                Uri link=Uri.parse(url);

                Intent intent=new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(link);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.apps.docs");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    startActivity(intent);
                }

            }
        }

        return super.onOptionsItemSelected(item);
    }

}
