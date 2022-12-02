package com.example.newexamenandeamargaritaguelescobar.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newexamenandeamargaritaguelescobar.Modelos.itemsresultados;
import com.example.newexamenandeamargaritaguelescobar.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    public List<itemsresultados> elemts;
    private Context context;

    public Adaptador(Context context){
        this.context= context;
        elemts = new ArrayList<>();
    }

    public Adaptador(List<itemsresultados> results) {
        this.elemts = results;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsresultados,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        holder.setData(elemts.get(position));
        itemsresultados p = elemts.get(position);

        Picasso.get().load( "https://fer-uig.glitch.me/"+p.getNombre() +".png")
                .into(holder.imagen);
    }
    @Override
    public int getItemCount() {
        return elemts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre;
        public TextView numero;
        public ImageView imagen;

        ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txt1);
            numero = itemView.findViewById(R.id.txt2);
            imagen = itemView.findViewById(R.id.imageView);

        }
        public void setData(itemsresultados item) {
            nombre.setText(item.getNombre());
            numero.setText(item.getNumero());
        }
    }

    }
