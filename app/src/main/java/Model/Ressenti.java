package Model;

public abstract class Ressenti {

    private int idRessenti;
    private String date;
    private String commentaire;

    public Ressenti (int id, String date, String commentaire){
        this.idRessenti = id;
        this.date = date;
        this.commentaire = commentaire;
    }

    public int getIdRessenti() {
        return idRessenti;
    }

    public String getDate() {
        return date;
    }

    public String getCommentaire() {
        return commentaire;
    }
}
