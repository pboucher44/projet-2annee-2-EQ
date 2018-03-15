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
import modele.dao.DaoLieu;
import modele.dao.DaoRepresentation;
import modele.metier.Representation;

/**
 *
 * @author pboucher
 */
public class testRepresentation {
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
        System.out.println("test création d'un objet de type representation:");
        System.out.println("***************************************************");
        Representation laRepresentation = null;
        try {
            laRepresentation = new Representation(1,"2017-07-11",DaoLieu.selectLieuById("1"),DaoGroupe.selectGroupeById("g001"),"21:45:00","23:00:00",500,500);
        } catch (SQLException ex) {
            Logger.getLogger(testRepresentation.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(laRepresentation.toString());
        System.out.println("test réussi");
    }
}
