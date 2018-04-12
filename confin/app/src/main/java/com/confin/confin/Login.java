package com.confin.confin;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

    private TextView btn_cadastrar_se, btn_manterLogado,btn_esqueceu_senha, btn_cancelar_login, bnt_entrar;
    private Button btn_Loagar;
    private EditText campo_email, campo_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializaComponentes();
        botoes();
    }

    private void inicializaComponentes() {
        btn_manterLogado   = (TextView)findViewById(R.id.id_btn_manter_logado);
        btn_cadastrar_se   = (TextView)findViewById(R.id.id_btn_cadastrar_se);
        btn_esqueceu_senha = (TextView)findViewById(R.id.id_btn_esqueceu_senha);
        bnt_entrar         = (Button)findViewById(R.id.id_btn_fazer_login);
        btn_cancelar_login = (Button)findViewById(R.id.id_btn_cancelar_login);
    }

    private void botoes() {
        bnt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Não é possível fazer login ainda!", Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });
        btn_cancelar_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_cadastrar_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Login.this, Cadastro_Inicial.class));
            }
        });
        btn_esqueceu_senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cara, como você pode esquecer a senha!", Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });
        btn_manterLogado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity( new Intent(Login.this, MainActivity.class));
                Snackbar.make(view, "Cara, como você pode esquecer a senha!", Snackbar.LENGTH_LONG).setAction("Action",null).show();

            }
        });

    }


    public void cadastrar_se(View view) {
        startActivity(new Intent(Login.this, Cadastro_Inicial.class));
    }

}
