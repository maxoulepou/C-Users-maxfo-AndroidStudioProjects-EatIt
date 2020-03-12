package Model;

import java.util.ArrayList;
import java.util.Date; //possible import java.sql, à voir si il y a une différence

public class Patient {

    private long id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String sexe; // restriction homme femme à faire
    private String email;
    private String adresse, ville, contactUrgence;
    private String mdp;
    private int codePostal;
    private ArrayList<Repas> lCarnetRepas;
    private ArrayList<Intervention> lIntervention;
    private ArrayList<Contact> lContact;
    private ArrayList<Objectifs> lObjectif;
    private ArrayList<Ressenti> lCarnetEmotion;
    private ArrayList<Poids> lPoids;


    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Patient(String email, String mdp, String nom, String prenom, String sexe, String dateN){ //peut etre ajouter des parametres, a voir lors de la creation du controlleur
        super();
        this.email = email;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateN;
    }

    public Patient(String email, String nom, String prenom, String sexe, String dateN, String ville, String adresse, String codePostal, String NumUrgence){ //peut etre ajouter des parametres, a voir lors de la creation du controlleur
        super();
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateN;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getContactUrgence() {
        return contactUrgence;
    }

    public void setContactUrgence(String contactUrgence) {
        this.contactUrgence = contactUrgence;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public ArrayList getlIntervention() {
        return lIntervention;
    }

    public void setlIntervention(ArrayList<Intervention> lIntervention) {
        this.lIntervention = lIntervention;
    }

    public ArrayList getlContact() {
        return lContact;
    }

    public void setlContact(ArrayList<Contact> lContact) {
        this.lContact = lContact;
    }

    public ArrayList getlObjectif() {
        return lObjectif;
    }

    public void setlObjectif(ArrayList<Objectifs> lObjectif) {
        this.lObjectif = lObjectif;
    }

    public ArrayList getlCarnetRepas() {
        return lCarnetRepas;
    }

    public void setlCarnetRepas(ArrayList<Repas> lCarnetRepas) {
        this.lCarnetRepas = lCarnetRepas;
    }

    public ArrayList getlCarnetEmotion() {
        return lCarnetEmotion;
    }

    public void setlCarnetEmotion(ArrayList<Ressenti> lCarnetEmotion) {
        this.lCarnetEmotion = lCarnetEmotion;
    }

    public ArrayList getlPoids() {
        return lPoids;
    }

    public void setlPoids(ArrayList<Poids> lPoids) {
        this.lPoids = lPoids;
    }
}
