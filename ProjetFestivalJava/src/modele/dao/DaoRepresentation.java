/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import modele.metier.Representation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Jdbc;
import modele.metier.Groupe;
import modele.metier.Lieu;

/**
 *
 * @author tberthome
 */
public class DaoRepresentation {
    
 
       
    public static List<Representation> selectAll() throws SQLException {
        List<Representation> lesRepresentation = new ArrayList<Representation>();
        Representation uneRepresentation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT id, `date`, Lieu, Groupe, `heuredebut`, `heurefin`, `places_dispo` FROM `Representation`";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String date = rs.getString("date");
            String Lieu = rs.getString("Lieu");
            Lieu VraiLieu = DaoLieu.selectLieuById(Lieu);
            String Groupe = rs.getString("Groupe");
            Groupe VraiGroupe = DaoGroupe.selectGroupeById(Groupe);
            String heureDebut = rs.getString("heureDebut");
            String heureFin = rs.getString("heureFin");
            int placesDispo = rs.getInt("places_dispo");
            uneRepresentation = new Representation(id, date, VraiLieu,VraiGroupe,heureDebut,heureFin,placesDispo);
            lesRepresentation.add(uneRepresentation);
        }
        return lesRepresentation;
    }
    
    public static Representation selectRepresentationParGroupe(String idGroupe) throws SQLException {
        Representation uneRepresentation = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT id, `date`, Lieu, Groupe, `heuredebut`, `heurefin`, `places_dispo` FROM `Representation` WHERE Groupe=\""+idGroupe+"\"";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            String date = rs.getString("date");
            String Lieu = rs.getString("Lieu");
            Lieu VraiLieu = DaoLieu.selectLieuById(Lieu);
            String Groupe = rs.getString("Groupe");
            Groupe VraiGroupe = DaoGroupe.selectGroupeById(Groupe);
            String heureDebut = rs.getString("heureDebut");
            String heureFin = rs.getString("heureFin");
            int placesDispo = rs.getInt("places_dispo");
            uneRepresentation = new Representation(id, date, VraiLieu,VraiGroupe,heureDebut,heureFin,placesDispo);
        }
        return uneRepresentation;
    }
    
    public static void vendrePlace(int nombreVendu, String id) throws SQLException {
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "UPDATE Representation SET places_dispo = places_dispo -"+ nombreVendu +" where groupe='" + id + "'";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.executeUpdate();
    }
    
    
}
