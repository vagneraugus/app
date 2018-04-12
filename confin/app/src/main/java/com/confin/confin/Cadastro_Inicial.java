package com.confin.confin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro_Inicial extends AppCompatActivity {

    private FirebaseAuth auth;
    private Button btn_cadastrar, btn_cancelar;
    private TextInputEditText campo_email, campo_senha, campo_confirma_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__inicial);

        inicializaComponentes();
        botoes();
    }

    private void botoes() {
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(campo_email.getText().length()==0) {
                    Toast.makeText(getApplication(), "Campo de e-mail não preenchido, verifique!", Toast.LENGTH_LONG).show();

                }else if((campo_confirma_senha.getText().length()==0) || (campo_senha.getText().length()==0)) {
                    Toast.makeText(getApplication(), "Campo de e-mail ou senha não preenchido, verifique!", Toast.LENGTH_LONG).show();

                }else if (campo_senha.getText().toString() != campo_confirma_senha.getText().toString()) {
                    Toast.makeText(getApplication(), "Senhas não xconferem, verifique!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplication(), "Foi cadastrado um usuário com o e-mail" + campo_email.getText(), Toast.LENGTH_LONG).show();
                    String email = campo_email.getText().toString().trim();
                    String senha = campo_senha.getText().toString().trim();
                    criauser(email, senha);
                }
            }
        });
    }

    private void criauser(String email, String senha) {
        auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(Cadastro_Inicial.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    alert("Conta criada com sucesso, seja Bem-vindo!" + campo_email.getText().toString());
                    startActivity(new Intent(Cadastro_Inicial.this, MainActivity.class));
                    finish();
                }else{
                    alert("Erro ao cadastrar usuário!");
                }
            }
        });
    }

    private void alert(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

    private void inicializaComponentes() {
        btn_cadastrar        = (Button)findViewById(R.id.id_btn_cadastrar_usuario);
        btn_cancelar         = (Button)findViewById(R.id.id_btn_cancelar_cadastro);
        campo_email          = (TextInputEditText)findViewById(R.id.id_email_cadastrar);
        campo_senha          = (TextInputEditText)findViewById(R.id.id_senha_cadastrar);
        campo_confirma_senha = (TextInputEditText)findViewById(R.id.id_senha_confirma);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }
}
