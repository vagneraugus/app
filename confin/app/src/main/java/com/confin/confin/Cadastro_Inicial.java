package com.confin.confin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
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
    private EditText campo_email, campo_senha;

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
                String email = campo_email.getText().toString().trim();
                String senha = campo_senha.getText().toString().trim();
                criauser(email, senha);
            }
        });
    }

<<<<<<< HEAD
    private void criauser(String email, String senha) {
        auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(Cadastro_Inicial.this, new OnCompleteListener<AuthResult>() {
=======
    private void criarUser(String email, String senha) {
       auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(Cadastro_Inicial.this, new OnCompleteListener<AuthResult>() {
>>>>>>> db5101339b0a4265afd674cfd45de6b6f40276b2
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    alert("Usuário cadastrado!");
                    startActivity(new Intent(Cadastro_Inicial.this, MainActivity.class));
                    finish();
                }else{
                    alert("Erro ao cadastrar usuário!");
                }
            }
        });
    }

<<<<<<< HEAD
    private void alert(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

    private void inicializaComponentes() {
        btn_cadastrar = (Button)findViewById(R.id.id_btn_cadastrar_usuario);
        btn_cancelar = (Button)findViewById(R.id.id_btn_cancelar_cadastro);
        campo_email    = (EditText)findViewById(R.id.id_email_cadastrar);
        campo_senha   = (EditText)findViewById(R.id.id_senha_cadastrar);
=======
    //teste robson
    public static boolean validateNotNull(View pView, String pMessage) {
        if (pView instanceof EditText) {
            EditText edText = (EditText) pView;
            Editable text = edText.getText();
            if (text != null) {
                String strText = text.toString();
                if (!TextUtils.isEmpty(strText)) {
                    return true;
                }
            }
            // em qualquer outra condição é gerado um erro
            edText.setError(pMessage);
            edText.setFocusable(true);
            edText.requestFocus();
            return false;
        }
        return false;
    }
//Fim teste Robson
    
    private void mensagem(String msg){
        Toast.makeText(getApplicationContext(), msg,Toast.LENGTH_LONG).show();
>>>>>>> db5101339b0a4265afd674cfd45de6b6f40276b2
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }

/*    private void botoes() {
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email       = campo_email.getText().toString().trim();
                String senha       = campo_senha.getText().toString().trim();
                criarUser(email, senha);
            }
        });

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void criarUser(String email, String senha) {
        auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(Cadastro_Inicial.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                try {
                    if (task.isComplete()){
                        msg("Sucesso ao cadastrar");
                        startActivity(new Intent(Cadastro_Inicial.this, MainActivity.class));
                        finish();
                    }else{
                        msg("Erro ao cadastrar");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private void msg(String alerta) {
        Toast.makeText(getApplicationContext(),alerta,Toast.LENGTH_LONG).show();
    }

    private void inicializaComponentes() {
        campo_email = (EditText)findViewById(R.id.id_campoEmail_cadastrar);
        campo_senha = (EditText)findViewById(R.id.id_campoSenha_cadastrar);
        btn_cadastrar = (Button)findViewById(R.id.id_btnCadastrar_usuario);
        btn_cancelar = (Button)findViewById(R.id.id_btnCancelar_cadastro);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }*/
}
