package com.example.fabregas.boletin2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Ejercicio7 extends AppCompatActivity {

    private int a, b, resultado;
    private EditText operandoA, operandoB;
    private Button ok;
    private Spinner opcion;
    private TextView res;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio5);

        operandoA = (EditText) findViewById(R.id.operandoA);
        operandoB = (EditText) findViewById(R.id.operandoB);
        ok = (Button) findViewById(R.id.aceptar);
        opcion = (Spinner) findViewById(R.id.opciones);
        res = (TextView) findViewById(R.id.resultado);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void lanzar(View v) {

        this.a = Integer.parseInt(operandoA.getText().toString());
        this.b = Integer.parseInt(operandoB.getText().toString());

        String op = opcion.getSelectedItem().toString();
        switch (op) {
            case "Suma":
                resultado = a + b;
                break;
            case "Resta":
                resultado = a - b;
                break;
            case "Multiplicacion":
                resultado = a * b;
                break;
            case "Division":
                try {
                    resultado = a / b;
                } catch (ArithmeticException e) {
                    Snackbar.make(v, "No se puede Dividir entre 0\nDividendo Cambiado a 1",Snackbar.LENGTH_LONG).show();
                    operandoB.setText("1");
                }

        }
        res.setText(String.valueOf(resultado));
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Ejercicio5 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setAutoCancel(true);
        builder.setSmallIcon(R.mipmap.ic_launcher);

        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),

                R.mipmap.ic_launcher));

        builder.setContentTitle("Notificación Ejercicio 5");
        builder.setContentText("El Resultado de la operacion fue " + resultado);

        Intent intent = new Intent(getApplicationContext(), Ejercicio5.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        builder.setContentIntent(pendingIntent);
        NotificationManager nm =

                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.notify(1, builder.build());

    }
}
