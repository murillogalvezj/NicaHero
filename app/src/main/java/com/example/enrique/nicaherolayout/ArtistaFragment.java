package com.example.enrique.nicaherolayout;

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

public class ArtistaFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_artista, container, false);

        ArrayList<com.example.enrique.nicaherolayout.FuenteArtistas> lista = new ArrayList<com.example.enrique.nicaherolayout.FuenteArtistas>();
        lista.add(new FuenteArtistas("Katia Cardenal",R.drawable.artista3,0));
        lista.add(new FuenteArtistas("Luis Enrique Mejía",R.drawable.artista2,0));
        lista.add(new FuenteArtistas("Carlos Mejía Godoy",R.drawable.artista1,0));
       // lista.add(new FuenteArtistas("Perrozompopo",R.drawable.artista4,0));
        lista.add(new FuenteArtistas("Hernaldo Zúñiga",R.drawable.artista5,0));
        lista.add(new FuenteArtistas("Luis Enrique Mejia Godoy",R.drawable.artista6,0));
        //lista.add(new FuenteArtistas("Salvador Cardenal",R.drawable.artista7,0));

        RecyclerView contenedor_artista = (RecyclerView) view.findViewById(R.id.contenedor_artistas);
        contenedor_artista.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(getContext());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        contenedor_artista.setAdapter(new AdaptadorArtista(lista));
        contenedor_artista.setLayoutManager(layout);

        return view;

    }


}
