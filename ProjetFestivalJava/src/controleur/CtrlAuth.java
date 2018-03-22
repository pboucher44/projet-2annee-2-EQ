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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vue.VueAuthentification;

/**
 *
 * @author tberthome
 */
public class CtrlAuth implements WindowListener,ActionListener{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    private vue.VueAuthentification auth;
    private CtrlPrincipal ctrlPrincipal;
    
    
    public CtrlAuth (vue.VueAuthentification vue, CtrlPrincipal ctrl){
        this.auth=vue;
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

    public VueAuthentification getAuth() {
        return auth;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.auth.getjButton1())){
            
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
                            } catch (IOException e1) {
                                    e1.printStackTrace();
                            }
                    }
            }
            
            
            try {
                String identifiant = this.auth.getjTextField1().getText();
                String mdp = this.auth.getjTextField2().getText();
                
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(identifiant.getBytes());
                byte[] digest = md.digest();
                StringBuffer sb = new StringBuffer();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                
                MessageDigest md2 = MessageDigest.getInstance("MD5");
                md2.update(mdp.getBytes());
                byte[] digest2 = md2.digest();
                StringBuffer sb2 = new StringBuffer();
                for (byte b : digest2) {
                    sb2.append(String.format("%02x", b & 0xff));
                }
                
                if(prop.getProperty("identifiant").equals(sb.toString()) && prop.getProperty("mdp").equals(sb2.toString())){
                    ctrlPrincipal.afficherLesReservation();
                }else {
                    JOptionPane.showMessageDialog(null, "Mauvais identifiants !");
                }                
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CtrlAuth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(this.auth.getjButton2())){
            ctrlPrincipal.afficherLeMenu();
        }
    }
}
