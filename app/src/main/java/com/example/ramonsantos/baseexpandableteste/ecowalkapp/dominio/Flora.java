package com.example.ramonsantos.baseexpandableteste.ecowalkapp.dominio;

/**
 * Created by ramonsantos on 31/10/17.
 */

public class Flora {
    private String familia;
    private String informacoesEcologicas;

    public Flora(String familia, String informacoesEcologicas) {
        this.familia = familia;
        this.informacoesEcologicas = informacoesEcologicas;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getInformacoesEcologicas() {
        return informacoesEcologicas;
    }

    public void setInformacoesEcologicas(String informacoesEcologicas) {
        this.informacoesEcologicas = informacoesEcologicas;
    }
}
