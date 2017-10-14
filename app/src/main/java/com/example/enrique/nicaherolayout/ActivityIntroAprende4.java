package com.example.enrique.nicaherolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ActivityIntroAprende4 extends AppCompatActivity {

    ImageButton btnsig,btnatras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_aprende4);

        btnsig = (ImageButton)findViewById(R.id.sig_aprende1);
        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Siguiente();
                finish();
            }
        });

        btnatras = (ImageButton)findViewById(R.id.atras_aprende1);
        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Atras();
                finish();
            }
        });
    }

    public void Siguiente(){
        Intent intent = new Intent(this,AprendeActivity.class);
        startActivity(intent);
    }

    public void Atras(){
        Intent intent = new Intent(this,ActivityIntroAprende3.class);
        startActivity(intent);
    }
}

