package com.example.enrique.nicaherolayout;

/**
 * Created by enrique on 19/08/2017.
 */

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class EventoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.eventos_fragment_layout, container, false);

        ArrayList<FuenteEventos> lista = new ArrayList<FuenteEventos>();
        lista.add(new FuenteEventos("FICCUA 2017",R.drawable.evento1,0));
        lista.add(new FuenteEventos("Cantos a la Revolución",R.drawable.evento2,0));
        lista.add(new FuenteEventos("¡Mafia Funk en vivo!",R.drawable.evento3,0));
        lista.add(new FuenteEventos("Festival del gato 2.0",R.drawable.evento4,0));
        //lista.add(new FuenteEventos("Concierto IL VOLO",R.drawable.ejemplo_evento5,0));
        //lista.add(new FuenteEventos("Concierto por la patria!",R.drawable.ejemplo_evento6,0));
        // lista.add(new FuenteEventos("Carlos Mejia en vivo!",R.drawable.ejemplo_evento7,0));

        RecyclerView contenedor_evento = (RecyclerView) view.findViewById(R.id.contenedor_evento);
        contenedor_evento.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        contenedor_evento.setAdapter(new AdaptadorEvento(lista));
        contenedor_evento.setLayoutManager(layout);

        return view;

    }


}

