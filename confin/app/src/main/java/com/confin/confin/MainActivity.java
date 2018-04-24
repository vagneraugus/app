package com.confin.confin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private AlertDialog.Builder opcaoCadastrar;
    private TextView cod_usuario, email_usuario, recebe_email_usuario;
    private Button btn_logout, btn_nome_usuario;

    private ListView lista;
    private ArrayAdapter adaptador_home_lista;
    private ArrayList<Home_lista> adiciona_img_a_lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------------------------------------------- MENU DE CADASTROS ALERT_DIALOG -----------------------------------------------------------------
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
            cod_usuario = (TextView)findViewById(R.id.id_cod_usuario);
            email_usuario = (TextView)findViewById(R.id.id_email_usuario);
            recebe_email_usuario = (TextView)findViewById(R.id.id_recebe_email_usuario);

        //------------------------------------------------- CRIA A LISTA NA TELA HOME -------------------------------------
            lista =(ListView)findViewById(R.id.id_listview_home);
    //        adaptador = ArrayAdapter.createFromResource(this, R.array.lista_com_frutas, android.R.layout.simple_list_item_1);
            adiciona_img_a_lista = adicionaImagem();
            adaptador_home_lista = new Home_lista_adapter(this, adiciona_img_a_lista);
            lista.setAdapter(adaptador_home_lista);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            startActivity(new Intent(MainActivity.this, Categorias.class));
                            break;
                        case 1:
                            startActivity(new Intent(MainActivity.this, Despesas.class));
                            break;
                        case 2:
    //                        startActivity(new Intent(MainActivity.this, Condicao_pgto.class));
                            Toast.makeText(getApplicationContext(),"Forma de PGTO selecionado", Toast.LENGTH_LONG).show();
                            break;
                        case 3:
                            startActivity(new Intent(MainActivity.this, Receitas.class));
                            break;
                        case 4:
                            // startActivity(new Intent(MainActivity.this, Sub_categorias.class));
                            Toast.makeText(getApplicationContext(),"Subcategorias selecionado", Toast.LENGTH_LONG).show();
                            break;
                    }
                }
            });
    }/*¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬ AQUI TERMINA O MAIN  ¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬ */

    //--------------------------------------------------------- METODO LISTA DE IMAGENS NO LISTVIEWL HOME FORA DO MAIN ----------------------------------------
        private ArrayList<Home_lista> adicionaImagem(){
            ArrayList<Home_lista> linha = new ArrayList<Home_lista>();

            Home_lista L = new Home_lista("CATEGORIAS",  R.drawable.img_categoria);
            linha.add(L);

            L = new Home_lista("DESPESAS",  R.drawable.img_despesas);
            linha.add(L);

            L = new Home_lista("FORMAS DE PAGAMENTOS",  R.drawable.img_forma_pgto);
            linha.add(L);

            L = new Home_lista("RECEITAS",  R.drawable.img_receitas);
            linha.add(L);

            L = new Home_lista("SUBCATEGORIAS",  R.drawable.img_subcategorias);
            linha.add(L);

            //---------------------------- DAQUI PRA BAIXO FOI SÓ PRA POPULAR A LISTVIEW----------------------------------------------------------------
            L = new Home_lista("DESPESAS",  R.drawable.img_despesas);
            linha.add(L);

            L = new Home_lista("FORMAS DE PAGAMENTOS",  R.drawable.img_forma_pgto);
            linha.add(L);

            L = new Home_lista("RECEITAS",  R.drawable.img_receitas);
            linha.add(L);

            L = new Home_lista("SUBCATEGORIAS",  R.drawable.img_subcategorias);
            linha.add(L);

            return linha;
        }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------
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
            cod_usuario.setText("Código: " + user.getUid());
            email_usuario.setText("E-mail: " + user.getEmail());
//            Toast.makeText(MainActivity.this,"Bem-vindo " + user.getEmail(), Toast.LENGTH_LONG).show();

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
    //----------------------------------------------------------------------------------------------
    public void sair(MenuItem item) {
        Conexao.logOut();
        finish();
    }
}
