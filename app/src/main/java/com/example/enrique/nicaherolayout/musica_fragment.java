package com.example.enrique.nicaherolayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by enrique on 28/06/2017.
 */

public class musica_fragment extends Fragment implements View.OnClickListener {

    ImageButton btn_libre;
    ImageButton btn_teoria;
    ImageButton btn_ensayo;
    ImageButton btn_aprende;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.musica_fragment_layout, container, false);

        getActivity().setTitle("Musica");

        btn_libre = (ImageButton) view.findViewById(R.id.btn_libre);
        btn_libre.setOnClickListener(this);

        btn_ensayo = (ImageButton) view.findViewById(R.id.btn_evaluate);
        btn_ensayo.setOnClickListener(this);

        btn_teoria = (ImageButton) view.findViewById(R.id.btn_teoria);
        btn_teoria.setOnClickListener(this);

        btn_aprende = (ImageButton) view.findViewById(R.id.btn_aprende);
        btn_aprende.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == btn_libre.getId()) {

            Intent intent = new Intent(view.getContext(), PianoActivity.class);
            view.getContext().startActivity(intent);

        }

        if (view.getId() == btn_aprende.getId()) {

            Intent intent = new Intent(view.getContext(), AprendeActivity.class);
            view.getContext().startActivity(intent);

        }

        if (view.getId() == btn_teoria.getId()) {

            Fragment fragment = null;
            FragmentManager fragmentManager = getFragmentManager();
            fragment = new TeoriaActivity();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_main, fragment);
            fragmentTransaction.commit();

            //Intent intent = new Intent(view.getContext(), TeoriaActivity.class);
            //view.getContext().startActivity(intent);

        }

        if (view.getId() == btn_ensayo.getId()) {

            Intent intent = new Intent(view.getContext(), EvaluateActivity.class);
            view.getContext().startActivity(intent);

        }

    }



}
