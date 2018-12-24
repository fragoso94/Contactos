package com.example.bacha.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    //ListView listaContacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);*/
        listaContactos = findViewById(R.id.recyclerContactos);
        //definimos la forma de mostrar mi RecyclerView

        GridLayoutManager glm = new GridLayoutManager(this,2);
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(glm);//llm - glm
        inicializarListaContacto();
        inicializarAdaptador();
        //inicializamos el Adaptador


        /*ArrayList<String> nombreContacto = new ArrayList<>();
        for (Contacto contacto : contactos) {
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
        });*/
    }

    public void inicializarListaContacto(){
        contactos = new ArrayList<>(); //lista de contactos
        contactos.add(new Contacto(R.drawable.uno, "Daniel", "9612674521", "ing.fragoso94@gmail.com"));
        contactos.add(new Contacto(R.drawable.dos, "Miranda Keyes", "9612675005", "keyes94@gmail.com"));
        contactos.add(new Contacto(R.drawable.tres, "Ronald", "9612677001", "ronald4@gmail.com"));
        contactos.add(new Contacto(R.drawable.cuatro, "Alba", "9612675009", "alba@gmail.com"));
        contactos.add(new Contacto(R.drawable.cinco, "Maria", "9612675005", "maria@gmail.com"));
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }
}
