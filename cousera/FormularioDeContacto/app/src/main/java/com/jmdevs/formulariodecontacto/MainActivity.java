package com.jmdevs.formulariodecontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_sig = findViewById(R.id.btn_siguiente);

        EditText et1 = findViewById(R.id.editName);
        EditText et3 = findViewById(R.id.editPhoneNumber);
        EditText et4 = findViewById(R.id.editEmail);
        EditText et5 = findViewById(R.id.editDescrip);
        DatePicker dp1 = findViewById(R.id.dp_form);

        Bundle editForm = getIntent().getExtras();
        if(editForm != null){
            String name = editForm.getString(getResources().getString(R.string.Knombre));
            String tel = editForm.getString(getResources().getString(R.string.Ktelefono));
            String mail = editForm.getString(getResources().getString(R.string.Kmail));
            String descrip = editForm.getString(getResources().getString(R.string.Kdescrip));
            String dia = editForm.getString(getResources().getString(R.string.kdia));
            String mes = editForm.getString(getResources().getString(R.string.kmes));
            String anio = editForm.getString(getResources().getString(R.string.kanio));

            et1.setText(name);
            et3.setText(tel);
            et4.setText(mail);
            et5.setText(descrip);
            dp1.updateDate(Integer.valueOf(anio), Integer.valueOf(mes) -1 , Integer.valueOf(dia));
        }

        btn_sig.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(MainActivity.this, ConfirmarFormulario.class);
                int day = dp1.getDayOfMonth();
                int month = dp1.getMonth() + 1;
                int year = dp1.getYear();

                intent1.putExtra(getResources().getString(R.string.Knombre), et1.getText().toString());
                intent1.putExtra(getResources().getString(R.string.KfechaN),day+ "/" +month+ "/" +year);
                intent1.putExtra(getResources().getString(R.string.Ktelefono), et3.getText().toString());
                intent1.putExtra(getResources().getString(R.string.Kmail), et4.getText().toString());
                intent1.putExtra(getResources().getString(R.string.Kdescrip), et5.getText().toString());

                startActivity(intent1);

            }
        });
    }
}