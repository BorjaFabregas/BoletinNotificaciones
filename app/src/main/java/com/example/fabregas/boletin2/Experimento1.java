package com.example.fabregas.boletin2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Experimento1 extends AppCompatActivity {

    private EditText edtNumero;
    private Button butBorrar, butPotencia,butRellenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experimento1);

        edtNumero = (EditText) findViewById(R.id.edtNumero);
        butPotencia = (Button) findViewById(R.id.butPotencia);
        butBorrar = (Button) findViewById(R.id.butBorrar);

        butPotencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder dialog = new AlertDialog.Builder(Experimento1.this);
                dialog.setTitle("Potencia");
                dialog.setMessage("Se va a calcular 2 elevado a " + edtNumero.getText().toString());
                dialog.setPositiveButton("Calcular", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edtNumero.setText("" + Math.pow(2,Double.parseDouble(edtNumero.getText().toString())));
                        dialogInterface.cancel();
                    }
                });
                dialog.show();
            }
        });

    }

    public void borrar(View view){

        AlertDialog.Builder dialog = new AlertDialog.Builder(Experimento1.this);

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
