package com.example.enrique.nicaherolayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;
import static com.example.enrique.nicaherolayout.R.id.btn_artista;


public class FragmentIntro4 extends Fragment{
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    private static final int SIGN_IN_CODE = 200;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    public FragmentIntro4() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentIntro4.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentIntro4 newInstance(String param1, String param2) {
        FragmentIntro4 fragment = new FragmentIntro4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    public void onCreate(final  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // Button btnLogin = itemView.findViewById(R.id.botonSesion);
        //btnLogin.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {
               // startActivityForResult(
                     //   AuthUI.getInstance()
                          //      .createSignInIntentBuilder()
                          //      .setAvailableProviders(
                                    //    Arrays.asList(
                                  //              new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                                //.build(),
                      //  SIGN_IN_CODE);
           // }
        //});

       // firebaseAuth = FirebaseAuth.getInstance();
       // authStateListener = new FirebaseAuth.AuthStateListener() {
           // @Override
           // public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
              //  if (firebaseAuth.getCurrentUser() !=null){
               //     iniciarMainActivity(itemView);
               // }
           // }
       // };
    }


    //private void iniciarMainActivity(View view) {
       // Intent i = new Intent(view.getContext(),MainActivity.class);
       // i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
       // view.getContext().startActivity(i);
    //}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro4, container, false);
    }

    //@Override
    //public void onStart() {
    //    super.onStart();
     //   firebaseAuth.addAuthStateListener(authStateListener);
    //}

    //@Override
   // public void onStop() {
    //    super.onStop();
    //    if(authStateListener!=null)
    //        firebaseAuth.removeAuthStateListener(authStateListener);
   // }
}
