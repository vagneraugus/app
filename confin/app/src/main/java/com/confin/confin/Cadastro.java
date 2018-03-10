package com.confin.confin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final TextView text = findViewById(R.id.txtEsqueceuSenha);
        text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Cadastro.this, EsqueceuSenha.class));
            }
        });

        final Button button = findViewById(R.id.btnCadastrar);
        button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(Cadastro.this, LoginActivity.class));
                }
        });
    }
}
