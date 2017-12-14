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
public class Groupe {
    private String id;
    private String nom;
    private int nombrePersonnes;
    private String nomPays;
    private String hebergement;

    public Groupe(String id, String nom, int nombrePersonnes, String nomPays, String hebergement) {
        this.id = id;
        this.nom = nom;this.nombrePersonnes = nombrePersonnes;
        this.nomPays = nomPays;
        this.hebergement = hebergement;
    }

    @Override
    public String toString() {
        return "Groupe{" + "id=" + id + ", nom=" + nom + ", nombrePersonnes=" + nombrePersonnes + ", nomPays=" + nomPays + ", hebergement=" + hebergement + '}';
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombrePersonnes() {
        return nombrePersonnes;
    }

    public void setNombrePersonnes(int nombrePersonnes) {
        this.nombrePersonnes = nombrePersonnes;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public String getHebergement() {
        return hebergement;
    }

    public void setHebergement(String hebergement) {
        this.hebergement = hebergement;
    }
    
}
