package com.example.fabregas.boletin2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button butExp1, butExp2, butExp3,
            butEj1, butEj2, butEj3,
            butEj4, butEj5, butEj6, butEj7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butExp1 = (Button) findViewById(R.id.butExp1);
        butExp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Experimento1.class));
            }
        });

        butExp2 = (Button) findViewById(R.id.butExp2);
        butExp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Experimento2.class));
            }
        });

        butExp3 = (Button) findViewById(R.id.butExp3);
        butExp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Experimento3.class));
            }
        });

        butEj1 = (Button) findViewById(R.id.butEj1);
        butEj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Ejercicio1.class));
            }
        });

        butEj2 = (Button) findViewById(R.id.butEj2);
        butEj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Ejercicio2.class));
            }
        });

        butEj3 = (Button) findViewById(R.id.butEj3);
        butEj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Consulta la Clase Util\n Paquete com.example.fabregas.boletin2", Toast.LENGTH_SHORT).show();
            }
        });

        butEj4 = (Button) findViewById(R.id.butEj4);
        butEj4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "El metodo dialogo(); ha sido sobrecargado", Toast.LENGTH_SHORT).show();
            }
        });

        butEj5 = (Button) findViewById(R.id.butEj5);
        butEj5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Ejercicio5.class));
            }
        });

        butEj6 = (Button) findViewById(R.id.butEj6);
        butEj6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "LNotifications revisado", Toast.LENGTH_SHORT).show();
            }
        });

        butEj7 = (Button) findViewById(R.id.butEj7);
        butEj7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Ejercicio7.class));
            }
        });



    }
}