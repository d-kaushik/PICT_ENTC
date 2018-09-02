package com.example.kaushik.pictentc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText=(EditText)findViewById(R.id.login_username);
        InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(),InputMethodManager.RESULT_HIDDEN);
    }
    public void click(View view)
    {
        if(view.getId()==R.id.sign_up)
        {
            Intent intent=new Intent(this,signup.class);
            startActivity(intent);
        }
        else  if(view.getId()==R.id.login_username)
        {
            Intent intent=new Intent(this,login.class);
            startActivity(intent);
        }


    }

}
