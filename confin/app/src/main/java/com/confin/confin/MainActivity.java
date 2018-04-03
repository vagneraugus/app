package com.confin.confin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth auth;
    private FirebaseUser user;

    private AlertDialog.Builder opcaoCadastrar;

    private TextView cod_usuario, nome_usuario, email_usuario;
    private Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* //Botao chamar tela Cadastro inical
        final Button button = findViewById(R.id.btnTelaCadastro);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Cadastro_Inicial.class));
            }
        });
        //fim do botão*/

        //--------------------------------- LINKS MENU LATERAL ------------------------------------
            //Botao chamar tela Cadastro inical
            final ImageButton imgbCartaoCedito = findViewById(R.id.ibCartaoCredito);
            imgbCartaoCedito.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, Condicao_pgto.class));
                }
            });
            //fim do botão

            //Botao chamar tela Cadastro inical
            final ImageButton imgbCadastrar = findViewById(R.id.ibCadastrar);
            imgbCadastrar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, Cadastro_Inicial.class));
                }
            });
            //fim do botão

            //Botao chamar tela Cadastro inical
            final ImageButton imgbApelidoCartao = findViewById(R.id.imgbApelidoCartao);
            imgbApelidoCartao.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, Cadastro_cartao.class));
                }
            });
            //fim do botão

            //Tela despesa
            final ImageButton imgbDespesa = findViewById(R.id.imgbDespesa);
            imgbDespesa.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, Despesas.class));
                }
            });

            //Tela despesa
            final ImageButton imgbReceita = findViewById(R.id.imgbReceita);
            imgbReceita.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, Receitas.class));
                }
            });

            //Tela categoria
            final ImageButton imgbCategoria = findViewById(R.id.imgbCategoria);
            imgbCategoria.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, Categorias.class));
                }
            });

            //Tela subcategoria
            final ImageButton imgbSubCategoria = findViewById(R.id.imgbSubCategoria);
            imgbSubCategoria.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, SubCategoria.class));
                }
            });

            //Tela despesa
            final ImageButton imgbResumo = findViewById(R.id.imgbResumo);
            imgbResumo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, Resumo.class));
                }
            });

            //Tela vencto cartao
            final ImageButton imgbResumoVenctoCartao = findViewById(R.id.imgbResumoVenctoCartao);
            imgbResumoVenctoCartao.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, Resumo_data_vencto_cartao.class));
                }
            });

        //---------------------------- MENU DE CADASTROS ALERT_DIALOG ------------------------------
            final CharSequence[] opcoesCadastro =
                    { "CATEGORIAS", "CONDIÇÃO DE PGTO", "DESPESAS", "RECEITAS", "SUBCATEGORIAS", "HOME", "PARCELA"  };

            opcaoCadastrar = new AlertDialog.Builder(MainActivity.this);
            opcaoCadastrar.setTitle("O que você deseja cadastrar?");
            opcaoCadastrar.setNegativeButton("Cancelar", null);
            opcaoCadastrar.setCancelable(false);
            opcaoCadastrar.setItems(opcoesCadastro, new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int selecionado)
                {
                    switch (selecionado)
                    {
                        case 0:
                            startActivity(new Intent(MainActivity.this, Categorias.class));
                            break;
                        case 1:
                            // startActivity(new Intent(MainActivity.this, CondPgto.class));
                            Toast.makeText(getApplicationContext(),"Condição de PGTO selecionado", Toast.LENGTH_LONG).show();
                            break;
                        case 2:
                            startActivity(new Intent(MainActivity.this, Despesas.class));
                            break;
                        case 3:
                            startActivity(new Intent(MainActivity.this, Receitas.class));
                            break;
                        case 4:
                            // startActivity(new Intent(MainActivity.this, Categorias.class));
                            Toast.makeText(getApplicationContext(),"Condição de PGTO selecionado", Toast.LENGTH_LONG).show();
                            break;
                        case 5:
                            startActivity(new Intent(MainActivity.this, Cadastro_Inicial.class));
                            break;
                        case 6:
                            startActivity(new Intent(MainActivity.this, Condicao_pgto.class));
                            break;
                    }
                }
            });

        //------------------------------------- TOOLBAR --------------------------------------------
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

        //-----------------------------------BOTAO FLUTUANTE DE ADD --------------------------------
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                opcaoCadastrar.create().show();
            }
        });

        //----------------------------------- FIM BOTAO FLUTUANTE DE ADD ---------------------------

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

        //-------------------------------- ID, NOME, EMAIL do usuaril logado -----------------------
            cod_usuario = (TextView)findViewById(R.id.id_usuario);
            nome_usuario = (TextView)findViewById(R.id.id_nome_usuario);
            email_usuario = (TextView)findViewById(R.id.id_email_usuario);

        //--------------------------------------- BOTAO DE LOGOUT ----------------------------------
            btn_logout = (Button)findViewById(R.id.id_btn_logout);
            btn_logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Conexao.logOut();
                    finish();
                }
            });
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
        user = Conexao.getFirebaseUser();

        verificaUser();
    }

    public void verificaUser(){
        if (user == null){
            finish();
        }else{
            cod_usuario.setText("Código: " + user.getUid());
            email_usuario.setText("Email: " + user.getEmail());
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //---------------------------------- MENU LATERAL FLUTUANTE DE ADD -----------------------------
        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item)
        {
            int id = item.getItemId();

            if (id == R.id.nav_cadastrar) {
                opcaoCadastrar.create().show();
            } else if (id == R.id.nav_despesas) {
                startActivity(new Intent(MainActivity.this, Despesas.class));
            } else if (id == R.id.nav_receitas) {
                startActivity(new Intent (MainActivity.this, Receitas.class));
            } else if (id == R.id.nav_resumo) {

            } else if (id == R.id.nav_compartilhar) {

            } else if (id == R.id.nav_enviar) {
                startActivity( new Intent(MainActivity.this, Login.class));
            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    //----------------------------------- FIM MENU LATERAL FLUTUANTE DE ADD ------------------------
    public void dd(MenuItem item) {
        Toast.makeText(getApplicationContext(),"testes dfksdjflj",Toast.LENGTH_LONG).show();
    }
}
