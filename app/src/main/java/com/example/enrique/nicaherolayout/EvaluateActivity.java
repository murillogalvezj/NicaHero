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
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shelb on 7/10/2017.
 */

public class EvaluateActivity extends AppCompatActivity{

    Button c4, d4, e4, f4, g4, a4, b4, c5, d5, e5, f5, g5, a5, b5, c6, cs4, ds4, fs4, gs4, as4, cs5, ds5, fs5, gs5, as5, cs6;
    ImageButton play1;
    ImageButton play2;
    TextView puntaje;
    private SoundPool sonidos;
    private int SonidoC4, SonidoD4, SonidoE4, SonidoF4, SonidoG4, SonidoA4, SonidoB4, SonidoC5, SonidoD5, SonidoE5, SonidoF5, SonidoG5, SonidoA5, SonidoB5, SonidoC6;
    private int SonidoCS4, SonidoDS4, SonidoFS4, SonidoGS4, SonidoAS4, SonidoCS5, SonidoDS5, SonidoFS5, SonidoGS5, SonidoAS5;
    HorizontalScrollView scroll;
    final Timer timer = new Timer();
    boolean bandera=false;
    String cont;
    int turno=0;
    int flag = 0;
    int flag1 = 0;
    int puntos=0;
    private VideoView video;
    MediaController mediaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

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
        play1 = (ImageButton) findViewById(R.id.py1);
        play2 = (ImageButton) findViewById(R.id.py2);
        puntaje = (TextView) findViewById(R.id.puntaje);
        cont=String.valueOf(puntos);
        puntaje.setText(cont);

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

