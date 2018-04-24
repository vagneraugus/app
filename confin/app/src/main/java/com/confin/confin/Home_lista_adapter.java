package com.confin.confin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.confin.confin.R.layout.home_lista_layout;

public class Home_lista_adapter extends ArrayAdapter<Home_lista> {

    private final Context context;
    private final ArrayList<Home_lista> elementos;

    public Home_lista_adapter(Context context, ArrayList<Home_lista> elementos){
        super(context, R.layout.home_lista_layout, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.home_lista_layout, parent, false);

        TextView nomeImagem =(TextView) rowView.findViewById(R.id.id_nome_imagem);
        ImageView imagemLista = (ImageView) rowView.findViewById(R.id.id_imagem_lista_home);

        nomeImagem.setText(elementos.get(position).getNome());
        imagemLista.setImageResource(elementos.get(position).getImagem());

        return rowView;
    }
}
