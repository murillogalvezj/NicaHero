package com.example.enrique.nicaherolayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;

/**
 * Created by enrique on 26/08/2017.
 */


public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(FragmentIntro1.newInstance("titulo", "descripcion"));
        addSlide(FragmentIntro2.newInstance("titulo", "descripcion"));
        addSlide(FragmentIntro3.newInstance("titulo", "descripcion"));
        addSlide(FragmentIntro4.newInstance("titulo", "descripcion"));


        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));

        // SHOW or HIDE the statusbar
        showStatusBar(true);

        // Edit the color of the nav bar on Lollipop+ devices
        //setNavBarColor(Color.parseColor("#F3F0EA"));

        // Hide Skip/Done button
        showSkipButton(true);
        showDoneButton(true);

        // Turn vibration on and set intensity
        // NOTE: you will probably need to ask VIBRATE permisssion in Manifest



        // Animations -- use only one of the below. Using both could cause errors.
        setFadeAnimation(); // OR
        setZoomAnimation(); // OR
        setFlowAnimation(); // OR
        setSlideOverAnimation(); // OR
        setDepthAnimation(); // OR
        //setCustomTransformer(yourCustomTransformer);

        // Permissions -- takes a permission and slide number
       // askForPermissions(new String[]{Manifest.permission.CAMERA}, 3);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        // Do something when users tap on Skip button.
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }



    @Override
    public void onDonePressed(Fragment currentFragment) {
        // Do something when users tap on Done button.
        finish();
    }




}


