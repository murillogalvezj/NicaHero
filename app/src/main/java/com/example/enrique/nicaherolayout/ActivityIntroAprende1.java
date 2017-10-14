package com.example.enrique.nicaherolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityIntroAprende1 extends AppCompatActivity {

    ImageButton btnsig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_aprende1);

        btnsig = (ImageButton)findViewById(R.id.sig_aprende1);
        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Siguiente();
                finish();
            }
        });
    }

    public void Siguiente(){
        Intent intent = new Intent(this,ActivityIntroAprende2.class);
        startActivity(intent);
    }
}
