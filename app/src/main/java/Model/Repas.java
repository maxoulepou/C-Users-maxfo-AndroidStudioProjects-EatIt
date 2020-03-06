package Model;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.eatit.R;

public class Repas {
    private String duree, niveauFaim;
    private String repas; // a modifier
    private String description, mDate;
    //photo

    public Repas (String date, String duree, String niveauFaim, String repas, String description){
        this.mDate = date;
        this.duree = duree;
        this. niveauFaim = niveauFaim;
        this.repas = repas;
        this.description = description;
    }

    public String getDuree() {
        return duree;
    }

    public String getNiveauFaim() {
        return niveauFaim;
    }

    public String getRepas() {
        return repas;
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

    public void setRepas(String repas) {
        this.repas = repas;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
