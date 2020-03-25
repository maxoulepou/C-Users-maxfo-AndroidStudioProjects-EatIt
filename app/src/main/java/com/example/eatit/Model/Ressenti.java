package com.example.eatit.Model;

/**
 * Gestion des objets de types Ressenti. Cette classe a trois classes filles : RessentiActivite, RessentiTete et RessentiCorps.
 */
public abstract class Ressenti {

    private int idRessenti;
    private String date;
    private String commentaire;

    public Ressenti (int id, String date, String commentaire){
        this.idRessenti = id;
        this.date = date;
        this.commentaire = commentaire;
    }

    public String getDate() {
        return date;
    }

    public String getCommentaire() {
        return commentaire;
    }
}
