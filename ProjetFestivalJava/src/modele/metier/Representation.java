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
    private String Lieu;
    private String Groupe;
    private String heureDebut;
    private String heureFin;
    private int placesDispo;
    
    
    //constructeur
    public Representation(int id,String date,String Lieu,String Groupe,String heureDebut,String heureFin,int placesDispo){
    
    this.id=id;
    this.date=date;
    this.Lieu=Lieu;
    this.Groupe=Groupe;
    this.heureDebut=heureDebut;
    this.heureFin=heureFin;
    this.placesDispo=placesDispo;
   
    }

    //toString
    @Override
    public String toString() {
        return "Representation{ date=" + date + ", Lieu=" + Lieu + ", Groupe=" + Groupe + ", heureDebut=" + heureDebut + ", heureFin=" + heureFin + ", placesDispo=" + placesDispo + '}';
    }
    
    
    
    
    //accesseur
    
        public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getLieu() {
        return Lieu;
    }

    public String getGroupe() {
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

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }

    public void setGroupe(String Groupe) {
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
