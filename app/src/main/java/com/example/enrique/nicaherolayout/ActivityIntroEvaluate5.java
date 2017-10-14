package com.example.enrique.nicaherolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ActivityIntroEvaluate5 extends AppCompatActivity {

    ImageButton btnsig,btnatras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_evaluate5);

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
        Intent intent = new Intent(this,EvaluateActivity.class);
        startActivity(intent);
    }

    public void Atras(){
        Intent intent = new Intent(this,ActivityIntroEvaluate4.class);
        startActivity(intent);
    }
}

