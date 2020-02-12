package Model;

import java.util.Date;

public class Poids {

    private Date date;
    private double tourTaille, taille, imc, poidsDomicile;
    private PoidsDiet poidsDiet;

    public Poids(Date date){
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTourTaille() {
        return tourTaille;
    }

    public void setTourTaille(double tourTaille) {
        this.tourTaille = tourTaille;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getPoidsDomicile() {
        return poidsDomicile;
    }

    public void setPoidsDomicile(double poidsDomicile) {
        this.poidsDomicile = poidsDomicile;
    }

    public PoidsDiet getPoidsDiet() {
        return poidsDiet;
    }

    public void setPoidsDiet(PoidsDiet poidsDiet) {
        this.poidsDiet = poidsDiet;
    }
}
