package com.jmdevs.petagram.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmdevs.petagram.R;
import com.jmdevs.petagram.adapter.mascotaAdapter;
import com.jmdevs.petagram.pojo.mascota;

import java.util.ArrayList;


public class pet_feed extends Fragment {

    private RecyclerView listaMascotas;
    private ArrayList<mascota> mascotas;


    public pet_feed() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_pet_feed, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rv_mascota);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        /*GridLayoutManager glm = new GridLayoutManager(this, 1);*/

        listaMascotas.setLayoutManager(llm);
        initListaMascotas();
        initAdapter();

        return v;
    }

    public void initAdapter(){
        mascotaAdapter mAdapt = new mascotaAdapter(mascotas, getActivity());
        listaMascotas.setAdapter(mAdapt);
    }

    public void initListaMascotas(){
        mascotas = new ArrayList<mascota>();
        mascotas.add(new mascota("Rocky","Rocky", 0, R.drawable.bull_terrier));
        mascotas.add(new mascota("Bobby","Bobby", 0, R.drawable.pitbull_cachorro));
        mascotas.add(new mascota("Rudolph","Rudolph", 0, R.drawable.doberman_cachorro));
        mascotas.add(new mascota("Scott","Scott", 0, R.drawable.rottweiler_cachorro));
        mascotas.add(new mascota("Lucky","Lucky", 0, R.drawable.golden_retriever));

    }
}