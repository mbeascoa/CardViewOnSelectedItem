package com.example.cardviewonselecteditem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private List<Peliculas> listaPeliculas;

    public Adaptador(List<Peliculas> ListaPelicula) {
        this.listaPeliculas = ListaPelicula;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_datos, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String tit = listaPeliculas.get(position).getTitulo();
        holder.txtname.setText(tit);
        String distri = listaPeliculas.get(position).getDistribuidor();

        int peli = listaPeliculas.get(position).getFoto();
        holder.fotoPeli.setImageResource(peli);
        holder.card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(holder.txtname.getText().toString());

            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtname;
        private ImageView fotoPeli;
        private CardView card1;
        public ViewHolder(View v) {
            super(v);
            txtname = (TextView) v.findViewById(R.id.txtTitulo);
            fotoPeli= (ImageView) v.findViewById(R.id.img_FotoPeli);
            card1= (CardView) v.findViewById(R.id.cv_Pelicula);

        }
    }

}