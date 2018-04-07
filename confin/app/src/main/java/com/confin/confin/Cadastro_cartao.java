package com.confin.confin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Cadastro_cartao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cartao);
    }

    /**
     * Created by RobsonCominato on 03/04/2018.
     */

    public static class Conexao {

        private static FirebaseAuth firebaseAuth;
        private static FirebaseAuth.AuthStateListener authStateListener;
        private static FirebaseUser firebaseUser;

        private Conexao() {

        }

        public static FirebaseAuth getFirebaseAuth() {
            if (firebaseAuth == null){
                inicializarFirebaseAuth();
            }
            return firebaseAuth;
        }

        private  static void inicializarFirebaseAuth(){
            firebaseAuth = FirebaseAuth.getInstance();
            authStateListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if (user != null) {
                        firebaseUser = user;
                    }
                }
            };
            firebaseAuth.addAuthStateListener(authStateListener);
        }

        public static FirebaseUser getFirebaseUser(){
            return firebaseUser;
        }

        public static void logOut(){
            firebaseAuth.signOut();
        }

    }
}
