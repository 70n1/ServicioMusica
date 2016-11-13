package org.example.serviciomusica;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button arrancar = (Button) findViewById(R.id.boton_arrancar);
        arrancar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startService(new Intent(MainActivity.this,
                        ServicioMusica.class));
            }
        });
        Button detener = (Button) findViewById(R.id.boton_detener);
        detener.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopService(new Intent(MainActivity.this,
                        ServicioMusica.class));
            }
        });

        Button socorro = (Button) findViewById(R.id.boton_socorro);
        socorro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzar_socorro();
            }
        });
    }
    public void lanzar_socorro(){

        NotificationCompat.Builder notific = new NotificationCompat.Builder(this) .setContentTitle("¡SOCORRO!") .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("Socorroooooo")
                .setVibrate(new long[] { 0,100,200,100,200,100,200,400,200,400,200,400,200,100,200,100,200,100,200 })
                .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.socorro));

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(555, notific.build());
    }
}