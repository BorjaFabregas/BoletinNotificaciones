package com.example.fabregas.boletin2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class Experimento3 extends AppCompatActivity {

    private ListView listLlamadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experimento3);

        listLlamadas = (ListView) findViewById(R.id.listLlamadas);
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(Experimento3.this, android.R.layout.simple_list_item_1, getLlamadas());

        listLlamadas.setAdapter(adaptador);

    }

    public String[] getLlamadas() {

        List<String> llamadas = new LinkedList<String>();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED) {
            Cursor cur = getContentResolver().query(CallLog.Calls.CONTENT_URI, new
                    String[]{CallLog.Calls.TYPE, CallLog.Calls.NUMBER}, null, null, null);
            if (cur.moveToFirst()) {
                int colTelefono = cur.getColumnIndex(CallLog.Calls.NUMBER);
                do {
                    llamadas.add(cur.getString(colTelefono));
                } while (cur.moveToNext());
            }
        }

        return llamadas.toArray(new String[llamadas.size()]);

    }

}