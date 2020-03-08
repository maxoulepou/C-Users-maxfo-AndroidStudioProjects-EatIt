package Contacts;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable {

    private String nom, prenom, profession, email, numTel, adresse;
    private int idContact;

    public Contact(String nom, String prenom, String profession, String email, String numTel, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.profession = profession;
        this.email = email;
        this.numTel = numTel;
        this.adresse = adresse;
    }

    public Contact(int idContact, String nom, String prenom, String profession, String email, String numTel, String adresse) {
        this.idContact = idContact;
        this.nom = nom;
        this.prenom = prenom;
        this.profession = profession;
        this.email = email;
        this.numTel = numTel;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getIdContact(){return idContact;}


    public Contact(Parcel in) {
        String[] data = new String[7];
        in.readStringArray(data);
        this.nom = data[0];
        this.prenom = data[1];
        this.profession = data[2];
        this.email = data[3];
        this.numTel = data[4];
        this.adresse = data[5];
        this.idContact = Integer.parseInt(data[6]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.nom, this.prenom, this.profession, this.email, this.numTel, this.adresse, String.valueOf(this.idContact)});
    }

    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);  //using parcelable constructor
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}



