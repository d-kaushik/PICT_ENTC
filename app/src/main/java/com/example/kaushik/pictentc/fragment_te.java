package com.example.kaushik.pictentc;

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



public class fragment_te extends Fragment implements View.OnClickListener {

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



        if(savedInstanceState==null)
        {

            FragmentTransaction ft=getChildFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container_option,new Fragment_Assignment()).commit();
        }
        return view;

    }

    public void onClick(View view) {

         switch (view.getId())
         {
             case R.id.but_assign:
             {

                 FragmentTransaction ft=getChildFragmentManager().beginTransaction();
                 ft.replace(R.id.fragment_container_option,new Fragment_Assignment()).commit();
                 break;
             }
             case R.id.but_university_ppr:
             {

                 FragmentTransaction ft=getChildFragmentManager().beginTransaction();
                 ft.replace(R.id.fragment_container_option,new Fragment_University_ppr()).commit();
                 break;
             }
             case R.id.but_unit_test_ppr:
             {

                 FragmentTransaction ft=getChildFragmentManager().beginTransaction();
                 ft.replace(R.id.fragment_container_option,new Fragment_Unit_test_ppr()).commit();
                 break;
             }
             case R.id.but_other:
             {

                 FragmentTransaction ft=getChildFragmentManager().beginTransaction();
                 ft.replace(R.id.fragment_container_option,new Fragment_Other()).commit();
                 break;
             }
         }

    }
}

