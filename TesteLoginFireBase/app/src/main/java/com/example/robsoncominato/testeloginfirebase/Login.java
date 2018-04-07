package com.example.robsoncominato.testeloginfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private Button btnLogar, btnNovo;
    private EditText editEmail, editSenha;
    private TextView txtResetSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eventoClicks();
        incializaComponentes();
    }

    private void eventoClicks() {
        btnNovo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Cadastro.class);
                startActivity(i);
            }
        });
    }

    private void incializaComponentes() {
        editEmail = (EditText) findViewById(R.id.edtLoginEmail);
        editSenha = (EditText) findViewById(R.id.edtLoginSenha);
        btnLogar = (Button) findViewById(R.id.btnLoginLogar);
        btnNovo = (Button) findViewById(R.id.btnLoginNovo);
        txtResetSenha = (TextView) findViewById(R.id.txtResetSenha);
    }


}
