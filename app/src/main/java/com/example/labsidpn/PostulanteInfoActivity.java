package com.example.labsidpn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PostulanteInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);

        Intent intent = getIntent();
        ArrayList<Postulante> registro = (ArrayList<Postulante>) intent.getSerializableExtra(MenuActivity.KEY_NAME);

        EditText editFiltro = findViewById(R.id.etpostulanteinfobuscador);
        TextView tvResult = findViewById(R.id.tvpostulanteinforesult);
        TextView tvNombres = findViewById(R.id.tvpostulantenombres);
        TextView tvDni = findViewById(R.id.tvpostulantedni);
        TextView tvApellidos = findViewById(R.id.tvpostulanteapellidos);
        TextView tvColegio = findViewById(R.id.tvpostulantecolegio);
        TextView tvCarrera = findViewById(R.id.tvpostulantecarrera);
        Button btnBuscar = findViewById(R.id.btipostulanteinfobuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filtro = editFiltro.getText().toString();
                boolean ver = false;

                if(!(TextUtils.isEmpty(filtro))){
                    for(Postulante pos : registro){
                        if(filtro.equals(pos.getDni())){
                            tvResult.setText(" ");
                            tvDni.setText(pos.getDni());
                            tvNombres.setText(pos.getNombres());
                            tvApellidos.setText(pos.getaPaterno()+" " + pos.getaMaterno());
                            tvColegio.setText(pos.getColegio());
                            tvCarrera.setText(pos.getCarrera());
                            ver = true;
                            break;
                        }
                    }
                    if(ver == false){
                        tvResult.setText("DNI no encontrado");
                    } else {
                        tvResult.setText(" ");
                    }
                }
                else{
                    tvResult.setText("Ingrese DNI");
                }
            }
        });
    }
}