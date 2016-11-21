package com.example.fabregas.boletin2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class Experimento2 extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_experimento2);

    }

    public void notificar(View view) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setAutoCancel(true);
        builder.setSmallIcon(R.mipmap.ic_launcher);

        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),

                R.mipmap.ic_launcher));

        builder.setContentTitle("Notificación Experimento 2");
        builder.setContentText("Ésta es una notificación del experimento 2.");
        builder.setSubText("Algún detalle de la notificación.");

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.upo.es"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        builder.setContentIntent(pendingIntent);
        NotificationManager nm =

                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.notify(1, builder.build());

    }


}
