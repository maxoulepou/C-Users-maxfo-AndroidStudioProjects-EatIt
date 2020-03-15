package Model;

public abstract class Objectifs {

    private int idObjectif;
    private String intitule;
    private String type;
    private String dateDebut;
    private String dateFin;
    private int accomplissement;
    private String commentaire;
//    private String atteint;

    // TypeObjet a voir

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

//    public String getEtat() {
//        return getAtteint();
//    }
//
//    public void setEtat(String etat) {
//        this.setAtteint(etat);
//    }

    public int getId() {
        return getIdObjectif();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public String getAtteint() {
//        return atteint;
//    }
//
//    public void setAtteint(String atteint) {
//        this.atteint = atteint;
//    }

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
