/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.Jdbc;
import modele.metier.Groupe;
import modele.metier.Lieu;

/**
 *
 * @author Unknow
 */
public class DaoGroupe {
    public static Groupe selectGroupeById(String idGroupe) throws SQLException {
        
        Groupe unGroupe = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT id,nom,nombrePersonnes,nomPays,hebergement FROM `Groupe` WHERE id=\""+idGroupe + "\"";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String id = rs.getString("id");
            String nom = rs.getString("nom");
            int nombrePersonnes = rs.getInt("nombrePersonnes");
            String nomPays = rs.getString("nomPays");
            String hebergement = rs.getString("hebergement");
            unGroupe = new Groupe(id,nom,nombrePersonnes,nomPays,hebergement);
        }
        return unGroupe;
    }
    
    public static String selectIdGroupeByNom(String nomGroupe) throws SQLException {
        
        String idGroupe = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT id FROM `Groupe` WHERE nom=\""+nomGroupe + "\"";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            idGroupe = rs.getString("id");
        }
        return idGroupe;
    }
}
