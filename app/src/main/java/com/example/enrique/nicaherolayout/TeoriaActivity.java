package com.example.enrique.nicaherolayout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TeoriaActivity extends Fragment{

    Button leccion1;
    Button leccion2;
    Button leccion3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_teoria, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        leccion1 = (Button) view.findViewById(R.id.leccion1);
        leccion2 = (Button) view.findViewById(R.id.leccion2);
        leccion3 = (Button) view.findViewById(R.id.leccion3);

        leccion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = null;
                FragmentManager fragmentManager = getFragmentManager();
                fragment = new Leccion1();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_main, fragment);
                fragmentTransaction.commit();
            }
        });

        leccion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = null;
                FragmentManager fragmentManager = getFragmentManager();
                fragment = new Leccion2();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_main, fragment);
                fragmentTransaction.commit();
            }
        });

        leccion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = null;
                FragmentManager fragmentManager = getFragmentManager();
                fragment = new Leccion3();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_main, fragment);
                fragmentTransaction.commit();
            }
        });
        getActivity().setTitle("Teoria");
    }

}
