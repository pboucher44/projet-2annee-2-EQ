/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdbc.Jdbc;
import vue.VueAuthentificationDistante;
import modele.dao.DaoUtilisateur;
import modele.metier.Utilisateur;

/**
 *
 * @author tberthome
 */
public class CtrlAuthDistant implements WindowListener, ActionListener {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    private vue.VueAuthentificationDistante auth;
    private CtrlPrincipal ctrlPrincipal;

    public CtrlAuthDistant(vue.VueAuthentificationDistante vue, CtrlPrincipal ctrl) {
        this.auth = vue;
        this.auth.addWindowListener((WindowListener) this);
        this.auth.getjButton1().addActionListener((ActionListener) this);
        this.auth.getjButton2().addActionListener((ActionListener) this);
        this.ctrlPrincipal = ctrl;
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ctrlPrincipal.quitterApplication();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    public VueAuthentificationDistante getAuthDist() {
        return auth;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.auth.getjButton1())) {
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
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            try {
                Jdbc.getInstance().deconnecter();
                Jdbc.getInstance().setServeurBd(prop.getProperty("localisationOnline"));
                Jdbc.getInstance().connecter();
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Main - échec de connexion");
            }

            String identifiant = this.auth.getjTextField1().getText();
            String mdp = this.auth.getjTextField2().getText();

            if (identifiant.equals("") || mdp.equals("")) {
                JOptionPane.showMessageDialog(null, "entrez un couple identifiant / mot de passe !");
            } else {
                try {
                    Utilisateur unUtil = DaoUtilisateur.selectUtilByPseudoOnline(identifiant);
                    if (unUtil == null) {
                        JOptionPane.showMessageDialog(null, "Mauvais identifiants !");
                    } else {
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        md.update(mdp.getBytes());
                        byte[] digest = md.digest();
                        StringBuffer sb = new StringBuffer();
                        for (byte b : digest) {
                            sb.append(String.format("%02x", b & 0xff));
                        }

                        if (unUtil.getMdp().equals(sb.toString())) {
                            JOptionPane.showMessageDialog(null, "connecté a la base en ligne");
                            Jdbc.getInstance().deconnecter();
                            Jdbc.getInstance().setServeurBd(prop.getProperty("localisation"));
                            Jdbc.getInstance().connecter();
                            ctrlPrincipal.afficherLeMenu();
                        } else {
                            JOptionPane.showMessageDialog(null, "Mauvais identifiants !");
                        }
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(CtrlAuthDistant.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlAuthDistant.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                   Logger.getLogger(CtrlAuthDistant.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        } else if (e.getSource().equals(this.auth.getjButton2())) {
            ctrlPrincipal.afficherLeMenu();
        }
    }

}
