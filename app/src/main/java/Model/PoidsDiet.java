package Model;

public class PoidsDiet {

    private double masseGraisseuse, masseMusculaire;

    public PoidsDiet(double masseGraisseuse, double masseMusculaire){
        this.masseGraisseuse = masseGraisseuse;
        this.masseMusculaire = masseMusculaire;
    }

    public double getMasseGraisseuse() {
        return masseGraisseuse;
    }

    public void setMasseGraisseuse(double masseGraisseuse) {
        this.masseGraisseuse = masseGraisseuse;
    }

    public double getMasseMusculaire() {
        return masseMusculaire;
    }

    public void setMasseMusculaire(double masseMusculaire) {
        this.masseMusculaire = masseMusculaire;
    }
}
