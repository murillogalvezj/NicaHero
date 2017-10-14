package com.example.enrique.nicaherolayout;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.common.api.GoogleApi;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class ajustes_activity extends AppCompatActivity {

    private static final int SIGN_IN_CODE = 200;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajustes_activity);


        final ImageButton btnLogin = findViewById(R.id.iniciar_sesion_google);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firebaseAuth.getCurrentUser() ==null){
                    startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(
                                        Arrays.asList(
                                                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                                .build(),
                        SIGN_IN_CODE);
            }
                if (firebaseAuth.getCurrentUser() !=null){
                    signOut();
                    Toast.makeText(getApplicationContext(),"Has cerrado sesion exitosamente", Toast.LENGTH_SHORT).show();
                    btnLogin.setBackgroundResource(R.drawable.inicia_google);
                    iniciarMainActivity();
                }

            }
        });

        final ImageButton btnLoginFace = findViewById(R.id.iniciar_sesion_facebook);
        btnLoginFace.setEnabled(false);
        btnLoginFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(
                                        Arrays.asList(
                                                new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build()))
                                .build(),
                        SIGN_IN_CODE);
            }
        });
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() !=null){
                    btnLogin.setBackgroundResource(R.drawable.logout_google);
                    btnLoginFace.setEnabled(false);
                }
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_CODE){
            if (resultCode == RESULT_OK){
                Log.d("LOGIN","EXITO");
                iniciarMainActivity();
            }else{
                if (resultCode == 0)
                    Toast.makeText(getApplicationContext(),"ERROR de conexion", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void signOut() {
       firebaseAuth.signOut();
    }

    private void iniciarMainActivity() {
        Intent i = new Intent(this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(authStateListener!=null)
            firebaseAuth.removeAuthStateListener(authStateListener);
    }
}
