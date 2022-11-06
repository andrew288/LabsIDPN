package com.example.labsidpn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PostulanteRegistroActivity extends AppCompatActivity {
    public static final String KEY_NAME = "REGISTRO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);

        EditText aPaterno = findViewById(R.id.etmainpaterno);
        EditText aMaterno = findViewById(R.id.etmainmaterno);
        EditText nombres = findViewById(R.id.etmainnombres);
        EditText fNacimiento = findViewById(R.id.etmainnacimiento);
        EditText colegio = findViewById(R.id.etmaincolegio);
        EditText carrera = findViewById(R.id.etmaincarrera);
        EditText dni = findViewById(R.id.etmaindni);
        TextView messageError = findViewById(R.id.tvmainmensaje);
        Button registrarse = findViewById(R.id.bmainregistrarse);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String sPaterno = aPaterno.getText().toString();
                String sMaterno = aMaterno.getText().toString();
                String sNombres = nombres.getText().toString();
                String sNacimiento = fNacimiento.getText().toString();
                String sColegio = colegio.getText().toString();
                String sCarrera = carrera.getText().toString();
                String sDni = dni.getText().toString();

                if(!(TextUtils.isEmpty(sPaterno) || TextUtils.isEmpty(sMaterno) || TextUtils.isEmpty(sNombres) ||
                        TextUtils.isEmpty(sNacimiento) || TextUtils.isEmpty(sColegio) || TextUtils.isEmpty(sCarrera) ||
                        TextUtils.isEmpty(sDni))){
                    Postulante pos = new Postulante(sDni, sPaterno, sMaterno, sNombres, sNacimiento, sColegio, sCarrera);
                    Intent intent = new Intent();
                    intent.putExtra(KEY_NAME, pos);
                    setResult(RESULT_OK, intent);
                    finish();
                } else{
                    messageError.setText("Registro invalido");
                }
            }
        });
    }
}