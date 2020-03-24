package Model;

/**
 * Gestion des objets de type Evenement.
 */
public class Evenement {

    private String date, evenement, commentaire;

    public Evenement(int idEvenement, String date, String evenement, String commentaire) {

        this.date=date;
        this.evenement=evenement;
        this.commentaire=commentaire;

    }

    public String getEvenement() {
        return evenement;
    }

    public String getDate() {
        return date;
    }

    public String getCommentaire() {
        return commentaire;
    }

}
