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
    private EditText campo_nome, campo_email, campo_senha, campo_perSecreta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__inicial);

        btn_cadastrar     = (Button)findViewById(R.id.id_btnCadastrar);
        btn_cancelar      = (Button)findViewById(R.id.id_btnCancelar);
        campo_nome        = (EditText)findViewById(R.id.id_campoNome);
        campo_email       = (EditText)findViewById(R.id.id_campoEmail);
        campo_senha       = (EditText)findViewById(R.id.id_campoSenha);
        campo_perSecreta  = (EditText)findViewById(R.id.id_campoPergSecreta);

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
//                String nome        = campo_nome.getText().toString().trim();
                String email       = campo_email.getText().toString().trim();
                String senha       = campo_senha.getText().toString().trim();
//                String pergSecreta = campo_perSecreta.getText().toString().trim();

                criarUser(email, senha);
            }
        });
    }

    private void criarUser(String email, String senha) {
       auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(Cadastro_Inicial.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    mensagem("Novo usuário cadastrado!");
                    startActivity(new Intent(Cadastro_Inicial.this, MainActivity.class));
                    finish();
                }else{
                    mensagem("Erro ao cadastrar usuário!");
                }
            }
        });
    }

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
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }
}
