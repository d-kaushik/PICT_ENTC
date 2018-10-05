package com.example.kaushik.pictentc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment_Unit_test_ppr extends Fragment {
    String Year,Sub,option;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle=this.getArguments();
        if(bundle!=null){
            Year=bundle.getString("Year");
            Sub=this.getArguments().getString("Sub");
            option=this.getArguments().getString("option");
            Toast.makeText(getActivity(),Year+" "+Sub+" "+option,Toast.LENGTH_SHORT).show();
        }
        return inflater.inflate(R.layout.fragment_unit_test_ppr,container,false);
    }
}
