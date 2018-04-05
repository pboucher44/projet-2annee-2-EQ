/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetfestivaljava;

import controleur.CtrlAuth;
import controleur.CtrlMenu;
import controleur.CtrlPrincipal;
import controleur.CtrlRepresentation;
import controleur.CtrlReservation;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.Jdbc;
import vue.VueMenu;
import vue.VueRepresentation;
import vue.VueReservation;
import java.util.Properties;
import vue.VueAuthentification;

/**
 *
 * @author rdemazeau
 */
public class ProjetFestivalJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Properties prop = new Properties();
	InputStream input = null;

	try {

		input = new FileInputStream("src/config/config.properties");

		// load a properties file
		prop.load(input);

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        
        
        
        
        
        
        Jdbc.creer(prop.getProperty("jdbcDriver"), prop.getProperty("typeBdd"), prop.getProperty("localisation"), prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
        try {
            Jdbc.getInstance().connecter();
            CtrlPrincipal leControleurPrincipal = new CtrlPrincipal();
            
            VueMenu leMenu = new VueMenu();
            CtrlMenu ctrlLeMenu = new CtrlMenu(leMenu, leControleurPrincipal);   
            
            VueAuthentification lauth = new VueAuthentification();            
            CtrlAuth ctrlAuthentification = new CtrlAuth(lauth, leControleurPrincipal);
            
            VueRepresentation laRepreesentation = new VueRepresentation();            
            CtrlRepresentation ctrlLaRepresentation = new CtrlRepresentation(laRepreesentation, leControleurPrincipal);
            
            VueReservation laReservation = new VueReservation();
            CtrlReservation ctrlLaReservation = new CtrlReservation(laReservation, leControleurPrincipal);
            
            leControleurPrincipal.setCtrlMenu(ctrlLeMenu);
            leControleurPrincipal.setCtrlRepresentation(ctrlLaRepresentation);
            leControleurPrincipal.setCtrlReservation(ctrlLaReservation);
            leControleurPrincipal.setCtrlAuth(ctrlAuthentification);
            leMenu.setVisible(true);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }
        
    }
    
}
