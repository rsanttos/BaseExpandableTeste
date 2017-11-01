package com.example.ramonsantos.baseexpandableteste.ecowalkapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.ramonsantos.baseexpandableteste.ChildInfo;
import com.example.ramonsantos.baseexpandableteste.CustomAdapter;
import com.example.ramonsantos.baseexpandableteste.GroupInfo;
import com.example.ramonsantos.baseexpandableteste.MainActivity;
import com.example.ramonsantos.baseexpandableteste.R;
import com.example.ramonsantos.baseexpandableteste.ecowalkapp.adaptadores.AdaptadorGeral;
import com.example.ramonsantos.baseexpandableteste.ecowalkapp.baseexpandable.InfoFilho;
import com.example.ramonsantos.baseexpandableteste.ecowalkapp.baseexpandable.InfoGrupo;
import com.example.ramonsantos.baseexpandableteste.ecowalkapp.dominio.Flora;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static com.example.ramonsantos.baseexpandableteste.R.id.simpleExpandableListView;

/**
 * Created by ramonsantos on 31/10/17.
 */

public class ActivityEcoWalk extends AppCompatActivity {
    private LinkedHashMap<String, InfoGrupo> informacoes = new LinkedHashMap<String, InfoGrupo>();
    private ArrayList<InfoGrupo> listaTitulos = new ArrayList<InfoGrupo>();

    private AdaptadorGeral adaptador;

    private ExpandableListView expandableListViewFlora;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add data for displaying in expandable list view
        carregaDados();

        //get reference of the ExpandableListView
        expandableListViewFlora = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
        // create the adapter by passing your ArrayList data
        adaptador = new AdaptadorGeral(ActivityEcoWalk.this, listaTitulos);
        // attach the adapter to the expandable list view
        expandableListViewFlora.setAdapter(adaptador);

        // setOnChildClickListener listener for child row click
        expandableListViewFlora.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //get the group header
                InfoGrupo titulo = listaTitulos.get(groupPosition);
                //get the child info
                InfoFilho detalhesFilho = titulo.getFilhos().get(childPosition);
                //display it or do something with it
                //display it or do something with it
                Toast.makeText(getBaseContext(), " Team Name / conteudo:: " + titulo.getTitulo() + " / " + detalhesFilho.getConteudo(),
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        expandableListViewFlora.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                InfoGrupo titulo = listaTitulos.get(groupPosition);
                //display it or do something with it
                Toast.makeText(getBaseContext(), " Team Name :: " + titulo.getTitulo(),
                        Toast.LENGTH_LONG).show();

                return false;
            }
        });
    }

    public void carregaDados(){
        Flora flora = new Flora("familia flora", "informacoes ecologicas flora");

        String tituloFamilia = "FAMILIA";
        String tituloInfoEco = "INFORMACOES ECOLOGICAS";

        InfoGrupo infoGrupoFamilia = new InfoGrupo(tituloFamilia);
        informacoes.put(tituloFamilia, infoGrupoFamilia);
        listaTitulos.add(infoGrupoFamilia);

        List<InfoFilho> filhosGrupoFamilia = new ArrayList<InfoFilho>();
        filhosGrupoFamilia.add(new InfoFilho(flora.getFamilia() + " FILHO "));
        infoGrupoFamilia.setFilhos((ArrayList<InfoFilho>) filhosGrupoFamilia);

        InfoGrupo infoGrupoInfoEcologicas = new InfoGrupo(tituloInfoEco);
        informacoes.put(tituloInfoEco, infoGrupoInfoEcologicas);
        listaTitulos.add(infoGrupoInfoEcologicas);

        List<InfoFilho> filhosGrupoInfoEco = new ArrayList<InfoFilho>();
        filhosGrupoInfoEco.add(new InfoFilho(flora.getInformacoesEcologicas() + " FILHO "));
        infoGrupoInfoEcologicas.setFilhos((ArrayList<InfoFilho>) filhosGrupoInfoEco);



    }
}
