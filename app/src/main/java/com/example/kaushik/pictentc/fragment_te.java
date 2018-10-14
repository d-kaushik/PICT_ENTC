package com.example.kaushik.pictentc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class fragment_te extends Fragment implements View.OnClickListener {

    String Year,Sub,option;
    path path=new path();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_te,container,false);
        Button assignment,university,unit_test,other;
        assignment=(Button)view.findViewById(R.id.but_assign);
        university=(Button)view.findViewById(R.id.but_university_ppr);
        unit_test=(Button)view.findViewById(R.id.but_unit_test_ppr);
        other=(Button)view.findViewById(R.id.but_other);
        assignment.setOnClickListener(this);
        unit_test.setOnClickListener(this);
        university.setOnClickListener(this);
        other.setOnClickListener(this);
        Bundle bundle=this.getArguments();
        if(bundle!=null){
            Year=bundle.getString("Year");
            Sub=this.getArguments().getString("Sub");
            //Toast.makeText(getActivity(),Year+"1",Toast.LENGTH_SHORT).show();
        }








        return view;

    }



    public void onClick(View view) {

         switch (view.getId())
         {
             case R.id.but_assign:
             {
                 checknull();
                 option="Assignments";
                 Toast.makeText(getContext(),Year+" "+Sub+" "+option,Toast.LENGTH_SHORT).show();
                 Bundle bundle=new Bundle();
                 bundle.putString("Year",Year);
                 bundle.putString("Sub",Sub);
                 bundle.putString("option",option);
                 Intent intent=new Intent(getContext(),recycler.class);
                 intent.putExtra("Year",Year);
                 intent.putExtra("Sub",Sub);
                 intent.putExtra("option",option);
                 startActivity(intent);



                 break;
             }
             case R.id.but_university_ppr:
             {
                 checknull();
                 option="University papers";
                 Toast.makeText(getContext(),Year+" "+Sub+" "+option,Toast.LENGTH_SHORT).show();

                 Bundle bundle=new Bundle();
                 bundle.putString("Year",Year);
                 bundle.putString("Sub",Sub);
                 bundle.putString("option",option);
                 Intent intent=new Intent(getContext(),recycler.class);
                 intent.putExtra("Year",Year);
                 intent.putExtra("Sub",Sub);
                 intent.putExtra("option",option);
                 startActivity(intent);

                 break;


             }
             case R.id.but_unit_test_ppr:
             {
                 checknull();
                 option="Unit test Papers";
                 Toast.makeText(getContext(),Year+" "+Sub+" "+option,Toast.LENGTH_SHORT).show();

                 Bundle bundle=new Bundle();
                 bundle.putString("Year",Year);
                 bundle.putString("Sub",Sub);
                 bundle.putString("option",option);
                 Intent intent=new Intent(getContext(),recycler.class);
                 intent.putExtra("Year",Year);
                 intent.putExtra("Sub",Sub);
                 intent.putExtra("option",option);
                 startActivity(intent);
                 break;

             }
             case R.id.but_other:
             {
                 checknull();
                 option="Other";
                 Toast.makeText(getContext(),Year+" "+Sub+" "+option,Toast.LENGTH_SHORT).show();

                 Bundle bundle=new Bundle();
                 bundle.putString("Year ",Year);
                 bundle.putString("Sub",Sub);
                 bundle.putString("option",option);
                 Intent intent=new Intent(getContext(),recycler.class);
                 intent.putExtra("Year",Year);
                 intent.putExtra("Sub",Sub);
                 intent.putExtra("option",option);
                 startActivity(intent);
                    break;

             }
         }

    }



    public void checknull() {
        if(Year==null||Sub==null){
            Year=path.getYear();
            if(Year=="SE"){
                Sub="DSA";
            }else if(Year=="TE"){
                Sub="MC";
            }else if(Year=="BE"){
                Sub="VLSI";
            }
        }
    }


}

