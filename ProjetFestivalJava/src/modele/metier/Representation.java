package modele.metier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tberthome
 */
public class Representation {
   
    private int id;
    private String date;
    private Lieu Lieu;
    private Groupe Groupe;
    private String heureDebut;
    private String heureFin;
    private int placesTot;
    private int placesDispo;
    
    
    //constructeur
    public Representation(int id,String date,Lieu Lieu,Groupe Groupe,String heureDebut,String heureFin,int placesTot, int placesDispo){
    
    this.id=id;
    this.date=date;
    this.Lieu=Lieu;
    this.Groupe=Groupe;
    this.heureDebut=heureDebut;
    this.heureFin=heureFin;
    this.placesDispo=placesDispo;
    this.placesTot=placesTot;
    
    }

    //toString
    @Override
    public String toString() {
        return "<html>Groupe=" + Groupe.getNom()+"<br> date=" + date + "<br> Lieu=" + Lieu.getNom()+ "<br> heureDebut=" + heureDebut + "<br> heureFin=" + heureFin + "<br> place total=" + placesTot + "<br> place Disponible=" + placesDispo + "</html>";
    }
    
    
    //accesseur
    
        public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public modele.metier.Lieu getLieu() {
        return Lieu;
    }

    public modele.metier.Groupe getGroupe() {
        return Groupe;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public int getPlacesDispo() {
        return placesDispo;
    }

    
    
    
    
    
    //mutateur
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLieu(Lieu Lieu) {
        this.Lieu = Lieu;
    }

    public void setGroupe(Groupe Groupe) {
        this.Groupe = Groupe;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public void setPlacesDispo(int placesDispo) {
        this.placesDispo = placesDispo;
    }
    
    
    
    
    
    
    
    
}
