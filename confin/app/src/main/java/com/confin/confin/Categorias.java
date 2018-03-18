package com.confin.confin;

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

public class Categorias extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private Button btnSalvarCategorias;
    private Button btnLimparCategorias;
    private Button btnCancelarCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnSalvarCategorias   = (Button)findViewById(R.id.btnSavarCategorias);
        btnCancelarCategorias = (Button)findViewById(R.id.btnCancelarCategorias);
        btnLimparCategorias   = (Button)findViewById(R.id.btnLimparCategorias);

    }

    public void btnSalvarCategorias(View view) {
        Snackbar.make(view, "A categoria foi cadastrada!", Snackbar.LENGTH_LONG).setAction("Action",null).show();
    }

    public void btnCancelarCategorias(View view) {
        Snackbar.make(view, "Categoria cancelada!", Snackbar.LENGTH_LONG).setAction("Action",null).show();
    }

    public void btnLimparCategorias(View view) {

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
                    fragment = new categorias_buscar_fragment();
                    break;
                case 1:
                    fragment = new categorias_cadastrar_fragment();
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
}