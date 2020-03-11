package Model;

public class RessentiCorps extends Ressenti {

    private int niveau_bienetre;
    private String sensations;

    public RessentiCorps(int id, String date, String commentaire, int bienetre, String sensations) {
        super(id, date, commentaire);
        this.niveau_bienetre = bienetre;
        this.sensations = sensations;
    }

    public int getNiveau_bienetre() {
        return niveau_bienetre;
    }

    public String getSensations() {
        return sensations;
    }
}