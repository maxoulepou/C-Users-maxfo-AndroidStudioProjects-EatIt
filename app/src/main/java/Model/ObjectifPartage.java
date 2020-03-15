package Model;

public class ObjectifPartage extends Objectifs {

    private String professionnel;

    public ObjectifPartage(int idobjectif, String intitule, String type, String dateDebut, String dateFin, String commentaire, int accomplissement, String professionnel) {
        super(idobjectif, intitule, type, dateDebut, dateFin, commentaire, accomplissement);
        this.setProfessionnel(professionnel);
    }

    public String getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(String professionnel) {
        this.professionnel = professionnel;
    }
}
