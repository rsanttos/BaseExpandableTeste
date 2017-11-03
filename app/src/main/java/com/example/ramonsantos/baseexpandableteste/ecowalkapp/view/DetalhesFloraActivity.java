package com.example.ramonsantos.baseexpandableteste.ecowalkapp.view;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.ramonsantos.baseexpandableteste.R;
import com.example.ramonsantos.baseexpandableteste.ecowalkapp.adaptadores.AdaptadorGeral;
import com.example.ramonsantos.baseexpandableteste.ecowalkapp.adaptadores.ImgAdapter;
import com.example.ramonsantos.baseexpandableteste.ecowalkapp.baseexpandable.InfoFilho;
import com.example.ramonsantos.baseexpandableteste.ecowalkapp.baseexpandable.InfoGrupo;
import com.example.ramonsantos.baseexpandableteste.ecowalkapp.dominio.Flora;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DetalhesFloraActivity extends AppCompatActivity {

    private int[] carros = {R.drawable.ferrari_laferrari, R.drawable.bugatti_veyron, R.drawable.pagani_zonda,
            R.drawable.porsche_911, R.drawable.mclaren, R.drawable.maserati_gran_turismo,
            R.drawable.lamborghini_veneno};

    private LinkedHashMap<String, InfoGrupo> informacoes = new LinkedHashMap<String, InfoGrupo>();
    private ArrayList<InfoGrupo> listaTitulos = new ArrayList<InfoGrupo>();

    private AdaptadorGeral adaptadorGeral;
    private ImgAdapter adaptadorImg;

    private ExpandableListView expandableListViewFlora;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_flora);

        ViewPager viewPager = (ViewPager) findViewById(R.id.vpImagensFlora);
        adaptadorImg = new ImgAdapter(this, carros);
        viewPager.setAdapter(adaptadorImg);

        // add data for displaying in expandable list view
        carregaDados();

        //get reference of the ExpandableListView
        expandableListViewFlora = (ExpandableListView) findViewById(R.id.elvDetalhesFlora);
        // create the adapter by passing your ArrayList data
        adaptadorGeral = new AdaptadorGeral(DetalhesFloraActivity.this, listaTitulos);
        // attach the adapter to the expandable list view
        expandableListViewFlora.setAdapter(adaptadorGeral);

        // setOnChildClickListener listener for child row click
        expandableListViewFlora.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //get the group header
                InfoGrupo titulo = listaTitulos.get(groupPosition);
                //get the child info
                InfoFilho detalhesFilho = titulo.getFilhos().get(childPosition);
                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        expandableListViewFlora.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                InfoGrupo titulo = listaTitulos.get(groupPosition);

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
