package com.example.labsidpn;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.carrier.CarrierMessagingService;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    public static final String KEY_NAME = "MENU";
    ArrayList<Postulante> registro;
    TextView resultRegistro;

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK){
                        Intent intent = result.getData();
                        Postulante pos = (Postulante) intent.getSerializableExtra(PostulanteRegistroActivity.KEY_NAME);
                        registro.add(pos);
                        resultRegistro.setText("Registro exitoso");
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        registro = new ArrayList<>();

        resultRegistro = findViewById(R.id.tvmenuresultRegister);
        Button btRegistrar = findViewById(R.id.btmenuregistrar);
        Button btConsultar = findViewById(R.id.btmenuconsultar);

        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultRegistro.setText("");
                Intent intentToRegistro = new Intent(getApplicationContext(), PostulanteRegistroActivity.class);
                startForResult.launch(intentToRegistro);
            }
        });

        btConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultRegistro.setText("");
                Intent intentConsulta = new Intent(getApplicationContext(), PostulanteInfoActivity.class);
                intentConsulta.putExtra(KEY_NAME, registro);
                startActivity(intentConsulta);
            }
        });
    }
}