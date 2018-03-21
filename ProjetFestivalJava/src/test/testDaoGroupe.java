/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.Jdbc;
import modele.dao.DaoGroupe;
import modele.metier.Groupe;

/**
 *
 * @author Unknow
 */
public class testDaoGroupe {
    public static void main(String args[]){
        try {
            Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festival", "root", "joliverie");
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testDaoRepresentation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testDaoRepresentation.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
        System.out.println("***************************************************");
        System.out.println("test 1 selectGroupeById():");
        System.out.println("***************************************************");
        try {
            Groupe leGroupe = null;
            leGroupe = DaoGroupe.selectGroupeById("g019");
            System.out.println(leGroupe.toString());
            
            System.out.println("test 1 réussi");
        } catch (SQLException ex) {
            System.out.println("test 1 échoué");
        }
        
        System.out.println("***************************************************");
        System.out.println("test 2 selectIdGroupeByNom():");
        System.out.println("***************************************************");
        try {
            String leGroupe = null;
            leGroupe = DaoGroupe.selectIdGroupeByNom("Ruhunu Ballet du village de Kosgoda");
            System.out.println(leGroupe);
            
            System.out.println("test 2 réussi");
        } catch (SQLException ex) {
            System.out.println("test 2 échoué");
        } 
    }
}
