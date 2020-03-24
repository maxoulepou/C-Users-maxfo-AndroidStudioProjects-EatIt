package Model;

/**
 * Gestion des objets de type Poids.
 */
public class Poids {

    private double poids;
    private double taille;
    private String date;
    private double imc;
    private double muscle;
    private double graisse;
    private double tt;

    /**
     * Constructeur initialisant tous les attributs de la classe.
     *
     * @param poids
     * @param taille
     * @param date
     * @param muscle
     * @param graisse
     * @param tt
     */
    public Poids(double poids, double taille, String date, double muscle, double graisse, double tt) {
        this.poids = poids;
        this.taille = taille;
        this.setImc();
        this.date = date;
        this.muscle = muscle;
        this.graisse = graisse;
        this.tt = tt;
    }



    public double getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getDate() {
        return date;
    }

    public double getImc() {
        return imc;
    }

    public void setImc() {
        this.imc = this.poids / Math.pow(this.taille,2);
    }

    public double getMuscle() {
        return muscle;
    }

    public double getGraisse() {
        return graisse;
    }

    public double getTt() {
        return tt;
    }
}
