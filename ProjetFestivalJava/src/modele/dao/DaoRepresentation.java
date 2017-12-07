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
        String requete = "SELECT Representation.id AS id, `date`, Lieu.nom AS Lieu, Groupe.nom AS Groupe, `heuredebut`, `heurefin`, `places_dispo` FROM `Representation` INNER JOIN Groupe ON Groupe.id = Representation.Groupe INNER JOIN Lieu ON Lieu.id = Representation.Lieu";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String date = rs.getString("date");
            String Lieu = rs.getString("Lieu");
            String Groupe = rs.getString("Groupe");
            String heureDebut = rs.getString("heureDebut");
            String heureFin = rs.getString("heureFin");
            int placesDispo = rs.getInt("places_dispo");
            uneRepresentation = new Representation(id, date, Lieu,Groupe,heureDebut,heureFin,placesDispo);
            lesRepresentation.add(uneRepresentation);
        }
        return lesRepresentation;
    }
    
    
    
        public static void reserve(int id, int nbPers) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE `Representation` SET `places_dispo`=places_dispo-"+ nbPers +" WHERE id="+ id + ";";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        nb = pstmt.executeUpdate();
    }
        
      
    
}
