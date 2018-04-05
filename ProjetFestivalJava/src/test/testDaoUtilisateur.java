/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.Jdbc;
import modele.dao.DaoUtilisateur;
import modele.metier.Utilisateur;

/**
 *
 * @author Unknow
 */
public class testDaoUtilisateur {
    public static void main(String args[]) throws SQLException{
        try {
            Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festival", "root", "joliverie");
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testDaoRepresentation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testDaoRepresentation.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
        System.out.println("***************************************************");
        System.out.println("test 1 selectUtilByPseudo():");
        System.out.println("***************************************************");
        try {
            Utilisateur leUtil = null;
            leUtil = DaoUtilisateur.selectUtilByPseudo("btssio");
            System.out.println(leUtil.toString());
            
            System.out.println("test 1 réussi");
        } catch (SQLException ex) {
            System.out.println("test 1 échoué");
        }
    }
}
