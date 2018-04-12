package com.confin.confin;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetSenha extends AppCompatActivity {

    private TextInputEditText campo_email;
    private Button btn_reset_senha;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_senha);

        inicialaizaComponentes();
        botoes();

    }


    private void botoes(){
        btn_reset_senha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = campo_email.getText().toString().trim();
                reset_email(email);
            }
        });
    }

    private void reset_email(String email){
        auth.sendPasswordResetEmail(email).addOnCompleteListener(ResetSenha.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
//                    Snackbar.make(view, "Um e-mail foi enviado para alterar sua senha, verifique sua caixa de e-mail!", Snackbar.LENGTH_LONG).setAction("ACtion",null).show();
                    atencao("Um e-mail foi enviado para alterar sua senha, verifique sua caixa de e-mail!");
                    finish();
                    startActivity( new Intent(ResetSenha.this, Login.class));
                }else{
                    atencao("Erro ao solicitar recuperação de senha, tente novamente");
                    finish();
                }
            }
        });
    }

    private void atencao(String mensagem) {
        Toast.makeText(ResetSenha.this, mensagem,Toast.LENGTH_LONG).show();
    }
    private void inicialaizaComponentes() {
        btn_reset_senha = (Button)findViewById(R.id.id_btn_reset_senha);
        campo_email = (TextInputEditText)findViewById(R.id.id_email_reset);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }
}
