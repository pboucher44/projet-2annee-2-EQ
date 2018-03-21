/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.Jdbc;
import modele.metier.Lieu;
import modele.metier.Representation;

/**
 *
 * @author Unknow
 */
public class DaoLieu {
    public static Lieu selectLieuById(String idLieu) throws SQLException {
        
        Lieu unLieu = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM `lieu` WHERE id=\""+idLieu + "\"";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String adresse = rs.getString("adresse");
            int capaciteAccueil = rs.getInt("capaciteAccueil");
            unLieu = new Lieu(id,nom,adresse,capaciteAccueil);
        }
        return unLieu;
    }
}