       declaraciones();
        //Aqui comienzan las declaraciones de todos los botones









        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String videopath = "android.resource://com.example.enrique.nicaherolayout/"+R.raw.libro2;
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

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String videopath = "android.resource://com.example.enrique.nicaherolayout/"+R.raw.libro;
                Uri uri = Uri.parse(videopath);
                video.setVideoURI(uri);
                if (flag1==0)
                {
                    /*video.setMediaController(mediaC);
                    mediaC.setAnchorView(video);*/
                    video.start();
                    flag1 = 1;
                }
                else
                {
                    video.stopPlayback();
                    flag1 = 0;
                }
            }
        });

    }

    public void declaraciones(){





        c4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                    c4.setBackgroundResource(R.drawable.ateclai);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    c4.setBackgroundResource(R.drawable.teclai);
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
                }
                return false;
            }
        });

        c5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                declaraciones();
                if (m.getAction() == MotionEvent.ACTION_DOWN) {
                    sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                    c5.setBackgroundResource(R.drawable.ateclai);
                }
                if (m.getAction() == MotionEvent.ACTION_UP) {
                    c5.setBackgroundResource(R.drawable.teclai);
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
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
                    video.stopPlayback();
                }
                return false;
            }
        });




        if (turno == 0) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 1;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 1) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 2;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);

                    }
                    return false;
                }
            });
        }

        if (turno == 2) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 3;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 3) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 4;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 4) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 5;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 5) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 6;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 6) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 7;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 7) {
            b4.setBackgroundResource(R.drawable.ateclad);
            b4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoB4, 1, 1, 0, 0, 1);
                        b4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        b4.setBackgroundResource(R.drawable.teclad);
                        turno = 8;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 8) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 9;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==9) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=10;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==10) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=11;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==11) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=12;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==12) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=13;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 13) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 14;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 14) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 15;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 15) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 16;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 16) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 17;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==17) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=18;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==18) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=19;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==19) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=20;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 20) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 21;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno ==21) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 22;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 22) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 23;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 23) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 24;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 24) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 25;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 25) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 26;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 26) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 27;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 27) {
            b4.setBackgroundResource(R.drawable.ateclad);
            b4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoB4, 1, 1, 0, 0, 1);
                        b4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        b4.setBackgroundResource(R.drawable.teclad);
                        turno = 28;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 28) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 29;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==29) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=30;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==30) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=31;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==31) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=32;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==32) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=33;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 33) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 34;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 34) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 35;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 35) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 36;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 36) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 37;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==37) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=38;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==38) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=39;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==39) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=40;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }



        if (turno==40) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=41;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==41) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=42;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==42) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=43;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==43) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=44;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==44) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=45;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==45) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=46;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==46) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=47;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==47) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=48;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==48) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=49;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==49) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=50;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==50) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=51;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==51) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=52;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==52) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=53;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==53) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=54;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==54) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=55;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==55) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=56;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==56) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=57;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==57) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=58;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==58) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=59;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==59) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=60;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==60) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=61;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==61) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=62;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==62) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=63;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==63) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=64;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==64) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=65;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==65) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=66;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==66) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=67;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==67) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=68;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==68) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=69;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==69) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=70;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==70) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=71;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==71) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=72;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==72) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=73;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==73) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=74;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==74) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=75;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==75) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=76;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==76) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=77;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==77) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=78;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==78) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=79;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==79) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=80;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==80) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=81;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==81) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=82;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==82) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=83;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==83) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=84;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==84) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=85;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==85) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=86;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==86) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=87;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==87) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=88;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==88) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=90;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);

                    }
                    return false;
                }
            });
        }

        if (turno==90) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=91;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==91) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=92;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==92) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=93;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==93) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=94;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==94) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=95;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==95) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=96;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==96) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=97;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==97) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=98;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==98) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=99;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==99) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=100;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==100) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=101;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==101) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=102;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==102) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=103;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==103) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=104;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==104) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=105;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==105) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=106;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==106) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=107;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==107) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=108;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==108) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=109;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==109) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=110;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==110) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=111;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==111) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=112;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==112) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=113;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==113) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=114;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==114) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=115;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 115) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 116;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 116) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno =117;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);

                    }
                    return false;
                }
            });
        }

        if (turno == 117) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 118;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 118) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 119;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 119) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 120;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 120) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 121;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 121) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 122;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 122) {
            b4.setBackgroundResource(R.drawable.ateclad);
            b4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoB4, 1, 1, 0, 0, 1);
                        b4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        b4.setBackgroundResource(R.drawable.teclad);
                        turno = 123;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 123) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 124;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==124) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=125;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==125) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=126;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==126) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=127;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==127) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=128;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 128) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 129;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 129) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 130;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 130) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 131;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 131) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 132;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==132) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=133;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==133) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=134;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==134) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=135;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 135) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 136;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno ==136) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 137;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 137) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 138;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 138) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 139;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 139) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 140;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 140) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 141;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 141) {
            c5.setBackgroundResource(R.drawable.ateclai);
            c5.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC5, 1, 1, 0, 0, 1);
                        c5.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c5.setBackgroundResource(R.drawable.teclai);
                        turno = 142;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 142) {
            b4.setBackgroundResource(R.drawable.ateclad);
            b4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoB4, 1, 1, 0, 0, 1);
                        b4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        b4.setBackgroundResource(R.drawable.teclad);
                        turno = 143;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 143) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 144;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==144) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=145;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==145) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=146;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==146) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=147;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==147) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=148;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 148) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 149;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 149) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 150;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 150) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 151;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno == 151) {
            a4.setBackgroundResource(R.drawable.atecladm);
            a4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoA4, 1, 1, 0, 0, 1);
                        a4.setBackgroundResource(R.drawable.atecladm);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        a4.setBackgroundResource(R.drawable.tecladm);
                        turno = 152;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==152) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=153;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==153) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=154;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==154) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=155;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }



        if (turno==155) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=156;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==156) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=157;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==157) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=158;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==158) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=159;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==159) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=160;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==160) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=161;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==161) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=162;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==162) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=163;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==163) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=164;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==164) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=165;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==165) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=166;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==166) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=167;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==167) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=168;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==168) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=169;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==169) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=170;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==170) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=171;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==171) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=172;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==172) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=173;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==173) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=174;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==174) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=175;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==175) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=176;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==176) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=177;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==177) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=178;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==178) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=179;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==179) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=180;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==180) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=181;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==181) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=182;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==182) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=183;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==183) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=184;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==184) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=185;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==185) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=186;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==186) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=187;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==187) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=188;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==188) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=189;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==189) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=190;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==190) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=191;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==191) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=192;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==192) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=193;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==193) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=194;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==194) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=195;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==195) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=196;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==196) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=197;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==197) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=198;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==198) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=199;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==199) {
            g4.setBackgroundResource(R.drawable.ateclaim);
            g4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoG4, 1, 1, 0, 0, 1);
                        g4.setBackgroundResource(R.drawable.ateclaim);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        g4.setBackgroundResource(R.drawable.teclaim);
                        turno=200;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if(turno==200) {
            f4.setBackgroundResource(R.drawable.ateclai);
            f4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoF4, 1, 1, 0, 0, 1);
                        f4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        f4.setBackgroundResource(R.drawable.teclai);
                        turno=201;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==201) {
            e4.setBackgroundResource(R.drawable.ateclad);
            e4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoE4, 1, 1, 0, 0, 1);
                        e4.setBackgroundResource(R.drawable.ateclad);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        e4.setBackgroundResource(R.drawable.teclad);
                        turno=202;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==202) {
            d4.setBackgroundResource(R.drawable.ateclam);
            d4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoD4, 1, 1, 0, 0, 1);
                        d4.setBackgroundResource(R.drawable.ateclam);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        d4.setBackgroundResource(R.drawable.teclam);
                        turno=203;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

        if (turno==203) {
            c4.setBackgroundResource(R.drawable.ateclai);
            c4.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent m) {
                    if (m.getAction() == MotionEvent.ACTION_DOWN) {
                        sonidos.play(SonidoC4, 1, 1, 0, 0, 1);
                        c4.setBackgroundResource(R.drawable.ateclai);
                    }
                    if (m.getAction() == MotionEvent.ACTION_UP) {
                        c4.setBackgroundResource(R.drawable.teclai);
                        turno=204;
                        declaraciones();
                        puntos++;
                        cont=String.valueOf(puntos);
                        puntaje.setText(cont);
                    }
                    return false;
                }
            });
        }

    }
}
