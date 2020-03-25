package com.example.eatit.Model;

/**
 * Gestion des objets de type Repas.
 */
public class Repas {
    private String typeRepas;
    private String duree, niveauFaim, niveauEnvie, niveauSatiete, contexteRepas;
    private String description, mDate;
    private String heure;

    public Repas (String date, String heure, String duree, String niveauFaim, String typeRepas, String description, String niveauEnvie, String niveauSatiete, String contexteRepas){
        this.mDate = date;
        this.duree = duree;
        this.niveauFaim = niveauFaim;
        this.niveauEnvie = niveauEnvie;
        this.niveauSatiete = niveauSatiete;
        this.contexteRepas = contexteRepas;
        this.typeRepas = typeRepas;
        this.description = description;
        this.heure = heure;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDuree() {
        return duree;
    }

    public String getNiveauFaim() {
        return niveauFaim;
    }

    public String getNiveauEnvie() {
        return niveauEnvie;
    }

    public String getNiveauSatiete() {
        return niveauSatiete;
    }

    public String getContexteRepas() {
        return contexteRepas ;
    }

    public String getTypeRepas() {
        return typeRepas;
    }

    public String getDescription() {
        return description;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public void setNiveauFaim(String niveauFaim) {
        this.niveauFaim = niveauFaim;
    }

    public void setTypeRepas(String typeRepas) {
        this.typeRepas = typeRepas;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
