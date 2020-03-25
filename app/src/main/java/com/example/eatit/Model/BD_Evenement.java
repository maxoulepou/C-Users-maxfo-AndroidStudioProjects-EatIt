package com.example.eatit.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import androidx.annotation.Nullable;

/**
 * Gestion de la base de données des événements de santé.
 */
public class BD_Evenement extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "evenementsante.db";
    public static final String TABLE_NAME = "table_evenement";
    public static final String col_idEvenement = "idEvenement";
    public static final String col_date = "Date";
    public static final String col_evenement = "Evénement";
    public static final String col_comm = "Commentaire";

    private ArrayList<Evenement> liste_evenement;

    public BD_Evenement(@Nullable Context context){
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String strSQL = "create table " + TABLE_NAME + "("
                + col_idEvenement + " integer primary key autoincrement,"
                + col_date + " text not null,"
                + col_evenement + " text not null,"
                + col_comm + " text "
                + ")";

        db.execSQL(strSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insererEvenement(String date, String evenement, String commentaire) {

        ContentValues cv = new ContentValues();

        //Variables obligatoires, ne peuvent pas être NULL.
        cv.put(col_date, date);
        cv.put(col_evenement, evenement);

        //Dans le cas où les variables qui peuvent être NULL le sont, on introduit "NULL" dans la BD si le String qui est entré par l'utilisateur est vide.
        if (commentaire.isEmpty()) {
            cv.putNull(col_comm);
        } else {
            cv.put(col_comm, commentaire);
        }

        long result = this.getWritableDatabase().insert(TABLE_NAME, null, cv);

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public ArrayList<Evenement> getTousLesEvenement() {

        liste_evenement = new ArrayList<Evenement>();

        String requete = "select " + col_idEvenement + "," + col_date + "," + col_evenement + "," + col_comm + " from " + TABLE_NAME + " order by " + col_date + " desc";

        Cursor touslesevenements = this.getWritableDatabase().rawQuery(requete, null);

        for (touslesevenements.moveToFirst(); !touslesevenements.isAfterLast(); touslesevenements.moveToNext()) {

            int idEvenement = touslesevenements.getInt(0);
            String date = touslesevenements.getString(1);
            String evenement = touslesevenements.getString(2);
            String comm = touslesevenements.getString(3);

            liste_evenement.add(new Evenement(idEvenement, date, evenement, comm));
        }

        return liste_evenement;

    }

}
