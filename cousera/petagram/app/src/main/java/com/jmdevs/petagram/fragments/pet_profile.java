package com.jmdevs.petagram.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmdevs.petagram.R;
import com.jmdevs.petagram.adapter.mascotaBioAdapter;
import com.jmdevs.petagram.pojo.mascota;
import com.jmdevs.petagram.pojo.post;

import java.util.ArrayList;

public class pet_profile extends Fragment {

    private RecyclerView listaPosts;
    private ArrayList<mascota> mascotas;
    private ArrayList<post> posts;
    private ImageView circProfPic;
    private TextView petName;

    public pet_profile() {
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
        View v = inflater.inflate(R.layout.fragment_pet_profile, container, false);

        listaPosts = (RecyclerView) v.findViewById(R.id.rv_bio_mascota);
        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        glm.setOrientation(GridLayoutManager.VERTICAL);

        listaPosts.setLayoutManager(glm);

        initListaBioMascotas();
        initBioAdapter(v);

        return v;
    }

    public void initBioAdapter(View v){
        mascota m1 = mascotas.get(0);
        petName = (TextView) v.findViewById(R.id.pet_name);
        circProfPic = (ImageView) v.findViewById(R.id.circular_prof_pic);
        petName.setText(m1.getNombre());
        circProfPic.setImageResource(m1.getPic());
        mascotaBioAdapter mBAdapt = new mascotaBioAdapter(m1.getPosts(), getActivity());
        listaPosts.setAdapter(mBAdapt);
    }

    public void initListaBioMascotas(){
        mascotas = new ArrayList<mascota>();
        mascota m1 = new mascota("Rocky","Rocky", 0, R.drawable.bull_terrier);
        m1.addPosts(new post(m1.getId_pet(),2,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),6,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),10,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),4,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),15,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),30,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),10,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),12,m1.getPic()));
        m1.addPosts(new post(m1.getId_pet(),15,m1.getPic()));
        mascotas.add(m1);

        mascota m2 = new mascota("Bobby","Bobby", 0, R.drawable.pitbull_cachorro);
        m2.addPosts(new post(m2.getId_pet(),4,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),3,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),9,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),6,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),11,m2.getPic()));
        m2.addPosts(new post(m2.getId_pet(),20,m2.getPic()));
        mascotas.add(m2);

        mascota m3 =new mascota("Rudolph","Rudolph", 0, R.drawable.doberman_cachorro);
        m2.addPosts(new post(m3.getId_pet(),2,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),4,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),8,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),5,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),12,m3.getPic()));
        m2.addPosts(new post(m3.getId_pet(),25,m3.getPic()));
        mascotas.add(m3);

        mascota m4 = new mascota("Scott","Scott", 0, R.drawable.rottweiler_cachorro);
        m2.addPosts(new post(m4.getId_pet(),6,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),2,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),10,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),8,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),6,m4.getPic()));
        m2.addPosts(new post(m4.getId_pet(),21,m4.getPic()));
        mascotas.add(m4);

        mascota m5 =new mascota("Lucky","Lucky", 0, R.drawable.golden_retriever);
        m2.addPosts(new post(m5.getId_pet(),5,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),5,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),10,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),8,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),7,m5.getPic()));
        m2.addPosts(new post(m5.getId_pet(),19,m5.getPic()));
        mascotas.add(m5);

    }
/*
    private void setProfile(View view){
        circProfPic = view.findViewById(R.id.circular_prof_pic);
        petName = view.findViewById(R.id.pet_name);
        RecyclerView rView =  (RecyclerView) view.findViewById(R.id.rv_bio_mascota);
        GridLayoutManager glm = new GridLayoutManager(getContext(),3,GridLayoutManager.VERTICAL, false);
        rView.setLayoutManager(glm);
    }*/

}