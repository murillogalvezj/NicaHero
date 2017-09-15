package com.example.enrique.nicaherolayout;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enrique.nicaherolayout.FuenteArtistas;
import com.example.enrique.nicaherolayout.R;

import java.util.List;



public class viewHolderArtistas extends RecyclerView.ViewHolder implements View.OnClickListener{
    ImageView imagen_artista;
    TextView texto_artista;
    Button btn_artista;
    int Position;
    List<FuenteArtistas> listaObjetosa;

    public viewHolderArtistas(View itemView, List<FuenteArtistas> datos) {
        super(itemView);

        imagen_artista = (ImageView) itemView.findViewById(R.id.imagen_artista);
        texto_artista = (TextView) itemView.findViewById(R.id.texto_artista);
        btn_artista = (Button) itemView.findViewById(R.id.btn_artista);
        listaObjetosa = datos;

        btn_artista.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position=getAdapterPosition();
        FuenteArtistas objeto = listaObjetosa.get(position);
        if (view.getId()==btn_artista.getId()){
            if (position==0){
                Intent intent = new Intent(view.getContext(),Artista1Activity.class);
                view.getContext().startActivity(intent);
            }
            if (position==1){
                Intent intent = new Intent(view.getContext(),Artista2Activity.class);
                view.getContext().startActivity(intent);
            }
            if (position==2){
                Intent intent = new Intent(view.getContext(),Artista3Activity.class);
                view.getContext().startActivity(intent);
            }
            if (position==3){
                Intent intent = new Intent(view.getContext(),Artista5Activity.class);
                view.getContext().startActivity(intent);
            }
            if (position==4){
                Intent intent = new Intent(view.getContext(),Artista6Activity.class);
                view.getContext().startActivity(intent);
            }
            //if (position==5){
              //  Intent intent = new Intent(view.getContext(),Artista6Activity.class);
               // view.getContext().startActivity(intent);
           // }
            //if (position==6){
              //  Intent intent = new Intent(view.getContext(),Artista7Activity.class);
           //     view.getContext().startActivity(intent);
           // }
        }
    }

}
