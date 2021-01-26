package com.jmdevs.petagram;

import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mascotaAdapter extends RecyclerView.Adapter<mascotaAdapter.mascotaViewHolder> {

    ArrayList<mascota> mascotas;
    boolean clicked = false;
    private Context context;

    public mascotaAdapter(ArrayList<mascota> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    //inflar el layout y paras al viewholder para que obtenga los views
    public mascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascotas, parent, false);
        return new mascotaViewHolder(v);
    }

    @Override
    //asocia c/elem de la lista con c/view
    public void onBindViewHolder(@NonNull mascotaViewHolder holder, int position) {
        mascota mascot = mascotas.get(position);
        holder.nameTxt.setText(String.valueOf(mascot.getNombre()));
        holder.rateTxt.setText(String.valueOf(mascot.getRate().toString()));
        holder.dogPic.setImageResource(mascot.getPic());

        holder.boneRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascot.incRate();
                clicked = true;
                holder.rateTxt.setText(String.valueOf(mascot.getRate().toString()));

            }
        });
    }

    @Override
    //cant de elems que tiene mi lista de mascotas
    public int getItemCount() {
        return mascotas.size();
    }

    public static class mascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView dogPic;
        private TextView nameTxt;
        private TextView rateTxt;
        private ImageButton boneRate;

            public mascotaViewHolder(@NonNull View itemView) {
            super(itemView);
                dogPic      = (ImageView) itemView.findViewById(R.id.img_mascota);
                nameTxt     = (TextView) itemView.findViewById(R.id.dogName);
                rateTxt     = (TextView) itemView.findViewById(R.id.dogRate);
                boneRate    = (ImageButton) itemView.findViewById(R.id.wBone);
        }
    }



}
