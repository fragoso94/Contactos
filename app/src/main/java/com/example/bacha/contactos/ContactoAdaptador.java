package com.example.bacha.contactos;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {
    ArrayList<Contacto> contactos;
    Activity activity;
    //constructor
    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;

    }

    //infla el layout y lo pasara al viewHolder para obtener los views
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_contacto, viewGroup, false);
        return new ContactoViewHolder(v); //le pasamos la vista inflada
    }
    //asocia los elementos de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int i) {
        //aqui seteamos los valores
        final Contacto contacto = contactos.get(i); //i es la posición de los elementos de la lista
        contactoViewHolder.cvFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.cvNombre.setText(contacto.getNombre());
        contactoViewHolder.cvTelefono.setText(contacto.getTelefono());
        contactoViewHolder.cvFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //Toast.makeText(activity, contacto.getNombre(),Toast.LENGTH_SHORT).show();
                    Intent intentDetail = new Intent(activity, DetalleContacto.class);
                    intentDetail.putExtra("Nombre",contacto.getNombre());
                    intentDetail.putExtra("Telefono",contacto.getTelefono());
                    intentDetail.putExtra("Email",contacto.getEmail());
                    activity.startActivity(intentDetail);
                }
                catch (Exception e){
                    e.getMessage();
                }
                finally {

                }
            }
        });
    }

    @Override
    public int getItemCount() { //cantidad de elementos que contiene mi lista de contactos
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        //se declaran todos los views del CardView
        private ImageView cvFoto;
        private TextView cvNombre;
        private TextView cvTelefono;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            cvFoto = itemView.findViewById(R.id.cv_foto);
            cvNombre = itemView.findViewById(R.id.cv_Nombre);
            cvTelefono = itemView.findViewById(R.id.cv_telefono);
        }
    }

}
