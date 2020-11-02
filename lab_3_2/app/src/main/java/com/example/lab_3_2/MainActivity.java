package com.example.lab_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bn=(Button)findViewById(R.id.clickme);
        LayoutInflater inflater=MainActivity.this.getLayoutInflater();
        View v= inflater.inflate(R.layout.alerdialog,null,false);
        Context context=MainActivity.this;
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setView(v);
        builder.setCancelable(false);
        final AlertDialog alertDialog=builder.create();
        bn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                alertDialog.show();
            }
        });
        v.findViewById(R.id.cancle).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity.this,"cancle",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
        v.findViewById(R.id.signin).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity.this,"Sign in",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
    }
}
