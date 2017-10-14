package com.example.enrique.nicaherolayout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class TeoriaActivity extends AppCompatActivity{

    Button leccion1;
    Button leccion2;
    Button leccion3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria);

        leccion1 = (Button) findViewById(R.id.leccion1);
        leccion2 = (Button) findViewById(R.id.leccion2);
        leccion3 = (Button) findViewById(R.id.leccion3);



        leccion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leccion1();
            }
        });

        leccion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leccion2();
            }
        });

        leccion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leccion3();
            }
        });
    }

    public void leccion1(){
        Intent intent = new Intent(this,Leccion1.class);
        startActivity(intent);
    }

    public  void leccion2(){
        Intent intent = new Intent(this,Leccion2.class);
        startActivity(intent);
    }

    public  void leccion3(){
        Intent intent = new Intent(this,Leccion3.class);
        startActivity(intent);
    }

}


