package com.example.ramonsantos.baseexpandableteste.ecowalkapp.baseexpandable;

import com.example.ramonsantos.baseexpandableteste.ChildInfo;

import java.util.ArrayList;

/**
 * Created by ramonsantos on 31/10/17.
 */

public class InfoGrupo {
    private String titulo;
    private ArrayList<InfoFilho> filhos;

    public InfoGrupo() {
    }

    public InfoGrupo(String titulo) {
        this.titulo = titulo;
        this.filhos = new ArrayList<InfoFilho>();
    }

    public InfoGrupo(String titulo, ArrayList<InfoFilho> filhos) {
        this.titulo = titulo;
        this.filhos = filhos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<InfoFilho> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<InfoFilho> filhos) {
        this.filhos = filhos;
    }
}
