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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AlertDialog.Builder opcaoCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //---------------------------- MENU DE CADASTROS ALERT_DIALOG ------------------------------
            final CharSequence[] opcoesCadastro = { "CATEGORIAS", "CONDIÇÃO DE PGTO", "DESPESAS", "RECEITAS", "SUBCATEGORIAS" };

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
                        }
                    }
            });
        //------------------------------------------------------------------------------------------

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
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
    //----------------------------------- FIM MENU LATERAL FLUTUANTE DE ADD ------------------------
}
