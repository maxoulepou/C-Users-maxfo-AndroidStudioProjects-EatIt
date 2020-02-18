package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class BD_Contact extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contacts.db";
    public static final String TABLE_NAME = "table_contact";

    public static final String col_idContact = "idContact";
    public static final String col_prenom = "prenom";
    public static final String col_nom = "nom";
    public static final String col_profession = "profession";
    public static final String col_email = "email";
    public static final String col_telephone = "telephone";

//    private String nom, prenom, profession, email, telephone;

//    public BD_Contact(String nom, String prenom, String profession, String email, long telephone){
//        this.nom = nom;
//        this.prenom = prenom;
//        this.profession = profession;
//        this.email = email;
//        this.telephone = telephone;
//    }

//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getPrenom() {
//        return prenom;
//    }
//
//    public void setPrenom(String prenom) {
//        this.prenom = prenom;
//    }
//
//    public String getProfession() {
//        return profession;
//    }
//
//    public void setProfession(String profession) {
//        this.profession = profession;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) { this.telephone = telephone; }


    // ----------------------------------- BASE DE DONNEES----------------------------------------

    public BD_Contact(@Nullable Context context) {

        // Ici on crée la base de données
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Ici on ajoute une table "table_contact" à la BD "contacts.db"

        String strSQL = "create table" + TABLE_NAME + "("
                + "idContact integer primary key autoincrement,"
                + "prenom text not null,"
                + "nom text not null,"
                + "profession text not null,"
                + "email text not null,"
                + "telephone text not null"
                + ")";
        db.execSQL(strSQL);
        Log.i("DATABASE", "onCreate invoked");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insererContact(String prenom, String nom, String profession, String email, String telephone) {

        // Insertion d'un nouveau contact après remplissage du formulaire. On va set chacun des
        // attributs avec les champs que le patient remplit dans le layout des contacts.

//        String strSQL = "insert into table_contact (prenom, nom, profession, email, telephone) values ("
//                + "'" + prenom + "',"
//                + "'" + nom + "',"
//                + "'" + profession + "',"
//                + "'" + email + "',"
//                + "'" + telephone + "'"
//                +"')";
//
//        this.getWritableDatabase().execSQL(strSQL);

        //Le this correspond à notre classe DataBaseHelper.
        //En faisant this.getWritableDatabase, on récupère SQLiteDatabase sur lequel
        //on peut maintenant faire .execSQL(...)

        ContentValues cv = new ContentValues();

        cv.put(col_prenom, prenom);
        cv.put(col_nom, nom);
        cv.put(col_profession, profession);
        cv.put(col_email, email);
        cv.put(col_telephone, telephone);

        long result = this.getWritableDatabase().insert(TABLE_NAME, null, cv);

        if (result == -1)
            return false;
        else
            return true;
    }
}
