package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BD_Ressenti extends SQLiteOpenHelper {


//    -------------- NOM DE LA BD ET DE LA TABLE DANS CETTE BD ---------------------

    public static final String DATABASE_NAME = "ressentis.db";

    public static final String TABLE_RESSENTI_TETE = "table_tete";
    public static final String TABLE_RESSENTI_CORPS = "table_corps";
    public static final String TABLE_RESSENTI_ACTIVITE = "table_activite";

//    -------------- NOM DES COLONNES DE TABLE_TETE -----------------------

    public static final String col_idRessenti_tete = "idRessenti";
    public static final String col_date_tete = "Date";
    public static final String col_emotions = "Emotions";
    public static final String col_comm_tete = "Commentaire";

//    -------------- NOM DES COLONNES DE TABLE_RESSENTI_CORPS -----------------------

    public static final String col_idRessenti_corps = "idRessenti";
    public static final String col_date_corps = "Date";
    public static final String col_sensations = "Sensation";
    public static final String col_comm_corps = "Commentaire";
    public static final String col_niveau_bienetre = "Bien_être";

//     -------------- NOM DES COLONNES DE TABLE_SPORT -----------------------

    public static final String col_idRessenti_activite = "idRessenti";
    public static final String col_date_activite = "Date";
    public static final String col_activite = "Activité";
    public static final String col_duree_activite = "Durée";
    public static final String col_difficulte = "Difficulté";
    public static final String col_comm_activite = "Commentaire";

//    ------------------------------ LISTES ---------------------------

    private ArrayList<RessentiTete> liste_ressentis_tete;
    private ArrayList<RessentiActivite> liste_ressentis_activite;
    private ArrayList<RessentiCorps> liste_ressentis_corps;

    private String emotion;
    private String sentation;

//        ------------------------------ BASE DE DONNEES ---------------------------

    public BD_Ressenti(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String strSQL_tete = "create table " + TABLE_RESSENTI_TETE + "("
                + col_idRessenti_tete + " integer primary key autoincrement,"
                + col_date_tete + " text not null,"
                + col_emotions + " text not null,"
                + col_comm_tete + " text"
                + ")";

        String strSQL_corps = "create table " + TABLE_RESSENTI_CORPS + "("
                + col_idRessenti_corps + " integer primary key autoincrement,"
                + col_date_corps + " text not null,"
                + col_sensations + " text not null,"
                + col_comm_corps + " text,"
                + col_niveau_bienetre + " integer not null"
                + ")";


        String strSQL_sport = "create table " + TABLE_RESSENTI_ACTIVITE + "("
                + col_idRessenti_activite + " integer primary key autoincrement,"
                + col_date_activite + " text not null,"
                + col_activite + " text not null,"
                + col_comm_activite + " text,"
                + col_duree_activite + " integer not null,"
                + col_difficulte + " integer not null"
                + ")";

        db.execSQL(strSQL_tete);
        db.execSQL(strSQL_corps);
        db.execSQL(strSQL_sport);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESSENTI_TETE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESSENTI_CORPS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESSENTI_ACTIVITE);
        onCreate(db);

    }

