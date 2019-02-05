package com.example.bacha.contactos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.bacha.contactos.adapter.PageAdapter;
import com.example.bacha.contactos.fragments.Perfil;
import com.example.bacha.contactos.fragments.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ListView listaContacto;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.tool_bar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        /*Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);*/

        //inicializamos el Adaptador
        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
        setUpViewPager();

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
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new Perfil());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }

}
