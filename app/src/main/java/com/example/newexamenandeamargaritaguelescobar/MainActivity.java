package com.example.newexamenandeamargaritaguelescobar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Aviso;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Aviso = (TextView)findViewById(R.id.aviso);

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                Aviso.setText("El juego inicia en: " + l/500);
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(),pantcartas.class);
                startActivity(intent);
            }
        }.start();
    }
}