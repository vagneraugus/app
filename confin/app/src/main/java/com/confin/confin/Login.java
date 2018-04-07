package com.confin.confin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Login extends Activity {

    private TextView btn_Cadastrar_se, btn_manterLogado;
    private Button btn_Loagar;
    private EditText campo_email, campo_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_Cadastrar_se = (TextView)findViewById(R.id.id_btnCadastrar_se);
    }


    public void cadastrar_se(View view) {
        startActivity(new Intent(Login.this, Cadastro_Inicial.class));
    }

}
