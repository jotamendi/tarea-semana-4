package com.jmdevs.formulariodecontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmarFormulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_formulario);

        Bundle form = getIntent().getExtras();
        String name = form.getString(getResources().getString(R.string.Knombre));
        String fechaN = form.getString(getResources().getString(R.string.KfechaN));
        String telefono = form.getString(getResources().getString(R.string.Ktelefono));
        String mail = form.getString(getResources().getString(R.string.Kmail));
        String descripcion = form.getString(getResources().getString(R.string.Kdescrip));

        TextView tv_nom = findViewById(R.id.tv_nom);
        TextView tv_fn = findViewById(R.id.tv_fecha);
        TextView tv_tel = findViewById(R.id.tv_telefono);
        TextView tv_mail = findViewById(R.id.tv_mail);
        TextView tv_descrip = findViewById(R.id.tv_descrip);

        tv_nom.setText(name);
        tv_fn.setText(fechaN);
        tv_tel.setText(telefono);
        tv_mail.setText(mail);
        tv_descrip.setText(descripcion);

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ConfirmarFormulario.this, MainActivity.class);
                intent2.putExtra(getResources().getString(R.string.Knombre), name);
                String[] parts = fechaN.split("\\/");
                String dia = parts[0].toString();
                String mes = parts[1].toString();
                String anio = parts[2].toString();
                intent2.putExtra(getResources().getString(R.string.kdia), dia);
                intent2.putExtra(getResources().getString(R.string.kmes), mes);
                intent2.putExtra(getResources().getString(R.string.kanio), anio);
                intent2.putExtra(getResources().getString(R.string.Ktelefono), telefono);
                intent2.putExtra(getResources().getString(R.string.Kmail), mail);
                intent2.putExtra(getResources().getString(R.string.Kdescrip), descripcion);

                startActivity(intent2);
            }
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast aviso = Toast.makeText(getApplicationContext(),getResources().getString(R.string.toast1), Toast.LENGTH_SHORT);
                aviso.show();
            }
        });

    }
}