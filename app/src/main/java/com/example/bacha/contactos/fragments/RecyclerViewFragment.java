package com.example.bacha.contactos.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bacha.contactos.R;
import com.example.bacha.contactos.adapter.ContactoAdaptador;
import com.example.bacha.contactos.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listaContactos = v.findViewById(R.id.recyclerContactos); //referencia a recyclerview
        //definimos la forma de mostrar mi RecyclerView
        //GridLayoutManager glm = new GridLayoutManager(this,2);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);//llm - glm
        inicializarListaContacto();
        inicializarAdaptador();
        return v;
    }
    public void inicializarListaContacto(){
        contactos = new ArrayList<>(); //lista de contactos
        for(int i=0; i<=19; i++){
            String cad = String.valueOf(i);
            contactos.add(new Contacto(R.drawable.icon_contacto, "Daniel Frasoso "+cad, "9612674521","ing.fragoso94@gmail.com"));
        }
        /*contactos.add(new Contacto(R.drawable.uno, "Daniel", "9612674521", "ing.fragoso94@gmail.com"));
        contactos.add(new Contacto(R.drawable.dos, "Miranda Keyes", "9612675005", "keyes94@gmail.com"));
        contactos.add(new Contacto(R.drawable.tres, "Ronald", "9612677001", "ronald4@gmail.com"));
        contactos.add(new Contacto(R.drawable.cuatro, "Alba", "9612675009", "alba@gmail.com"));
        contactos.add(new Contacto(R.drawable.cinco, "Maria", "9612675005", "maria@gmail.com"));*/
    }
    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }

}