//    ----------------- INSERTIONS DE RESSENTIS -----------------------------------

    public boolean insererRessentiTete(String date, String emotions, String commentaire) {

        ContentValues cv = new ContentValues();

        //Variables obligatoires, ne peuvent pas être NULL.
        cv.put(col_date_tete, date);
        cv.put(col_emotions, emotions);

        //Dans le cas où les variables qui peuvent être NULL le sont, on introduit "NULL" dans la BD si le String qui est entré par l'utilisateur est vide.
        if (commentaire.isEmpty()) {
            cv.putNull(col_comm_tete);
        } else {
            cv.put(col_comm_tete, commentaire);
        }

        long result = this.getWritableDatabase().insert(TABLE_RESSENTI_TETE, null, cv);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insererRessentiCorps(String date, String sensations, String commentaire, int bienetre) {

        ContentValues cv = new ContentValues();

        //Variables obligatoires, ne peuvent pas être NULL.
        cv.put(col_date_tete, date);
        cv.put(col_sensations, sensations);
        cv.put(col_niveau_bienetre, bienetre);

        //Dans le cas où les variables qui peuvent être NULL le sont, on introduit "NULL" dans la BD si le String qui est entré par l'utilisateur est vide.
        if (commentaire.isEmpty()) {
            cv.putNull(col_comm_corps);
        } else {
            cv.put(col_comm_corps, commentaire);
        }

        long result = this.getWritableDatabase().insert(TABLE_RESSENTI_CORPS, null, cv);

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean insererRessentiSport(String date, String activite, String commentaire, int difficulte, int duree) {

        ContentValues cv = new ContentValues();

        //Variables obligatoires, ne peuvent pas être NULL.
        cv.put(col_date_activite, date);
        cv.put(col_activite, activite);
        cv.put(col_difficulte, difficulte);
        cv.put(col_duree_activite, duree);

        //Dans le cas où les variables qui peuvent être NULL le sont, on introduit "NULL" dans la BD si le String qui est entré par l'utilisateur est vide.
        if (commentaire.isEmpty()) {
            cv.putNull(col_comm_activite);
        } else {
            cv.put(col_comm_activite, commentaire);
        }

        long result = this.getWritableDatabase().insert(TABLE_RESSENTI_ACTIVITE, null, cv);

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }


//    -------------------- RECUPERATION DES TABLES SOUS FORME D ARRAYLISTS D'OBJETS ---------------


    public ArrayList<RessentiTete> getTousLesRessentisTete() {

        liste_ressentis_tete = new ArrayList<RessentiTete>();

        String requete = "select " + col_idRessenti_tete + "," + col_date_tete + "," + col_emotions + "," + col_comm_tete + " from " + TABLE_RESSENTI_TETE + " order by " + col_date_tete + " desc";

        Cursor touslesressentistete = this.getWritableDatabase().rawQuery(requete, null);

        for (touslesressentistete.moveToFirst(); !touslesressentistete.isAfterLast(); touslesressentistete.moveToNext()) {

            int idRessentiTete = touslesressentistete.getInt(0);
            String date = touslesressentistete.getString(1);
            String emotions = touslesressentistete.getString(2);
            String comm = touslesressentistete.getString(3);

            liste_ressentis_tete.add(new RessentiTete(idRessentiTete, date, comm, emotions));
        }

        return liste_ressentis_tete;

    }


    public ArrayList<RessentiCorps> getTousLesRessentisCorps() {

        liste_ressentis_corps = new ArrayList<RessentiCorps>();

        String requete = "select " + col_idRessenti_tete + "," + col_date_corps + "," + col_sensations + "," + col_comm_corps + "," + col_niveau_bienetre + " from " + TABLE_RESSENTI_CORPS + " order by " + col_date_corps + " desc";

        Cursor touslesressentiscorps = this.getWritableDatabase().rawQuery(requete, null);

        for (touslesressentiscorps.moveToFirst(); !touslesressentiscorps.isAfterLast(); touslesressentiscorps.moveToNext()) {

            int idRessentiCorps = touslesressentiscorps.getInt(0);
            String date = touslesressentiscorps.getString(1);
            String sensation = touslesressentiscorps.getString(2);
            String comm = touslesressentiscorps.getString(3);
            int bienetre = touslesressentiscorps.getInt(4);

            liste_ressentis_corps.add(new RessentiCorps(idRessentiCorps, date, comm, bienetre, sensation));
        }

        return liste_ressentis_corps;

    }

    public ArrayList<RessentiActivite> getTousLesRessentisActivite() {

        liste_ressentis_activite = new ArrayList<RessentiActivite>();

        String requete = "select " + col_idRessenti_activite + "," + col_date_activite + "," + col_activite + "," + col_duree_activite + "," + col_comm_activite + "," + col_difficulte + " from " + TABLE_RESSENTI_ACTIVITE + " order by " + col_date_corps + " desc";

        Cursor touslesressentisactivite = this.getWritableDatabase().rawQuery(requete, null);

        for (touslesressentisactivite.moveToFirst(); !touslesressentisactivite.isAfterLast(); touslesressentisactivite.moveToNext()) {

            int idRessentiCorps = touslesressentisactivite.getInt(0);
            String date = touslesressentisactivite.getString(1);
            String activite = touslesressentisactivite.getString(2);
            int duree = touslesressentisactivite.getInt(3);
            String comm = touslesressentisactivite.getString(4);
            int difficulte = touslesressentisactivite.getInt(5);

            liste_ressentis_activite.add(new RessentiActivite(idRessentiCorps, date, comm, duree, difficulte, activite));
        }

        return liste_ressentis_activite;

    }


//    ------------------------------------- RETROUVER RESSENTI EN FONCTION DE DATE --------------

    public ArrayList<RessentiTete> getTousLesRessentisTete(String date) {

        liste_ressentis_tete = new ArrayList<RessentiTete>();

        String requete = "select " + col_idRessenti_tete + "," + col_date_tete + "," + col_emotions + "," + col_comm_tete + " from " + TABLE_RESSENTI_TETE + " where " + col_date_tete + "='" + date +"'";

        Cursor touslesressentistete = this.getWritableDatabase().rawQuery(requete, null);

        for (touslesressentistete.moveToFirst(); !touslesressentistete.isAfterLast(); touslesressentistete.moveToNext()) {

            int idRessentiTete = touslesressentistete.getInt(0);
            String datee = touslesressentistete.getString(1);
            String emotions = touslesressentistete.getString(2);
            String comm = touslesressentistete.getString(3);

            liste_ressentis_tete.add(new RessentiTete(idRessentiTete, datee, comm, emotions));
        }

        return liste_ressentis_tete;

    }

    public ArrayList<RessentiCorps> getTousLesRessentisCorps(String date) {

        liste_ressentis_corps = new ArrayList<RessentiCorps>();

        String requete = "select " + col_idRessenti_tete + "," + col_date_corps + "," + col_sensations + "," + col_comm_corps + "," + col_niveau_bienetre + " from " + TABLE_RESSENTI_CORPS + "where" + col_date_corps + "='" + date +"'";

        Cursor touslesressentiscorps = this.getWritableDatabase().rawQuery(requete, null);

        for (touslesressentiscorps.moveToFirst(); !touslesressentiscorps.isAfterLast(); touslesressentiscorps.moveToNext()) {

            int idRessentiCorps = touslesressentiscorps.getInt(0);
            String datee = touslesressentiscorps.getString(1);
            String sensation = touslesressentiscorps.getString(2);
            String comm = touslesressentiscorps.getString(3);
            int bienetre = touslesressentiscorps.getInt(4);

            liste_ressentis_corps.add(new RessentiCorps(idRessentiCorps, datee, comm, bienetre, sensation));
        }

        return liste_ressentis_corps;

    }

    public ArrayList<RessentiActivite> getTousLesRessentisActivite(String date) {

        liste_ressentis_activite = new ArrayList<RessentiActivite>();

        String requete = "select " + col_idRessenti_activite + "," + col_date_activite + "," + col_activite + "," + col_duree_activite + "," + col_comm_activite + "," + col_difficulte + " from " + TABLE_RESSENTI_ACTIVITE + " where " + col_date_corps + "='" + date +"'";

        Cursor touslesressentisactivite = this.getWritableDatabase().rawQuery(requete, null);

        for (touslesressentisactivite.moveToFirst(); !touslesressentisactivite.isAfterLast(); touslesressentisactivite.moveToNext()) {

            int idRessentiCorps = touslesressentisactivite.getInt(0);
            String datee = touslesressentisactivite.getString(1);
            String activite = touslesressentisactivite.getString(2);
            int duree = touslesressentisactivite.getInt(3);
            String comm = touslesressentisactivite.getString(4);
            int difficulte = touslesressentisactivite.getInt(5);

            liste_ressentis_activite.add(new RessentiActivite(idRessentiCorps, datee, comm, duree, difficulte, activite));
        }

        return liste_ressentis_activite;

    }


}

