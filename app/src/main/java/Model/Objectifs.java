package Model;

public class Objectifs {

    private String intitule;
    private int etat, id;
    // TypeObjet a voir

    public Objectifs(String intitule, int etat, int id){
        this.intitule = intitule;
        this.etat = etat;
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
