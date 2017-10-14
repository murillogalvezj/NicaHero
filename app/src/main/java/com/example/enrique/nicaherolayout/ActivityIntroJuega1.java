package com.example.enrique.nicaherolayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by shelb on 13/10/2017.
 */

public class ActivityIntroJuega1 extends AppCompatActivity {

    ImageButton btnsig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_juega1);

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
        Intent intent = new Intent(this,PianoActivity.class);
        startActivity(intent);
    }
}
