package com.example.bacha.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    ListView listaContacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<>();
        contactos.add(new Contacto("Daniel","9612674521","ing.fragoso94@gmail.com"));
        contactos.add(new Contacto("Miranda Keyes","9612675005","keyes94@gmail.com"));
        contactos.add(new Contacto("Ronald","9612677001","ronald4@gmail.com"));
        contactos.add(new Contacto("Alba","9612675009","alba@gmail.com"));
        contactos.add(new Contacto("Maria","9612675005","maria@gmail.com"));

        ArrayList<String> nombreContacto = new ArrayList<>();
        for (Contacto contacto:contactos) {
            nombreContacto.add(contacto.getNombre());
        }

        listaContacto = (ListView)findViewById(R.id.lv_contacto);
        listaContacto.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreContacto));
        listaContacto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentItem = new Intent(MainActivity.this,DetalleContacto.class);
                //mandando datos a la otra actividad
                intentItem.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intentItem.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intentItem.putExtra(getResources().getString(R.string.pcorreo   ),contactos.get(position).getEmail());
                startActivity(intentItem);
                finish();
            }
        });
    }
}
