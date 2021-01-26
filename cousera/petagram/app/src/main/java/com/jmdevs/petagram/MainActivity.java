package com.jmdevs.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import com.jmdevs.petagram.mascota;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(actionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rv_mascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        /*GridLayoutManager glm = new GridLayoutManager(this, 1);*/

        listaMascotas.setLayoutManager(llm);
        initListaMascotas();
        initAdapter();

        ImageButton imgBtn_star = (ImageButton) findViewById(R.id.imgBtn_star);
        imgBtn_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ultimos5Fav.class);
            startActivity(intent);
            }
        });

    }

    public void initAdapter(){
        mascotaAdapter mAdapt = new mascotaAdapter(mascotas);
        listaMascotas.setAdapter(mAdapt);
    }

    public void initListaMascotas(){
        mascotas = new ArrayList<mascota>();

        mascotas.add(new mascota("Rocky", 0, R.drawable.bull_terrier));
        mascotas.add(new mascota("Bobby", 0, R.drawable.pitbull_cachorro));
        mascotas.add(new mascota("Rudolph", 0, R.drawable.doberman_cachorro));
        mascotas.add(new mascota("Scott", 0, R.drawable.rottweiler_cachorro));
        mascotas.add(new mascota("Lucky", 0, R.drawable.golden_retriever));

    }
}