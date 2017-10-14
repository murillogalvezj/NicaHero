package com.example.enrique.nicaherolayout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;

import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
         FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
         Fragment someFragment = new Fragment();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        String nombre = null;
        String correo = null;
        Uri foto = null;
        String foto1 = null;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //TextView nav_user = (TextView)hView.findViewById(R.id.nav_name);
        //nav_user.setText(user);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView =  navigationView.getHeaderView(0);
        ImageView imagenPerfil =  (ImageView) hView.findViewById(R.id.imagenPerfil);
        TextView nombrePerfil = (TextView) hView.findViewById(R.id.nombrePerfil);
        TextView correoPerfil = (TextView) hView.findViewById(R.id.correoPerfil);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.nav_inicio);

        //  Declare a new thread to do a preference check
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

                //  If the activity has never started before...
                if (isFirstStart) {

                    //  Launch app intro
                    final Intent i = new Intent(MainActivity.this, IntroActivity.class);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(i);
                        }
                    });

                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();

                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("firstStart", false);

                    //  Apply changes
                    e.apply();
                }
            }
        });

        // Start the thread
        t.start();

        if (user != null) {
            nombre = user.getDisplayName();
            nombrePerfil.setText(nombre);
            correo = user.getEmail();
            correoPerfil.setText(correo);
            foto = user.getPhotoUrl();
            //imagenPerfil.setImageURI(foto);
            Glide.with(this)
                    .load(foto)
                    .override(600, 600)
                    .into(imagenPerfil);
        }
        else
        {
                nombrePerfil.setText("Nombre Usuario");
                correoPerfil.setText("Correo Usuario");
                //imagenPerfil.setImageURI(foto);
        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                abrirAjustes();
                //fragment = new ajustes_fragment();
                //replaceFragment(fragment);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    public void abrirAjustes(){
        Intent in= new Intent(MainActivity.this,ajustes_activity.class);
        startActivity(in);
    }

    private void displaySelectedScreen(int id) {
        Fragment fragment = null;

            switch (id) {
                case R.id.nav_inicio:
                    fragment = new musica_fragment();
                    break;

                case R.id.nav_eventos:
                    fragment = new EventoFragment();
                    break;

                case R.id.nav_artistas:
                    fragment = new ArtistaFragment();
                    break;

                case R.id.nav_aporta:
                    fragment = new aporta_fragment();
                    break;

                case R.id.nav_acerca_de:
                    fragment = new acerca_de_fragment();
                    break;
            }



        if (fragment != null){
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        displaySelectedScreen(id);


        return true;
    }
}
