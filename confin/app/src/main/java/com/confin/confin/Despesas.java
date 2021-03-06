package com.confin.confin;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

public class Despesas extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private Button btnSalvarDespesas;
    private Button btnLimparDespesas;
    private Button btnCancelarDespesas;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        btnSalvarDespesas = (Button)findViewById(R.id.btnSavarDespesas);
        btnCancelarDespesas = (Button)findViewById(R.id.btnCancelarDespesas);
        btnLimparDespesas = (Button)findViewById(R.id.btnLimparDespesas);

    }

    public void btnSalvarDespesas(View view) {
        Snackbar.make(view, "A despesa foi cadastrada!", Snackbar.LENGTH_LONG).setAction("Action",null).show();
    }

    public void btnCancelarDespesas(View view) {
        Snackbar.make(view, "Despesa cancelada!", Snackbar.LENGTH_LONG).setAction("Action",null).show();
    }

    public void btnLimparDespesas(View view) {
        Snackbar.make(view, "Campos limpos!", Snackbar.LENGTH_LONG).setAction("Action",null).show();
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0:
                    fragment = new  despesas_buscar_fragment();
                    break;
                case 1:
                    fragment = new despesas_cadastrar_fragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            // Exibe o total de paginas fragmentos
            return 2;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_despesas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
       /* if (id == R.id.menu_novo){
            Pessoa p = new Pessoa();
            p.setId(UUID.randomUUID().toString());
            p.setNome(campoNome.getText().toString());
            p.setEmail(campoEmail.getText().toString());
            databaseReference.child("Pessoa").child(p.getId()).setValue(p);
            limparCampos();
        }else if (id == R.id.menu_atualizar){
            Pessoa p = new Pessoa();
            p.setId(pessoaSelecionada.getId());
            p.setNome(campoNome.getText().toString().trim());
            p.setEmail(campoEmail.getText().toString().trim());
            databaseReference.child("Pessoa").child(p.getId()).setValue(p);
            limparCampos();
        }else if (id == R.id.menu_deletar){
            Pessoa p = new Pessoa();
            p.setId(pessoaSelecionada.getId());
            databaseReference.child("Pessoa").child(p.getId()).removeValue();
            limparCampos();
        }*/

        return  true;
    }

}
