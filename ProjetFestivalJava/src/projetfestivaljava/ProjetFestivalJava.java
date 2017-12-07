/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetfestivaljava;

import controleur.CtrlRepresentation;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.Jdbc;

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
            vue.VueRepresentation uneVue = new vue.VueRepresentation();
            controleur.CtrlRepresentation unControleur = new controleur.CtrlRepresentation(uneVue);
            // afficher la vue
            uneVue.setVisible(true);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }
        
    }
    
}
