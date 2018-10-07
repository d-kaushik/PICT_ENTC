package com.example.kaushik.pictentc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hp on 06-10-2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    RecyclerView recyclerView;
    Context context;
    ArrayList<String> items=new ArrayList<>();
    ArrayList<String> urls=new ArrayList<>();
    public void update(String name,String url){
        items.add(name);
        urls.add(url);
        notifyDataSetChanged();//refreshes recycler view
    }

    public Adapter(RecyclerView recyclerView, Context context, ArrayList<String> items, ArrayList<String> urls) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.items = items;
        this.urls = urls;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name_file.setText(items.get(i));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name_file;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_file=itemView.findViewById(R.id.nameOfFile);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=recyclerView.getChildLayoutPosition(view);
                    String url=Uri.parse(urls.get(position)).toString();
                    if (!url.startsWith("http://") && !url.startsWith("https://")){
                        url = "http://" + url;
                    }
                    Uri link=Uri.parse(url);

                    Intent intent=new Intent();
                    intent.setType(Intent.ACTION_VIEW);
                    intent.setData(link);
                    context.startActivity(intent);
                    Toast.makeText(context,Uri.parse(urls.get(position)).toString(),Toast.LENGTH_LONG).show();
                }
            });

        }
    }

}
