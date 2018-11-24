package com.example.bacha.contactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleContacto extends AppCompatActivity {

    TextView tvNombre, tvTelefono, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String correo = parametros.getString(getResources().getString(R.string.pcorreo));

        tvNombre = (TextView) findViewById(R.id.tv_nombre);
        tvTelefono = (TextView) findViewById(R.id.tv_telefono);
        tvEmail = (TextView) findViewById(R.id.tv_correo);
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(correo);
    }

    public void llamar(View view) {
        String telefono = tvTelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }else{
            Toast.makeText(getApplicationContext(),"No tienes permiso",Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono)));

    }
    public void enviarEmail(View view){
        String correo = tvEmail.getText().toString();
        String asunto = "Probando";
        String mensaje = "Saludos desde APP";

        Intent intentEmail = new Intent(Intent.ACTION_SEND);
        intentEmail.setData(Uri.parse("mailto:"));
        intentEmail.putExtra(Intent.EXTRA_EMAIL,correo);
        intentEmail.putExtra(Intent.EXTRA_SUBJECT,asunto);
        intentEmail.putExtra(Intent.EXTRA_TEXT,mensaje);
        intentEmail.setType("message/rfc822");
        startActivity(Intent.createChooser(intentEmail,"Email "));
    }

}
