package Model;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.eatit.R;

public class Repas {
    private int duree, niveauFaim;
    private TypeRepas repas; // a modifier
    private String description;
    //photo

    public Repas (int duree, int niveauFaim, TypeRepas repas, String description){
        this.duree = duree;
        this. niveauFaim = niveauFaim;
        this.repas = repas;
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public int getNiveauFaim() {
        return niveauFaim;
    }

    public TypeRepas getRepas() {
        return repas;
    }

    public String getDescription() {
        return description;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setNiveauFaim(int niveauFaim) {
        this.niveauFaim = niveauFaim;
    }

    public void setRepas(TypeRepas repas) {
        this.repas = repas;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
