package com.example.enrique.nicaherolayout;

import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shelb on 7/10/2017.
 */

public class AprendeActivity extends AppCompatActivity{

    Button c4, d4, e4, f4, g4, a4, b4, c5, d5, e5, f5, g5, a5, b5, c6, cs4, ds4, fs4, gs4, as4, cs5, ds5, fs5, gs5, as5, cs6;
    Button play1, play2;
    private SoundPool sonidos;
    private int SonidoC4, SonidoD4, SonidoE4, SonidoF4, SonidoG4, SonidoA4, SonidoB4, SonidoC5, SonidoD5, SonidoE5, SonidoF5, SonidoG5, SonidoA5, SonidoB5, SonidoC6;
    private int SonidoCS4, SonidoDS4, SonidoFS4, SonidoGS4, SonidoAS4, SonidoCS5, SonidoDS5, SonidoFS5, SonidoGS5, SonidoAS5;
    HorizontalScrollView scroll;
    final Timer timer = new Timer();
    boolean bandera=false;

    int flag = 0;
    private VideoView video;
    MediaController mediaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende);

        c4 = (Button) findViewById(R.id.C4);
        d4 = (Button) findViewById(R.id.D4);
        e4 = (Button) findViewById(R.id.E4);
        f4 = (Button) findViewById(R.id.F4);
        g4 = (Button) findViewById(R.id.G4);
        a4 = (Button) findViewById(R.id.A4);
        b4 = (Button) findViewById(R.id.B4);
        c5 = (Button) findViewById(R.id.C5);
        d5 = (Button) findViewById(R.id.D5);
        e5 = (Button) findViewById(R.id.E5);
        f5 = (Button) findViewById(R.id.F5);
        g5 = (Button) findViewById(R.id.G5);
        a5 = (Button) findViewById(R.id.A5);
        b5 = (Button) findViewById(R.id.B5);
        c6 = (Button) findViewById(R.id.C6);
        cs4 = (Button) findViewById(R.id.CS4);
        ds4 = (Button) findViewById(R.id.DS4);
        fs4 = (Button) findViewById(R.id.FS4);
        gs4 = (Button) findViewById(R.id.GS4);
        as4 = (Button) findViewById(R.id.AS4);
        cs5 = (Button) findViewById(R.id.CS5);
        ds5 = (Button) findViewById(R.id.DS5);
        fs5 = (Button) findViewById(R.id.FS5);
        gs5 = (Button) findViewById(R.id.GS5);
        as5 = (Button) findViewById(R.id.AS5);
        cs6 = (Button) findViewById(R.id.CS6);
        play1 = (Button) findViewById(R.id.py1);
        play2 = (Button) findViewById(R.id.py2);

        scroll = (HorizontalScrollView) findViewById(R.id.scroll);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sonidos = new SoundPool.Builder().setMaxStreams(5).build();
        } else {
            sonidos = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        SonidoC4 = sonidos.load(this, R.raw.c4, 1);
        SonidoD4 = sonidos.load(this, R.raw.d4, 1);
        SonidoE4 = sonidos.load(this, R.raw.e4, 1);
        SonidoF4 = sonidos.load(this, R.raw.f4, 1);
        SonidoG4 = sonidos.load(this, R.raw.g4, 1);
        SonidoA4 = sonidos.load(this, R.raw.a4, 1);
        SonidoB4 = sonidos.load(this, R.raw.b4, 1);
        SonidoC5 = sonidos.load(this, R.raw.c5, 1);
        SonidoD5 = sonidos.load(this, R.raw.d5, 1);
        SonidoE5 = sonidos.load(this, R.raw.e5, 1);
        SonidoF5 = sonidos.load(this, R.raw.f5, 1);
        SonidoG5 = sonidos.load(this, R.raw.g5, 1);
        SonidoA5 = sonidos.load(this, R.raw.a5, 1);
        SonidoB5 = sonidos.load(this, R.raw.b5, 1);
        SonidoC6 = sonidos.load(this, R.raw.c6, 1);
        SonidoCS4 = sonidos.load(this, R.raw.cs4, 1);
        SonidoDS4 = sonidos.load(this, R.raw.ds4, 1);
        SonidoFS4 = sonidos.load(this, R.raw.fs4, 1);
        SonidoGS4 = sonidos.load(this, R.raw.gs4, 1);
        SonidoAS4 = sonidos.load(this, R.raw.as4, 1);
        SonidoCS5 = sonidos.load(this, R.raw.cs5, 1);
        SonidoDS5 = sonidos.load(this, R.raw.ds5, 1);
        SonidoFS5 = sonidos.load(this, R.raw.fs5, 1);
        SonidoGS5 = sonidos.load(this, R.raw.gs5, 1);
        SonidoAS5 = sonidos.load(this, R.raw.as5, 1);



        video = (VideoView) findViewById(R.id.video1);

        mediaC = new MediaController(this);

        //Aqui comienzan las declaraciones de todos los botones
        c4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                    c4.setBackgroundResource(R.drawable.ateclai);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    c4.setBackgroundResource(R.drawable.teclai);
                }
                return false;
            }
        });

        d4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                    d4.setBackgroundResource(R.drawable.ateclam);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    d4.setBackgroundResource(R.drawable.teclam);
                }
                return false;
            }
        });

        e4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                    e4.setBackgroundResource(R.drawable.ateclad);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    e4.setBackgroundResource(R.drawable.teclad);
                }
                return false;
            }
        });

        f4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                    f4.setBackgroundResource(R.drawable.ateclai);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    f4.setBackgroundResource(R.drawable.teclai);
                }
                return false;
            }
        });

        g4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                    g4.setBackgroundResource(R.drawable.ateclaim);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    g4.setBackgroundResource(R.drawable.teclaim);
                }
                return false;
            }
        });

        a4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                    a4.setBackgroundResource(R.drawable.atecladm);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    a4.setBackgroundResource(R.drawable.tecladm);
                }
                return false;
            }
        });

        b4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoB4, 1, 1, 0, 0, 1);
                    b4.setBackgroundResource(R.drawable.ateclad);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    b4.setBackgroundResource(R.drawable.teclad);
                }
                return false;
            }
        });

        c5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                    c5.setBackgroundResource(R.drawable.ateclai);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    c5.setBackgroundResource(R.drawable.teclai);
                }
                return false;
            }
        });

        d5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoD5, 1, 1, 0, 0, 1);
                    d5.setBackgroundResource(R.drawable.ateclam);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    d5.setBackgroundResource(R.drawable.teclam);
                }
                return false;
            }
        });

        e5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoE5, 1, 1, 0, 0, 1);
                    e5.setBackgroundResource(R.drawable.ateclad);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    e5.setBackgroundResource(R.drawable.teclad);
                }
                return false;
            }
        });

        f5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoF5, 1, 1, 0, 0, 1);
                    f5.setBackgroundResource(R.drawable.ateclai);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    f5.setBackgroundResource(R.drawable.teclai);
                }
                return false;
            }
        });

        g5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoG5, 1, 1, 0, 0, 1);
                    g5.setBackgroundResource(R.drawable.ateclaim);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    g5.setBackgroundResource(R.drawable.teclaim);
                }
                return false;
            }
        });

        a5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoA5, 1, 1, 0, 0, 1);
                    a5.setBackgroundResource(R.drawable.atecladm);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    a5.setBackgroundResource(R.drawable.tecladm);
                }
                return false;
            }
        });

        b5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoB5, 1, 1, 0, 0, 1);
                    b5.setBackgroundResource(R.drawable.ateclad);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    b5.setBackgroundResource(R.drawable.teclad);
                }
                return false;
            }
        });

        c6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoC6, 1, 1, 0, 0, 1);
                    c6.setBackgroundResource(R.drawable.ateclai);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    c6.setBackgroundResource(R.drawable.teclai);
                }
                return false;
            }
        });

        cs4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoCS4, 1, 1, 0, 0, 1);
                    cs4.setBackgroundResource(R.drawable.ateclasostenido);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    cs4.setBackgroundResource(R.drawable.teclasostenido);
                }
                return false;
            }
        });

        ds4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoDS4, 1, 1, 0, 0, 1);
                    ds4.setBackgroundResource(R.drawable.ateclasostenido);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    ds4.setBackgroundResource(R.drawable.teclasostenido);
                }
                return false;
            }
        });

        fs4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoFS4, 1, 1, 0, 0, 1);
                    fs4.setBackgroundResource(R.drawable.ateclasostenido);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    fs4.setBackgroundResource(R.drawable.teclasostenido);
                }
                return false;
            }
        });

        gs4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoGS4, 1, 1, 0, 0, 1);
                    gs4.setBackgroundResource(R.drawable.ateclasostenido);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    gs4.setBackgroundResource(R.drawable.teclasostenido);
                }
                return false;
            }
        });

        as4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoAS4, 1, 1, 0, 0, 1);
                    as4.setBackgroundResource(R.drawable.ateclasostenido);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    as4.setBackgroundResource(R.drawable.teclasostenido);
                }
                return false;
            }
        });

        cs5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoCS5, 1, 1, 0, 0, 1);
                    cs5.setBackgroundResource(R.drawable.ateclasostenido);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    cs5.setBackgroundResource(R.drawable.teclasostenido);
                }
                return false;
            }
        });

        ds5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoDS5, 1, 1, 0, 0, 1);
                    ds5.setBackgroundResource(R.drawable.ateclasostenido);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    ds5.setBackgroundResource(R.drawable.teclasostenido);
                }
                return false;
            }
        });

        fs5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoFS5, 1, 1, 0, 0, 1);
                    fs5.setBackgroundResource(R.drawable.ateclasostenido);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    fs5.setBackgroundResource(R.drawable.teclasostenido);
                }
                return false;
            }
        });

        gs5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoGS5, 1, 1, 0, 0, 1);
                    gs5.setBackgroundResource(R.drawable.ateclasostenido);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    gs5.setBackgroundResource(R.drawable.teclasostenido);
                }
                return false;
            }
        });

        as5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoAS5, 1, 1, 0, 0, 1);
                    as5.setBackgroundResource(R.drawable.ateclasostenido);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    as5.setBackgroundResource(R.drawable.teclasostenido);
                }
                return false;
            }
        });

        cs6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoCS5, 1, 1, 0, 0, 1);
                    cs6.setBackgroundResource(R.drawable.ateclasostenido);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    cs6.setBackgroundResource(R.drawable.teclasostenido);
                }
                return false;
            }
        });

        scroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            bandera = false;
                        }
                    }, 1000);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    c4.setBackgroundResource(R.drawable.teclai);
                    d4.setBackgroundResource(R.drawable.teclam);
                    e4.setBackgroundResource(R.drawable.teclad);
                    f4.setBackgroundResource(R.drawable.teclai);
                    g4.setBackgroundResource(R.drawable.teclaim);
                    a4.setBackgroundResource(R.drawable.tecladm);
                    b4.setBackgroundResource(R.drawable.teclad);
                    c5.setBackgroundResource(R.drawable.teclai);
                    d5.setBackgroundResource(R.drawable.teclam);
                    e5.setBackgroundResource(R.drawable.teclad);
                    f5.setBackgroundResource(R.drawable.teclai);
                    g5.setBackgroundResource(R.drawable.teclaim);
                    a5.setBackgroundResource(R.drawable.tecladm);
                    b5.setBackgroundResource(R.drawable.teclad);
                    c6.setBackgroundResource(R.drawable.teclai);
                    cs4.setBackgroundResource(R.drawable.teclasostenido);
                    ds4.setBackgroundResource(R.drawable.teclasostenido);
                    fs4.setBackgroundResource(R.drawable.teclasostenido);
                    gs4.setBackgroundResource(R.drawable.teclasostenido);
                    as4.setBackgroundResource(R.drawable.teclasostenido);
                    cs5.setBackgroundResource(R.drawable.teclasostenido);
                    ds5.setBackgroundResource(R.drawable.teclasostenido);
                    fs5.setBackgroundResource(R.drawable.teclasostenido);
                    gs5.setBackgroundResource(R.drawable.teclasostenido);
                    as5.setBackgroundResource(R.drawable.teclasostenido);
                    cs6.setBackgroundResource(R.drawable.teclasostenido);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            bandera = true;
                        }
                    }, 1000);
                }
                return bandera;
            }
        });

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String videopath = "android.resource://com.example.enrique.pginterfaz/"+R.raw.libro2;
                Uri uri = Uri.parse(videopath);
                video.setVideoURI(uri);
                if (flag==0)
                {
                    /*video.setMediaController(mediaC);
                    mediaC.setAnchorView(video);*/
                    video.start();
                    flag = 1;
                }
                else
                {
                    video.stopPlayback();
                    flag = 0;
                }
            }
        });
    }
}
