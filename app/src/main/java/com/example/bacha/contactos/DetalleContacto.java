package com.example.bacha.contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetalleContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
    }

    public void DatosContacto(){
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String correo = parametros.getString(getResources().getString(R.string.pcorreo));

    }
}
