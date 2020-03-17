package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class BD extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dataBase.db";
    private Connection mConnection;
    private String idCo;

    public static final String TABLE_NAME_UTILISATEUR = "tableUtilisateur";
    public static final String col_idUtilisateur = "id";
    public static final String col_Email = "email";
    public static final String col_Mdp = "Mot_de_passe";
    public static final String col_Nom = "Nom";
    public static final String col_Prenom = "Prenom";
    public static final String col_DateNaissance = "Date_de_naissance";
    public static final String col_Sexe = "Sexe";

    public static String TABLE_NAME_BD_OBJ = "tableObjectifs";
    public static String col_id_obj = "IdObjectif";
    public static String col_intitule = "Intitule";
    public static String col_type_obj = "TypeObjectif";
    public static String col_date_debut = "dateDeDebut";
    public static String col_date_fin = "dateDeFin";
    public static String col_accomplissement = "Accomplissement";
    public static String col_Commentaire = "Commentaire";
    public static String col_professionnel = "Professionnel";
    //public static String col_atteint = "ObjectifAtteint";

    private ArrayList<ObjectifPersonnel> liste_objectifs_perso;
    private ArrayList<ObjectifPartage> liste_objectifs_part;
    private ArrayList<ObjectifPersonnel> liste_objectifs_perso_att;
    private ArrayList<ObjectifPartage> liste_objectifs_part_att;

    public BD(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    public void onCreate(SQLiteDatabase db) {
        String strSQLUtilisateur = "create table " + TABLE_NAME_UTILISATEUR + " ("
                + col_idUtilisateur + " integer primary key autoincrement, "
                + col_Email + " text not null, "
                + col_Mdp + " text not null, "
                + col_Nom + " text, "
                + col_Prenom + " text, "
                + col_DateNaissance + " text, "
                + col_Sexe + " text)";
        db.execSQL(strSQLUtilisateur);
        System.out.println("BD_Repas créer");

        String strSQLObj = "create table " + TABLE_NAME_BD_OBJ + " ("
                + col_id_obj + " integer primary key autoincrement, "
                + col_intitule + " text not null, "
                + col_type_obj + " text not null, "
                + col_date_debut + " text not null, "
                + col_date_fin + " text not null, "
                + col_accomplissement + " integer not null, "
                + col_Commentaire + " text, "
                + col_professionnel + " text, "
//                + col_atteint + " text DEFAULT 'non' not null,"
//                + "CONSTRAINT regle CHECK((" + col_atteint + "='oui'" + " OR " + col_atteint + "='non') AND (" + col_type_obj + "='partage'" + " OR " + col_type_obj + "='personnel'))"
                + "CONSTRAINT regle CHECK((" + col_accomplissement + "<11) AND (" + col_type_obj + "='partage'" + " OR " + col_type_obj + "='personnel'))"
                + ")";

        db.execSQL(strSQLObj);
        System.out.println("BD_Repas créer");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_UTILISATEUR);
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
        ContentValues cv = new ContentValues();

        cv.put(col_Email, p.getEmail());
        cv.put(col_Mdp, p.getMdp());
        cv.put(col_Nom, p.getNom());
        cv.put(col_Prenom, p.getPrenom());
        cv.put(col_DateNaissance, p.getDateNaissance());
        cv.put(col_Sexe, p.getSexe());

        System.out.println("Le patient a bien été ajouté à la BD");
        System.out.println(p.getEmail());
        System.out.println(p.getMdp());
        this.getWritableDatabase().insert(TABLE_NAME_UTILISATEUR, null, cv);
    }

    public String getId(String mail) {
        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME_UTILISATEUR + " where " + col_Email + " = '" + mail + "'", null);
        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            String mID = result.getString(0);
            return mID;
        }
        return "Pas de mail trouve";
    }

    public boolean seConnecter(String mail, String mdp) {
        boolean peutSeConnecter = false;
        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME_UTILISATEUR + " where " + col_Email + " = '" + mail + "'", null);
        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) { //J'aurai bien mis juste result.moveTofirst() mais fonctionne pas...
            String mMail = result.getString(1);
            System.out.println(mMail);
            String mMdp = result.getString(2);
            System.out.println(mMdp);

            if (mail.equals(mMail) && mdp.equals(mMdp)) {
                System.out.println(mail);
                System.out.println(mdp);
                peutSeConnecter = true;
            }
        }
        return peutSeConnecter;
    }

    public void estConnecte(String mail) {
        String requete = "select " + col_idUtilisateur + " from " + TABLE_NAME_UTILISATEUR + " where " + col_Email + " = '" + mail + "'";
        Cursor result = this.getWritableDatabase().rawQuery(requete, null);
        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            idCo = result.getString(0);
        }
    }

    public String getIdCo() {
        if (idCo != null) {
            return idCo;
        } else return "Pas didentifiant de connecte";
    }

    public boolean addObjectifs(String intitule, String type, String dateDebut, String dateFin, String commentaire, int accomplissement, String professionnel) {
        ContentValues cv = new ContentValues();

        cv.put(col_intitule, intitule);
        cv.put(col_type_obj, type);
        cv.put(col_date_debut, dateDebut);
        cv.put(col_date_fin, dateFin);
        cv.put(col_accomplissement, accomplissement);

        if (intitule.isEmpty()) {
            return false;
        }

        if (type.isEmpty()) {
            return false;
        }

        if (dateDebut.isEmpty()) {
            return false;
        }

        if (dateFin.isEmpty()) {
            return false;
        }


        if (professionnel.isEmpty()) {
            cv.putNull(col_professionnel);
        } else {
            cv.put(col_professionnel, professionnel);
        }

        if (commentaire.isEmpty()) {
            cv.put(col_Commentaire, "Aucun");
        } else {
            cv.put(col_Commentaire, commentaire);
        }

        long result = this.getWritableDatabase().insert(TABLE_NAME_BD_OBJ, null, cv);

        if (result == -1) {
            return false;
        } else {
            System.out.println("Objectif ajouté");
            return true;
        }
    }

    public ArrayList<ObjectifPartage> getObjectifsPartages() {

        liste_objectifs_part = new ArrayList<>();

        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME_BD_OBJ + " where " + col_type_obj + " = 'partage'", null);

        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            int id = result.getInt(0);
            String intitule = result.getString(1);
            String type = result.getString(2);
            String dateDebut = result.getString(3);
            String dateFin = result.getString(4);
            int accomplissement = result.getInt(5);
            String mCommentaire = result.getString(6);
            String pro = result.getString(7);

            ObjectifPartage obj = new ObjectifPartage(id, intitule, type, dateDebut, dateFin, mCommentaire, accomplissement, pro);

            liste_objectifs_part.add(obj);
        }

        result.close();
        return liste_objectifs_part;
    }


    public ArrayList<ObjectifPersonnel> getObjectifsPersonnels() {

        liste_objectifs_perso = new ArrayList<>();

        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME_BD_OBJ + " where " + col_type_obj + " = 'personnel'", null);

        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            int id = result.getInt(0);
            String intitule = result.getString(1);
            String type = result.getString(2);
            String dateDebut = result.getString(3);
            String dateFin = result.getString(4);
            int accomplissement = result.getInt(5);
            String mCommentaire = result.getString(6);

            ObjectifPersonnel obj = new ObjectifPersonnel(id, intitule, type, dateDebut, dateFin, mCommentaire, accomplissement);

            liste_objectifs_perso.add(obj);
        }

        result.close();
        return liste_objectifs_perso;
    }

    public ArrayList<ObjectifPersonnel> getObjectifPersoAtteint() {

        liste_objectifs_perso_att = new ArrayList<>();

        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME_BD_OBJ + " where " + col_type_obj + " = 'personnel'" + " AND " + col_accomplissement + "=10 ", null);

        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            int id = result.getInt(0);
            String intitule = result.getString(1);
            String type = result.getString(2);
            String dateDebut = result.getString(3);
            String dateFin = result.getString(4);
            int accomplissement = result.getInt(5);
            String mCommentaire = result.getString(6);

            ObjectifPersonnel obj = new ObjectifPersonnel(id, intitule, type, dateDebut, dateFin, mCommentaire, accomplissement);

            liste_objectifs_perso_att.add(obj);
        }

        result.close();
        return liste_objectifs_perso_att;
    }

    public ArrayList<ObjectifPartage> getObjectifsPartagesAtteint() {

        liste_objectifs_part_att = new ArrayList<>();

        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME_BD_OBJ + " where " + col_type_obj + " = 'partage'" + " AND " + col_accomplissement + "=10 ", null);

        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            int id = result.getInt(0);
            String intitule = result.getString(1);
            String type = result.getString(2);
            String dateDebut = result.getString(3);
            String dateFin = result.getString(4);
            int accomplissement = result.getInt(5);
            String mCommentaire = result.getString(6);
            String pro = result.getString(7);

            ObjectifPartage obj = new ObjectifPartage(id, intitule, type, dateDebut, dateFin, mCommentaire, accomplissement, pro);

            liste_objectifs_part_att.add(obj);
        }

        result.close();
        return liste_objectifs_part_att;
    }

    public ObjectifPersonnel getObjectifPerso(int id) {
        String requete = "select * from " + TABLE_NAME_BD_OBJ + " where " + col_id_obj + " = " + id;

        Cursor result = this.getWritableDatabase().rawQuery(requete, null);

        result.moveToFirst();

        int idobj = result.getInt(0);
        String intitule = result.getString(1);
        String type = result.getString(2);
        String datedebut = result.getString(3);
        String datefin = result.getString(4);
        int accomplissement = result.getInt(5);
        String comm = result.getString(6);

        ObjectifPersonnel obj = new ObjectifPersonnel(idobj, intitule, type, datedebut, datefin, comm, accomplissement);
        result.close();
        return obj;
    }


    public boolean modifierObjPerso(int id, String intitule, String type, String dateDebut, String dateFin, String commentaire, int accomplissement) {

        ContentValues cv = new ContentValues();
        cv.put(col_intitule, intitule);
        cv.put(col_type_obj, type);
        cv.put(col_date_debut, dateDebut);
        cv.put(col_date_fin, dateFin);
        cv.put(col_accomplissement, accomplissement);

        if (intitule.isEmpty()) {
            return false;
        }

        if (type.isEmpty()) {
            return false;
        }

        if (dateDebut.isEmpty()) {
            return false;
        }

        if (dateFin.isEmpty()) {
            return false;
        }

        if (commentaire.isEmpty()) {
            cv.put(col_Commentaire, "Aucun");
        } else {
            cv.put(col_Commentaire, commentaire);
        }

        long result = this.getWritableDatabase().update(TABLE_NAME_BD_OBJ, cv, col_id_obj + "= ?", new String[]{String.valueOf(id)});

        if (result == -1) {
            return false;
        } else {
            System.out.println("Objectif ajouté");
            return true;
        }

    }

    public ObjectifPartage getObjectifPartage(int id) {
        String requete = "select * from " + TABLE_NAME_BD_OBJ + " where " + col_id_obj + " = " + id;

        Cursor result = this.getWritableDatabase().rawQuery(requete, null);

        result.moveToFirst();

        int idobj = result.getInt(0);
        String intitule = result.getString(1);
        String type = result.getString(2);
        String datedebut = result.getString(3);
        String datefin = result.getString(4);
        int accomplissement = result.getInt(5);
        String comm = result.getString(6);
        String pro = result.getString(7);

        ObjectifPartage obj = new ObjectifPartage(idobj, intitule, type, datedebut, datefin, comm, accomplissement,pro);
        result.close();
        return obj;
    }

    public boolean modifierObjPartage(int id, String intitule, String type, String dateDebut, String dateFin, String commentaire, int accomplissement, String pro) {

        ContentValues cv = new ContentValues();
        cv.put(col_intitule, intitule);
        cv.put(col_type_obj, type);
        cv.put(col_date_debut, dateDebut);
        cv.put(col_date_fin, dateFin);
        cv.put(col_accomplissement, accomplissement);
        cv.put(col_professionnel, pro);

        if (intitule.isEmpty()) {
            return false;
        }

        if (type.isEmpty()) {
            return false;
        }

        if (dateDebut.isEmpty()) {
            return false;
        }

        if (dateFin.isEmpty()) {
            return false;
        }

        if (pro.isEmpty()) {
            return false;
        }

        if (commentaire.isEmpty()) {
            cv.put(col_Commentaire, "Aucun");
        } else {
            cv.put(col_Commentaire, commentaire);
        }

        long result = this.getWritableDatabase().update(TABLE_NAME_BD_OBJ, cv, col_id_obj + "= ?", new String[]{String.valueOf(id)});

        if (result == -1) {
            return false;
        } else {
            System.out.println("Objectif modifié");
            return true;
        }

    }


    public ArrayList<Objectifs> getObjectifsAtteints() {

        ArrayList<Objectifs> liste_objectifs_att = new ArrayList<Objectifs>();

        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME_BD_OBJ + " where " + col_accomplissement + "=10 ", null);

        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            int id = result.getInt(0);
            String intitule = result.getString(1);
            String type = result.getString(2);
            String dateDebut = result.getString(3);
            String dateFin = result.getString(4);
            int accomplissement = result.getInt(5);
            String mCommentaire = result.getString(6);

           if (!result.isNull(7)) {
               String pro = result.getString(7);
               Objectifs obj = new ObjectifPartage(id,intitule,type,dateDebut,dateFin,mCommentaire,accomplissement,pro);
               liste_objectifs_att.add(obj);
           }
           else {
               Objectifs obj = new ObjectifPersonnel(id,intitule,type,dateDebut,dateFin,mCommentaire,accomplissement);
               liste_objectifs_att.add(obj);
           }

        }

        result.close();
        return liste_objectifs_att;
    }

    public boolean supprimerObj(int idContact) {

        int nombre = this.getWritableDatabase().delete(TABLE_NAME_BD_OBJ, col_id_obj + "=?", new String[]{String.valueOf(idContact)});

        if (nombre == 1) {
            return true;
        } else {
            return false;
        }
    }
}