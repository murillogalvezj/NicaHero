package com.example.enrique.nicaherolayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by enrique on 08/07/2017.
 */

public class AdaptadorEvento extends RecyclerView.Adapter<viewHolderEventos> {

    List<FuenteEventos> listaObjetos;

    public AdaptadorEvento(List<FuenteEventos> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    @Override
    public viewHolderEventos onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_eventos,parent,false);
        return new viewHolderEventos(vista,listaObjetos);
    }

    @Override
    public void onBindViewHolder(viewHolderEventos holder, int position) {
        holder.texto_evento.setText(listaObjetos.get(position).getTitulo());
        holder.imagen_evento.setImageResource(listaObjetos.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return listaObjetos.size();
    }
}
