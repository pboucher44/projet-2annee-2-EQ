/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author Unknow
 */
public class Lieu {
    private int id;
    private String nom;
    private String adresse;
    private int capaciteAccueil;

    public Lieu(int id, String nom, String adresse, int capaciteAccueil) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.capaciteAccueil = capaciteAccueil;
    }

    @Override
    public String toString() {
        return "Lieu{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", capaciteAccueil=" + capaciteAccueil + '}';
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCapaciteAccueil() {
        return capaciteAccueil;
    }

    public void setCapaciteAccueil(int capaciteAccueil) {
        this.capaciteAccueil = capaciteAccueil;
    }
    
    
}
