package com.example.bacha.contactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleContacto extends AppCompatActivity {

    TextView tvNombre, tvTelefono, tvEmail;
    private final int PHONE_CALL_CODE = 100;

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
        //Intent intentCall = new Intent(Intent.ACTION_CALL);
        //intentCall.setData(Uri.parse("tel:" + telefono));
        //startActivity(intentCall);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE);
        } else {
            OldVersions(telefono);
        }
    }

    private void OldVersions(String telefono) {
        Intent intentOld = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono));
        if (CheckPermission(Manifest.permission.CALL_PHONE)) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(intentOld);
        } else {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.TextoDenegado), Toast.LENGTH_SHORT).show();
        }
    }

    //RECIBIR LA RESPUESTA DEL USUARIO
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PHONE_CALL_CODE:
                String permission = permissions[0];
                int result = grantResults[0];
                if (permission.equals(Manifest.permission.CALL_PHONE)) {
                    //comprobando si ha sido aceptado o denegado la petición del permiso
                    if (result == PackageManager.PERMISSION_GRANTED) {
                        //concedio el permiso
                        String telefono = tvTelefono.getText().toString();
                        Intent intentCall = new Intent(Intent.ACTION_CALL);
                        intentCall.setData(Uri.parse("tel:" + telefono));
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                        startActivity(intentCall);
                    }else{
                        //no se concedio el permiso
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.TextoDenegado), Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }

    }
    //Metodo para el permiso
    private boolean CheckPermission(String permission){
        int result = this.checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
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
