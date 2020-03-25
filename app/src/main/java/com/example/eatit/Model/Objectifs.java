package com.example.eatit.Model;

/**
 * Gestion des objets de types Objectifs. Cette classe a deux classes filles : ObjectifPartage et ObjectifPersonnel.
 */
public abstract class Objectifs {

    private int idObjectif;
    private String intitule;
    private String type;
    private String dateDebut;
    private String dateFin;
    private int accomplissement;
    private String commentaire;


    public Objectifs(int idobjectif, String intitule, String type, String dateDebut,
                     String dateFin, String commentaire, int accomplissement){
        this.setIdObjectif(idobjectif);
        this.setIntitule(intitule);
        this.setType(type);
        this.setDateDebut(dateDebut);
        this.setDateFin(dateFin);
        this.setCommentaire(commentaire);
        this.setAccomplissement(accomplissement);
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getId() {
        return getIdObjectif();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdObjectif() {
        return idObjectif;
    }

    public void setIdObjectif(int idObjectif) {
        this.idObjectif = idObjectif;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getAccomplissement() {
        return accomplissement;
    }

    public void setAccomplissement(int accomplissement) {
        this.accomplissement = accomplissement;
    }
}
