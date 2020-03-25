package com.example.eatit.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * Gestion de la base de données des contacts.
 */
public class BD_Contact extends SQLiteOpenHelper {


//    -------------- NOM DE LA BD ET DE LA TABLE DANS CETTE BD ---------------------

    public static final String DATABASE_NAME = "contacts.db";
    public static final String TABLE_NAME = "table_contact";

//    -------------- NOM DES COLONNES DE LA BD -------------------------------------

    public static final String col_idContact = "idContact";
    public static final String col_prenom = "prenom";
    public static final String col_nom = "nom";
    public static final String col_profession = "profession";
    public static final String col_email = "email";
    public static final String col_telephone = "telephone";
    public static final String col_adresse = "adresse";

    //    ---------------- LISTE DE CONTACTS -------------------------------------------

    private ArrayList<Contact> liste_contacts;


//    ---------------------- BASE DE DONNEES----------------------------------------


//    La méthode BD_Contact prend le constructeur de la classe SQLiteOpenHelper dont la classe
//    BD_Contact hérite, d'où le super. Ce constructeur va permettre de créer la base de données
//    "contacts.db".

    public BD_Contact(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


//    La méthode onCreate est lancée automatiquement. Elle permet de créer la table "table_contact"
//    avec toutes les colonnes qu'on a défini dans la partie "NOM DES COLONNES DE LA BD".

    @Override
    public void onCreate(SQLiteDatabase db) {

        String strSQL = "create table " + TABLE_NAME + "("
                + col_idContact + " integer primary key autoincrement,"
                + col_prenom + " text not null check (length(" + col_prenom + ")>= 1),"
                + col_nom + " text not null check (length(" + col_nom + ")>= 1),"
                + col_profession + " text not null check (length(" + col_profession + ")>= 1),"
                + col_email + " text,"
                + col_telephone + " text,"
                + col_adresse + " text "
                + ")";

        db.execSQL(strSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    /**
     * Enregistre un nouveau contact dans la base de données.
     * @param prenom
     * @param nom
     * @param profession
     * @param email
     * @param telephone
     * @param adresse
     * @return
     */
    public boolean insererContact(String prenom, String nom, String profession, String email, String telephone, String adresse) {

        ContentValues cv = new ContentValues();

        //Variables obligatoires, ne peuvent pas être NULL.
        cv.put(col_prenom, prenom);
        cv.put(col_nom, nom);
        cv.put(col_profession, profession);

        //Dans le cas où les variables qui peuvent être NULL le sont, on introduit "NULL" dans la BD si le String qui est entré par l'utilisateur est vide.
        if (email.isEmpty()) {
            cv.putNull(col_email);
        } else {
            cv.put(col_email, email);
        }

        if (telephone.isEmpty()) {
            cv.putNull(col_telephone);
        } else {
            cv.put(col_telephone, telephone);
        }

        if (adresse.isEmpty()) {
            cv.putNull(col_adresse);
        } else {
            cv.put(col_adresse, adresse);
        }

        long result = this.getWritableDatabase().insert(TABLE_NAME, null, cv);

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }


    /**
     * Récupère une liste d'objets de type Contact, correspondant à tous les contacts enregistrés dans la base de données.
     * @return
     */
    public ArrayList<Contact> getTousLesContacts() {

        liste_contacts = new ArrayList<Contact>();

        String requete = "select " + col_idContact + "," + col_prenom + "," + col_nom + "," + col_profession + "," + col_email + "," + col_telephone + "," + col_adresse + " from " + TABLE_NAME + " order by " + col_profession + " asc";

        Cursor touslescontacts = this.getWritableDatabase().rawQuery(requete, null);

        for (touslescontacts.moveToFirst(); !touslescontacts.isAfterLast(); touslescontacts.moveToNext()) {

            int idContact = touslescontacts.getInt(0);
            String prenom = touslescontacts.getString(1);
            String nom = touslescontacts.getString(2);
            String profession = touslescontacts.getString(3);
            String email = touslescontacts.getString(4);
            String telephone = touslescontacts.getString(5);
            String adresse = touslescontacts.getString(6);

            liste_contacts.add(new Contact(idContact, nom, prenom, profession, email, telephone, adresse));
        }

        return liste_contacts;

    }


    /**
     * Modifie le contact dont l'id est renseigné en paramètre.
     * @param idContact
     * @param prenom
     * @param nom
     * @param profession
     * @param email
     * @param telephone
     * @param adresse
     * @return true si l'update s'est fait, false dans le cas contraire.
     */
    public boolean modifierContact(int idContact, String prenom, String nom, String profession, String email, String telephone, String adresse) {

        ContentValues cv = new ContentValues();
        cv.put(col_idContact, idContact);
        cv.put(col_prenom, prenom);
        cv.put(col_nom, nom);
        cv.put(col_profession, profession);
        cv.put(col_email, email);
        cv.put(col_telephone, telephone);
        cv.put(col_adresse, adresse);

        int nombre = this.getWritableDatabase().update(TABLE_NAME, cv, col_idContact + "= ?", new String[]{String.valueOf(idContact)});
        if (nombre == 1) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Supprime un contact.
     * @param idContact
     * @return true si la délétion s'est ocrrectement faire, false dans le cas contraire.
     */
    public boolean supprimerContact(int idContact) {

        int nombre = this.getWritableDatabase().delete(TABLE_NAME, col_idContact + "=?", new String[]{String.valueOf(idContact)});

        if (nombre == 1) {
            return true;
        } else {
            return false;
        }
    }
}
