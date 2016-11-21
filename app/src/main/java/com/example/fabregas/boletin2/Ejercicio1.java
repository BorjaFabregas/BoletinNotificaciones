package com.example.fabregas.boletin2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ejercicio1 extends AppCompatActivity {

    private EditText edtNumero;
    private Button butBorrar, butPotencia, butRellenar;
    private String[] items = {"8", "16", "32"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        edtNumero = (EditText) findViewById(R.id.edtNumero);
        butPotencia = (Button) findViewById(R.id.butPotencia);
        butBorrar = (Button) findViewById(R.id.butBorrar);
        butRellenar = (Button) findViewById(R.id.butRellenar);

        butPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNumero.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "El Campo esta vacío", Toast.LENGTH_LONG).show();
                } else {
                    final AlertDialog.Builder dialog = new AlertDialog.Builder(Ejercicio1.this);
                    dialog.setTitle("Potencia");
                    dialog.setMessage("Se va a calcular 2 elevado a " + edtNumero.getText().toString());
                    dialog.setPositiveButton("Calcular", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            edtNumero.setText("" + Math.pow(2, Double.parseDouble(edtNumero.getText().toString())));
                            dialogInterface.cancel();
                        }
                    });
                    dialog.show();
                }
            }
        });

        butRellenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Ejercicio1.this);
                dialog.setTitle("Escoge un numero");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                edtNumero.setText("8");
                                dialogInterface.cancel();
                                break;
                            case 1:
                                edtNumero.setText("16");
                                dialogInterface.cancel();
                                break;
                            case 2:
                                edtNumero.setText("32");
                                dialogInterface.cancel();
                        }
                    }
                });
                dialog.show();
            }
        });

    }

    public void borrar(View view) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Ejercicio1.this);

        dialog.setTitle("Borrar");
        dialog.setMessage("Se va a borrar el numero actual");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                edtNumero.setText("");
                dialogInterface.cancel();
            }
        });
        dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        dialog.show();

    }
}
