package Model;

public class Objectifs {

    private String intitule, type, atteint, idUtilisateur, dateDebut, dateFin, commentaire, accomplissement;
    // TypeObjet a voir

    public Objectifs(String idUtilisateur, String intitule, String type, String dateDebut,
                     String dateFin, String commentaire){
        this.idUtilisateur = idUtilisateur;
        this.intitule = intitule;
        this.type = type;
        this.atteint = "non";
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.commentaire = commentaire;
        this.accomplissement = "0";
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getEtat() {
        return atteint;
    }

    public void setEtat(String etat) {
        this.atteint = etat;
    }

    public String getId() {
        return idUtilisateur;
    }
}
