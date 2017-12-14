/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetfestivaljava;

import controleur.CtrlMenu;
import controleur.CtrlPrincipal;
import controleur.CtrlRepresentation;
import controleur.CtrlReservation;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.Jdbc;
import vue.VueMenu;
import vue.VueRepresentation;
import vue.VueReservation;

/**
 *
 * @author rdemazeau
 */
public class ProjetFestivalJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festival", "root", "joliverie");
        try {
            Jdbc.getInstance().connecter();
            CtrlPrincipal leControleurPrincipal = new CtrlPrincipal();
            VueMenu leMenu = new VueMenu();
            CtrlMenu ctrlLeMenu = new CtrlMenu(leMenu, leControleurPrincipal);
            VueRepresentation laRepreesentation = new VueRepresentation();
            CtrlRepresentation ctrlLaRepresentation = new CtrlRepresentation(laRepreesentation, leControleurPrincipal);
            VueReservation laReservation = new VueReservation();
            CtrlReservation ctrlLaReservation = new CtrlReservation(laReservation, leControleurPrincipal);
            leControleurPrincipal.setCtrlMenu(ctrlLeMenu);
            leControleurPrincipal.setCtrlRepresentation(ctrlLaRepresentation);
            leControleurPrincipal.setCtrlReservation(ctrlLaReservation);
            leMenu.setVisible(true);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }
        
    }
    
}
