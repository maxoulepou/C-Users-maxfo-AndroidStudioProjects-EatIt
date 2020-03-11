package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BD extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dataBase";
    public static final String TABLE_NAME = "tableUtilisateur";
    public static final String col_idUtilisateur = "id";
    public static final String col_Email = "email";
    public static final String col_Mdp = "Mot_de_passe";
    public static final String col_Nom = "Nom";
    public static final String col_Prenom = "Prenom";
    public static final String col_DateNaissance = "Date_de_naissance";
    public static final String col_Sexe = "Sexe";
    private Connection mConnection;

    public BD(@Nullable Context context){
        super(context, DATABASE_NAME, null, 1);

    }

    public void onCreate(SQLiteDatabase db){
        String strSQL = "create table " + TABLE_NAME +" ("
                + col_idUtilisateur + " integer primary key autoincrement, "
                + col_Email + " text not null, "
                + col_Mdp + " text not null, "
                + col_Nom + " text, "
                + col_Prenom + " text, "
                + col_DateNaissance + " text, "
                + col_Sexe + " text)";
        db.execSQL(strSQL);
        System.out.println("BD_Repas créer");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void ChangerMotDePasse(String mail, String newmdp) {
        try {

            //Création d'un objet Statement
            Statement state = mConnection.createStatement();
            String query = "UPDATE connexion\n" + "SET " + col_Mdp + " ='" + "'\nWHERE idpersonnel='" + this.getId(mail) + "'";
            state.executeUpdate(query);
            state.close();

            System.out.println("Modification du mot de passe réussi");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creerCompte(Patient p) {

        try {
            ContentValues cv = new ContentValues();
//        formatedDate = sdf.format(date);

            cv.put(col_Email, p.getEmail());
            cv.put(col_Mdp, p.getMdp());
            cv.put(col_Nom, p.getNom());
            cv.put(col_Prenom, p.getPrenom());
            cv.put(col_DateNaissance, p.getDateNaissance().toString());
            cv.put(col_Sexe, p.getSexe());

            System.out.println("Le patient a bien été ajouté à la BD");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getId(String mail){
        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME + " where " + col_Email + " = '" + mail +"'", null);
                for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()){
                    String mID = result.getString(0);
                    return mID;
                }
                return "Error";
    }

    public boolean seConnecter(String mail, String mdp){
        boolean peutSeConnecter = false;
        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME + " where " + col_Email + " = '" + mail +"'", null);
        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()){ //J'aurai bien mis juste result.moveTofirst() mais fonctionne pas...
            String mMail = result.getString(1);
            System.out.println(mMail);
            String mMdp = result.getString(2);
            System.out.println(mMdp);
            if (mail.equals(mMail) && mdp.equals(mMdp)){
                System.out.println(mail);
                System.out.println(mdp);
                peutSeConnecter = true;
            }
        }
        return peutSeConnecter;
    }
}
