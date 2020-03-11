package Model;

public class Repas {
    private String duree, niveauFaim;
    private String typeRepas; // a modifier
    private String description, mDate;
    private String heure;
    //photo

    public Repas (String date, String heure, String duree, String niveauFaim, String typeRepas, String description){
        this.mDate = date;
        this.duree = duree;
        this. niveauFaim = niveauFaim;
        this.typeRepas = typeRepas;
        this.description = description;
        this.heure = heure;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDuree() {
        return duree;
    }

    public String getNiveauFaim() {
        return niveauFaim;
    }

    public String getTypeRepas() {
        return typeRepas;
    }

    public String getDescription() {
        return description;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public void setNiveauFaim(String niveauFaim) {
        this.niveauFaim = niveauFaim;
    }

    public void setTypeRepas(String typeRepas) {
        this.typeRepas = typeRepas;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
