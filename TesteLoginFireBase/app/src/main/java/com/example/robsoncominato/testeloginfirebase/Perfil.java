package com.example.robsoncominato.testeloginfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Perfil extends AppCompatActivity {

    private TextView textEmail, textID;
    private Button btnLogout;

    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        inicializaComponentes();
    }

        private void eventoClicks() {
            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Conexao.logOut();
                    finish();
                }
            });
    }

    private void inicializaComponentes() {
        textEmail = (TextView) findViewById(R.id.textPerfilID);
        textID = (TextView) findViewById(R.id.textPerfilID);
        btnLogout = (Button) findViewById(R.id.btnPerfilLogout);

    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
        user = Conexao.getFirebaseUser();
        verificaUser();
    }

    private void verificaUser() {
        if (user == null){
            finish();
        }else{
            textEmail.setText("Email :"+user.getEmail());
            textID.setText("ID "+user.getUid());
        }
    }
}
