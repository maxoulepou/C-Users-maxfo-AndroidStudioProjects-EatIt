package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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


//    ---------------- LISTE DE CONTACTS -------------------------------------------

    private ArrayList<Contact> contacts;

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
                + col_prenom + " text not null check (length(" + col_prenom + ">= 1)),"
                + col_nom + " text not null check (length(" + col_nom + ">= 1)),"
                + col_profession + " text not null check (length(" + col_profession + ">= 1)),"
                + col_email + " text not null check (length(" + col_email + ">= 1)),"
                + col_telephone + " text not null check (length(" + col_telephone + ">= 1))"
                + ")";

        db.execSQL(strSQL);

    }

    // La méthode onUpgrade est une émthode dont on hérite du coup je suis obligée de la définir ici
    // même si on l'utilise jamais. C'est dans le cas où on a une nouvelle version de BD et qu'il
    // faut écraser l'ancienne.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    //Méthode pour insérer un nouveau contact dans la BD, typiquement quand on appuie sur "enregistrer"
    //sur la page pour l'ajout d'un nouveau contact.
    public boolean insererContact(String prenom, String nom, String profession, String email, String telephone) {

        ContentValues cv = new ContentValues();

        cv.put(col_prenom, prenom);
        cv.put(col_nom, nom);
        cv.put(col_profession, profession);
        cv.put(col_email, email);
        cv.put(col_telephone, telephone);

        long result = this.getWritableDatabase().insert(TABLE_NAME, null, cv);

//  Autre méthode pour insérer :
//        String sql = "INSERT INTO " + TABLE_NAME + "(" + col_prenom + " , " + col_nom +" , " + col_profession + " , " + col_email + " , " + col_email + ")"
//                   + "VALUES(" + "'" + prenom + "'," + "'" + nom + "'," + "'" + profession + "'," + "'" + email + "'," + "'" + telephone + "')" ;
//
//        this.getWritableDatabase().execSQL(sql);
//        this.getWritableDatabase().close();
//
//        En faisant this.getWritableDatabase, on récupère la base de données qu'on a créée. La
//        méthode insert renvoie par défaut un numéro : -1 ou un autre truc. Quand c'est -1 ça
//        veut dire que l'insertion ne s'est pas bien déroulée.

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }


    // C'est une méthode pour avoir le nombre de ligne dans la BD des contacts.
    public int getNombre() {
        //Un Cursor c'est le résultat de la requete qui est écrite dans la fonction rawQuery juste en dessous.
        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME, null);

        //Le while il me sert dans les tests à récupérer les données de la colonne 2 + connaitre leur longueur.
        //C'était pour voir si quand on insérait des chaines de caractères vides ça ajoutait qd même à la BD ou pas.
        //Eh oui, ça ajoute une ligne à la BD même quand on écrit rien comme information de contact et qu'on clique sur "enregistrer"
        //Je comprends toujours pas pq...
        while (result.moveToNext()) {
            System.out.println("test : " + result.getString(2));
            System.out.println("longueur : " + result.getString(2).length());
        }

        return result.getCount();


    }

    //C'est une méthode pour avoir tous les contacts de la BD.
    //Ca remplit une liste de Contacts en initialisant chaque Contact avec les données de la BD.
    //C'est pour ça qu'on fait un "new Contact(...)" à la ligne 152.

    public ArrayList<Contact> getContacts() {
        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME, null);
        while (!result.isAfterLast()) {

            String nom = result.getString(result.getColumnIndex(col_nom));
            System.out.println("nom : " + nom);

            String prenom = result.getString(result.getColumnIndex(col_prenom));
            System.out.println("prenom : " + prenom);

            String profession = result.getString(result.getColumnIndex(col_profession));
            System.out.println("profession : " + profession);

            String email = result.getString(result.getColumnIndex(col_email));
            System.out.println("email : " + email);

            String telephone = result.getString(result.getColumnIndex(col_prenom));
            System.out.println("nom : " + nom);
            System.out.println("-------------------------");

            contacts.add(new Contact(nom, prenom, profession, email, telephone));

            result.moveToNext();
        }

        result.close();

        return contacts;
    }


    // Méthode pour modifier un contact mais je l'ai pas encore testé.
    public boolean modifierContact(String idContact, String prenom, String nom, String profession, String email, String telephone) {

        ContentValues cv = new ContentValues();

        cv.put(col_idContact, idContact);
        cv.put(col_prenom, prenom);
        cv.put(col_nom, nom);
        cv.put(col_profession, profession);
        cv.put(col_email, email);
        cv.put(col_telephone, telephone);

        int nombre = this.getWritableDatabase().update(TABLE_NAME, cv, col_idContact + "= ?", new String[]{idContact});

        if (nombre == 1) {
            return true;
        } else {
            return false;
        }

    }

    // Méthode pour avoir l'ID d'un contact mais je l'ai pas encore testé.
    public int getIdContact(String prenom, String nom, String profession, String email, String telephone) {

        String strSQL = "select " + col_idContact + " from " + TABLE_NAME
                + " where "
                + col_prenom + " = " + "'" + prenom + "'" + " and "
                + col_nom + " = " + "'" + nom + "'" + " and "
                + col_email + " = " + "'" + email + "'" + " and "
                + col_telephone + " = " + "'" + telephone + "'";

        Cursor result = this.getWritableDatabase().rawQuery(strSQL, null);

        // On est censé récupérer l'ID à partir du Cursor mais j'ai moi même imposé l'Id pour voir si
        // j'arrivais à appeler la méthode. Normalement l'ID est trouvé en cherchant dans la BD.
        int ID = 12222;

        if (result.moveToFirst()) {
            ID = result.getInt(0);
        }

        System.out.println("L'ID SELECTIONNE" + ID);

        return ID;

    }


    //    public boolean supprimerContact (String idContact){
//
//    }
}
