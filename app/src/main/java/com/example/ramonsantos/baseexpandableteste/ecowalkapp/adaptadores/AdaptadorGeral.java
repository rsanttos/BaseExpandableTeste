package com.example.ramonsantos.baseexpandableteste.ecowalkapp.adaptadores;

import android.content.Context;
import android.icu.text.IDNA;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.ramonsantos.baseexpandableteste.ChildInfo;
import com.example.ramonsantos.baseexpandableteste.GroupInfo;
import com.example.ramonsantos.baseexpandableteste.R;
import com.example.ramonsantos.baseexpandableteste.ecowalkapp.baseexpandable.InfoFilho;
import com.example.ramonsantos.baseexpandableteste.ecowalkapp.baseexpandable.InfoGrupo;

import java.util.ArrayList;

/**
 * Created by ramonsantos on 31/10/17.
 */

public class AdaptadorGeral extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<InfoGrupo> titulos;

    public AdaptadorGeral(Context context, ArrayList<InfoGrupo> titulos) {
        this.context = context;
        this.titulos = titulos;
    }

    @Override
    public int getGroupCount() {
        return titulos.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<InfoFilho> listaConteudos = titulos.get(groupPosition).getFilhos();
        return listaConteudos.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return titulos.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<InfoFilho> listaConteudos = titulos.get(groupPosition).getFilhos();
        return listaConteudos.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        InfoGrupo titulo = (InfoGrupo) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.group_items, null);
        }

        TextView heading = (TextView) convertView.findViewById(R.id.heading);
        heading.setText(titulo.getTitulo().trim());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        InfoFilho detalhesInformacoes = (InfoFilho) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_items, null);
        }
        TextView childItem = (TextView) convertView.findViewById(R.id.childItem);
        childItem.setText(detalhesInformacoes.getConteudo().trim());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
