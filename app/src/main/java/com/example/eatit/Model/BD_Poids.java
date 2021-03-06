package com.example.eatit.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * Gestion de la base de données du poids.
 */
public class BD_Poids extends SQLiteOpenHelper {

//    -------------- NOM DE LA BD ET DE LA TABLE DANS CETTE BD ---------------------

    public static final String DATABASE_NAME = "poids.db";
    public static final String TABLE_NAME = "table_poids";

//    -------------- NOM DES COLONNES DE LA BD -------------------------------------

    public static final String col_idPoids = "idPoids";
    public static final String col_poids = "Poids";
    public static final String col_taille = "Taille";
    public static final String col_imc = "IMC";
    public static final String col_date = "Date";
    public static final String col_tt = "TT";
    public static final String col_graisse = "Graisse";
    public static final String col_unite_graisse = "UniteGraisse";
    public static final String col_muscle = "Muscle";
    public static final String col_unite_muscle = "UniteMuscle";



//    ---------------- LISTE DE CONTACTS -------------------------------------------

    private ArrayList<Poids> liste_poids;


//    ---------------------- BASE DE DONNEES----------------------------------------

    public BD_Poids(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String strSQL = "create table " + TABLE_NAME + "("
                + col_idPoids + " integer primary key autoincrement,"
                + col_date + " text not null,"
                + col_poids + " double not null,"
                + col_taille + " double not null,"
                + col_imc + " double not null,"
                + col_tt + " double,"
                + col_graisse + " double,"
                + col_unite_graisse + " text,"
                + col_muscle + " double,"
                + col_unite_muscle + " text,"
                + "CONSTRAINT regle CHECK(" + col_poids + " BETWEEN 5 AND 400 AND " + col_taille + " BETWEEN 0 AND 400)"
                + ")";

        db.execSQL(strSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    /**
     * Enregistre de nouvelles données relatives au poids dans la base de données.
     * @param date
     * @param poids
     * @param taille
     * @param imc
     * @param tt
     * @param graisse
     * @param muscle
     * @return
     */
    public boolean insererPoids(String date, double poids, double taille, double imc, double tt, double graisse, String unitegraisse, double muscle, String unitemuscle) {

        ContentValues cv = new ContentValues();

        //Les variables suivantes ne peuvent pas être NULL
        cv.put(col_date, date);
        cv.put(col_poids, poids);
        cv.put(col_taille, taille);
        cv.put(col_imc, imc);


        //Les variables suivantes peuvent être NULL
        if (tt == -1) {
            cv.putNull(col_tt);
        } else {
            cv.put(col_tt, tt);
        }

        if (graisse == -1) {
            cv.putNull(col_graisse);
        } else {
            cv.put(col_graisse, graisse);
        }

        if (muscle == -1) {
            cv.putNull(col_muscle);
        } else {
            cv.put(col_muscle, muscle);
        }

        if(unitegraisse.isEmpty()) {
            cv.put(col_unite_graisse, "(?)");
        }
        else{
            cv.put(col_unite_graisse,unitegraisse);
        }

        if(unitemuscle.isEmpty()) {
            cv.put(col_unite_muscle, "(?)");
        }
        else{
            cv.put(col_unite_muscle,unitemuscle);
        }


        //On insère la ligne dans la BD
        long result = this.getWritableDatabase().insert(TABLE_NAME, null, cv);

        //La fonction insert renvoie un boolean : si la ligne est bien insérée, on a true, sinon on a false
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Récupère la dernière valeur de poids entrée dans la base de données.
     * @return
     */
    public double getPoidsActuel() {
        String requete = "select " + col_poids + " from " + TABLE_NAME + " where " + col_date + " in " + "(select max( " + col_date + ") " + " from " + TABLE_NAME + " where " + col_poids + " is not null) ";
        Cursor result = this.getWritableDatabase().rawQuery(requete, null);
        double poids;
        if (result.moveToFirst()) {
            poids = result.getDouble(0);
        } else {
            poids = 0.0;
        }
        return poids;
    }


    /**
     * Récupère la première valeur de poids entrée dans la base de données.
     * @return
     */
    public double getPoidsDepart() {
        String requete = "select " + col_poids + " from " + TABLE_NAME + " where " + col_date + " in " + "(select min( " + col_date + ") " + " from " + TABLE_NAME + " where " + col_poids + " is not null) ";
        Cursor result = this.getWritableDatabase().rawQuery(requete, null);
        double poids;
        if (result.moveToFirst()) {
            poids = result.getDouble(0);
        } else {
            poids = 0.0;
        }
        return poids;
    }

    /**
     * Récupère la dernière valeur d'IMC calculée dans la base de données.
     * @return
     */
    public double getIMC() {
        String requete = "select " + col_imc + " from " + TABLE_NAME + " where " + col_date + " in " + "(select max( " + col_date + ") " + " from " + TABLE_NAME + " where " + col_imc + " is not null) ";
        Cursor result = this.getWritableDatabase().rawQuery(requete, null);
        double imc;
        if (result.moveToFirst()) {
            imc = result.getDouble(0);
        } else {
            imc = 0.0;
        }
        return imc;
    }


    /**
     * Récupère la dernière valeur de tour de taille entrée dans la base de données.
     * @return
     */
    public double getTTActuel() {
        //select TT FROM table_poids where date in (select max(date) from table_poids where TT is not NULL)
        String requete = "select " + col_tt + " from " + TABLE_NAME + " where " + col_date + " in " + "(select max( " + col_date + ") " + " from " + TABLE_NAME + " where " + col_tt + " is not null) ";
        Cursor result = this.getWritableDatabase().rawQuery(requete, null);
        double tt;
        if (result.moveToFirst()) {
            tt = result.getDouble(0);
        } else {
            tt = 0.0;
        }
        return tt;
    }


    /**
     * Récupère la première valeur de tour de taille entrée dans la base de données.
     * @return
     */
    public double getTTDepart() {
        String requete = "select " + col_tt + " from " + TABLE_NAME + " where " + col_date + " in " + "(select min( " + col_date + ") " + " from " + TABLE_NAME + " where " + col_tt + " is not null) ";
        Cursor result = this.getWritableDatabase().rawQuery(requete, null);
        double tt;
        if (result.moveToFirst()) {
            tt = result.getDouble(0);
        } else {
            tt = 0.0;
        }
        return tt;
    }


    /**
     * Récupère la dernière valeur de tour de taille entrée dans la base de données.
     * @return
     */
    public double getTailleActuelle() {
        String requete = "select " + col_taille + " from " + TABLE_NAME + " where " + col_date + " in " + "(select max( " + col_date + ") " + " from " + TABLE_NAME + " where " + col_taille + " is not null) ";
        Cursor result = this.getWritableDatabase().rawQuery(requete, null);
        double taille;
        if (result.moveToFirst()) {
            taille = result.getDouble(0);
        } else {
            taille = 0.0;
        }
        return taille;
    }


    /**
     * Récupère une liste d'objets de type Poids contenant toutes les données relatives au poids de la base de données.
     * @return
     */
    public ArrayList<Poids> getTousLesPoids() {

        liste_poids = new ArrayList<Poids>();

        String requete = "select * from " + TABLE_NAME + " order by " + col_date + " desc";

        Cursor touslespoids = this.getWritableDatabase().rawQuery(requete, null);

        for (touslespoids.moveToFirst(); !touslespoids.isAfterLast(); touslespoids.moveToNext()) {

            String date = touslespoids.getString(1);
            double poids = touslespoids.getDouble(2);
            double taille = touslespoids.getDouble(3);
            double tt = touslespoids.getDouble(5);
            double graisse = touslespoids.getDouble(6);
            String unitegraisse = touslespoids.getString(7);
            double muscle = touslespoids.getDouble(8);
            String unitemuscle = touslespoids.getString(9);


            liste_poids.add(new Poids(poids,taille,date,muscle,unitemuscle,graisse,unitegraisse,tt));
        }

        return liste_poids;

    }


}