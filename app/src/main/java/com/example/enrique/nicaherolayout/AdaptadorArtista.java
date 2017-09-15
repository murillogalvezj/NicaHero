package com.example.enrique.nicaherolayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.enrique.nicaherolayout.FuenteArtistas;
import com.example.enrique.nicaherolayout.R;
import com.example.enrique.nicaherolayout.viewHolderArtistas;

import java.util.List;

/**
 * Created by enrique on 09/07/2017.
 */

public class AdaptadorArtista extends RecyclerView.Adapter<viewHolderArtistas> {
    List<FuenteArtistas> listaObjetosa;

    public AdaptadorArtista(List<FuenteArtistas> listaObjetosa) {
        this.listaObjetosa = listaObjetosa;
    }

    @Override
    public com.example.enrique.nicaherolayout.viewHolderArtistas onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_artistas,parent,false);
        return new viewHolderArtistas(vista,listaObjetosa);
    }

    @Override
    public void onBindViewHolder(viewHolderArtistas holder, int position) {
        holder.texto_artista.setText(listaObjetosa.get(position).getTitulo());
        holder.imagen_artista.setImageResource(listaObjetosa.get(position).getImagen());
    }


    @Override
    public int getItemCount() {
        return listaObjetosa.size();
    }
}
