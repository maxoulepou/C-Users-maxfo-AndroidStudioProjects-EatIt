package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BD_Repas extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mesRepas.bd";
    public static final String TABLE_NAME = "table_repas";
    public static final String col_idRepas = "idRepas";
    public static final String col_Date = "Date";
    public static final String col_Duree = "Duree";
    public static final String col_Niv_faim = "Niveau_faim";
    public static final String col_Niv_envie = "Niveau_envie";
    public static final String col_Niv_satiete = "Niveau_satiete";
    public static final String col_Contexte_repas = "Contexte_repas";
    public static final String col_Commentaire = "Commentaire";
    public static final String col_Type_Repas = "Type_Repas";
    public static final String col_Heure = "Heure";
    private ArrayList<Repas> lRepas;
    private SimpleDateFormat sdf;
    private String formatedDate;

    public BD_Repas(@Nullable Context context){
        super(context, DATABASE_NAME, null, 1);

    }

    public void onCreate(SQLiteDatabase db){
        //    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strSQL = "create table " + TABLE_NAME +"("
                + col_idRepas + " integer primary key autoincrement, "
                + col_Type_Repas + " text not null, "
                + col_Date + " text not null, "
                + col_Heure + " text not null, "
                + col_Duree + " text, "
                + col_Niv_faim + " text, "
                + col_Niv_envie + " text, "
                + col_Niv_satiete + " text, "
                + col_Contexte_repas + " text, "
                + col_Commentaire + " text)";
        db.execSQL(strSQL);
        System.out.println("BD_Repas créée");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addRepas (String date, String heure, String duree, int nivFaim, int nivEnvie, int nivSatiete, int contexteRepas, String commentaire, String repas){
        ContentValues cv = new ContentValues();

        cv.put(col_Date, date);
        cv.put(col_Heure, heure);
        cv.put(col_Duree, duree);
        cv.put(col_Niv_faim, nivFaim);
        cv.put(col_Niv_envie, nivEnvie);
        cv.put(col_Niv_satiete, nivSatiete);
        cv.put(col_Contexte_repas, contexteRepas);
        cv.put(col_Commentaire, commentaire);
        cv.put(col_Type_Repas, repas);

        long result = this.getWritableDatabase().insert(TABLE_NAME, null, cv);

        if (date.isEmpty()) {
            return false;
        }
        if (heure.isEmpty()) {
            return false;
        }
        if (result == -1){
            return false;
        } else {
            System.out.println("addRepas fonctionne");
            return true;
        }
    }


    public ArrayList<Repas> getlRepas(){
        lRepas = new ArrayList<>();
        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME, null);
        while (!result.isAfterLast()) {
            String mRepas = result.getString(1);
            String mDate = result.getString(2);
            String mHeure = result.getString(3);
            String mDuree = result.getString(4);
            String mNivFaim = result.getString(5);
            String mNivEnvie = result.getString(6);
            String mNivSatiete = result.getString(7);
            String mContexteRepas = result.getString(8);
            String mCommentaire = result.getString(9);

            Repas r = new Repas(mDate, mHeure, mDuree,  mNivFaim, mNivEnvie, mNivSatiete, mContexteRepas, mRepas, mCommentaire);

            lRepas.add(r);
            result.moveToNext();
        }
        result.close();
        return lRepas;
    }

    public ArrayList<Repas> getlRepasDate(String date){
        lRepas = new ArrayList<>();
        Cursor result = this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME + " where " + col_Date + " = '" + date +"'", null);
        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()){
            String mRepas = result.getString(1);
            String mDate = result.getString(2);
            String mHeure = result.getString(3);
            String mDuree = result.getString(4);
            String mNivFaim = result.getString(5);
            String mNivEnvie = result.getString(6);
            String mNivSatiete = result.getString(7);
            String mContexteRepas = result.getString(8);
            String mCommentaire = result.getString(9);

            Repas r = new Repas(mDate, mHeure, mDuree,  mNivFaim, mRepas, mCommentaire, mNivEnvie, mNivSatiete, mContexteRepas);

            lRepas.add(r);
            System.out.println("addRepasDate fonctionne");
        }
        result.close();
        return lRepas;
    }

}
