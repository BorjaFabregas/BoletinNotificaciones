package com.example.fabregas.boletin2;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Fabregas on 18/11/16.
 */

public class Util {


    public interface Operacion {
        public void operacion();

        public void operacion(String valor);
    }

    public static void dialogo(Activity a, String titulo, String mensaje,
                               final boolean conEntrada, final boolean okCancel, final Operacion op) {


        final AlertDialog.Builder dialog = new AlertDialog.Builder(a);


        dialog.setTitle(titulo);
        dialog.setMessage(mensaje);

        if (conEntrada) {
            LayoutInflater inflater = a.getLayoutInflater();
            View layout = inflater.inflate(R.layout.dialog, null);
            dialog.setView(layout);
            EditText editText = (EditText) layout.findViewById(R.id.editDialog);
        }

        if (okCancel) {
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (op != null) {
                        op.operacion();
                    } else {
                        dialogInterface.cancel();
                    }
                }
            });
            dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
        } else {
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (op != null) {
                        op.operacion();
                    } else {
                        dialogInterface.cancel();
                    }
                }
            });
        }


        dialog.show();

    }

    public static void dialogo(Activity a, String titulo, String mensaje, final Operacion op) {

        final AlertDialog.Builder dialog = new AlertDialog.Builder(a);
        dialog.setTitle(titulo);
        dialog.setMessage(mensaje);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (op != null) {
                    op.operacion();
                } else {
                    dialogInterface.cancel();
                }
            }
        });
        dialog.show();
    }

}
