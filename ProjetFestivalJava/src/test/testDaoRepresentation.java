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
import modele.dao.DaoRepresentation;
import modele.metier.Representation;

/**
 *
 * @author pboucher
 */
public class testDaoRepresentation {
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
        System.out.println("test 1 selectAll():");
        System.out.println("***************************************************");
        try {
            List<Representation> lesRepresentation = new ArrayList<Representation>();
            lesRepresentation = DaoRepresentation.selectAll();
            for(Representation uneRepresentation : lesRepresentation){
                System.out.println(uneRepresentation.toString());
            }
            System.out.println("test 1 réussi");
        } catch (SQLException ex) {
            System.out.println("test 1 échoué");
        }
        System.out.println("***************************************************");
        System.out.println("test 2 selectRepresentationParGroupe():");
        System.out.println("***************************************************");
        try {
            Representation RecupParGroupe;
            RecupParGroupe = DaoRepresentation.selectRepresentationParGroupe("Boxty");
            System.out.println(RecupParGroupe.toString());
            System.out.println("test 2 réussi");
        } catch (SQLException ex) {
            System.out.println("test 2 échoué");
        }
        
    }
}
