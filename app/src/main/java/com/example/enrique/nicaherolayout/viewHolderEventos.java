package com.example.enrique.nicaherolayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static java.security.AccessController.getContext;


public class viewHolderEventos extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imagen_evento;
    TextView texto_evento;
    Button btn_evento;
    int Position;
    List<FuenteEventos> listaObjetos;

    public viewHolderEventos(View itemView,  List<FuenteEventos> datos) {
        super(itemView);

        imagen_evento = (ImageView) itemView.findViewById(R.id.imagen_evento);
        texto_evento = (TextView) itemView.findViewById(R.id.texto_evento);
        btn_evento = (Button) itemView.findViewById(R.id.btn_evento);
        listaObjetos = datos;

        btn_evento.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position=getAdapterPosition();
        FuenteEventos objeto = listaObjetos.get(position);
        if (view.getId()==btn_evento.getId()){
            if (position==0){
                Intent intent = new Intent(view.getContext(),Evento1Activity.class);
                view.getContext().startActivity(intent);
            }
            if (position==1){
                Intent intent = new Intent(view.getContext(),Evento2Activity.class);
                view.getContext().startActivity(intent);
            }
            if (position==2){
                Intent intent = new Intent(view.getContext(),Evento3Activity.class);
                view.getContext().startActivity(intent);
            }
            if (position==3){
                Intent intent = new Intent(view.getContext(),Evento4Activity.class);
                view.getContext().startActivity(intent);
            }
            //if (position==4){
            //   Intent intent = new Intent(view.getContext(),Evento5Activity.class);
            //   view.getContext().startActivity(intent);
            // }
            //if (position==5){
            //    Intent intent = new Intent(view.getContext(),Evento6Activity.class);
            //    view.getContext().startActivity(intent);
            // }
            // if (position==6){
            //     Intent intent = new Intent(view.getContext(),Evento7Activity.class);
            //     view.getContext().startActivity(intent);
            // }
        }
    }


}
