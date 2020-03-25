package com.example.eatit.Model;

/**
 * Gestion des objets de types RessentiTete.
 */
public class RessentiTete extends Ressenti {

    private String emotions;

    public RessentiTete(int id, String date, String commentaire, String emotions) {
        super(id, date, commentaire);
        this.emotions = emotions;
    }

    public String getEmotions() {
        return emotions;
    }
}