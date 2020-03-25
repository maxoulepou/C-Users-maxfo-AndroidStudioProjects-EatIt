package com.example.eatit.Model;

/**
 * Gestion des objets de types RessentiActivite.
 */
public class RessentiActivite extends Ressenti {

    private String activite;
    private int duree;
    private int difficulte;

    public RessentiActivite(int id, String date, String commentaire, int duree, int difficulte, String activite) {
        super(id, date, commentaire);
        this.activite = activite;
        this.duree = duree;
        this.difficulte = difficulte;
    }

    public String getActivite() {
        return activite;
    }

    public int getDuree() {
        return duree;
    }

    public int getDifficulte() {
        return difficulte;
    }
}