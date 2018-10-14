package com.example.kaushik.pictentc;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 06-10-2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    RecyclerView recyclerView;
    Context context;
    List<file> mfiles;
    OnItemClickListener mListener;
    FirebaseAuth mAuth;

    public String getmAuth() {
        mAuth=FirebaseAuth.getInstance();
        String mail=mAuth.getCurrentUser().getEmail();
        return mail;
    }
   /* public void update(String name,String url){
        items.add(name);
        urls.add(url);
        notifyDataSetChanged();//refreshes recycler view
    }*/

    public Adapter(Context context,List<file>files) {
        this.context = context;
        this.mfiles=files;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        file file=mfiles.get(i);
        viewHolder.name_file.setText(file.getFileName());


    }

    @Override
    public int getItemCount() {
        return mfiles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        TextView name_file;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            String mail;
            mail=getmAuth();
            name_file=itemView.findViewById(R.id.nameOfFile);

            if(mail.equals("teachers.pict@gmail.com")){
                itemView.setOnCreateContextMenuListener(this);
                itemView.setOnClickListener(this);
            }else{
                itemView.setOnClickListener(this);
            }

        }
        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            file file=mfiles.get(position);
            String url=Uri.parse(file.getUrl()).toString();
            if (!url.startsWith("http://") && !url.startsWith("https://")){
                url = "http://" + url;
            }
            Uri link=Uri.parse(url);

            Intent intent=new Intent();
            intent.setType(Intent.ACTION_VIEW);
            intent.setData(link);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //intent.setPackage("com.android.chrome");
            intent.setPackage("com.google.android.apps.docs");
            //
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException ex) {
                // Chrome browser presumably not installed so allow user to choose instead
                intent.setPackage(null);
                context.startActivity(intent);
            }

            Toast.makeText(context,Uri.parse(file.getUrl()).toString(),Toast.LENGTH_LONG).show();


        }
        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Select Action");
            MenuItem delete= contextMenu.add(Menu.NONE,1,1,"Delete");
            delete.setOnMenuItemClickListener(this);

        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            if(mListener!=null){
                int position=getAdapterPosition();
                if(position!=RecyclerView.NO_POSITION){
                    switch (menuItem.getItemId()){
                        case 1:
                            mListener.onDeleteClick(position);
                            return true;
                    }
                }
            }
            return false;
        }



    }
    public interface OnItemClickListener{
        void onItemClick(int position);


        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }

}
