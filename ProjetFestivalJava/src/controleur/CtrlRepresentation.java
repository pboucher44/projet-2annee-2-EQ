/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package controleur;

import java.awt.List;
import java.awt.event.WindowEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowEvent;
import modele.dao.DaoRepresentation;
import modele.metier.Representation;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import vue.VueRepresentation;


/**
 *
 * @author pboucher
 */
public class CtrlRepresentation implements WindowListener{

    private vue.VueRepresentation reserv;
    private List lesRepresentations;
    
    public CtrlRepresentation(vue.VueRepresentation vue){
        this.reserv=vue;
        this.reserv.addWindowListener(this);
        afficheLesReserv();
    }
    
    private void afficheLesReserv() {
        lesRepresentations=DaoRepresentation.selectAll();
        for (Reservation uneRepresentation : lesRepresentations){
            this.reserv.setjComboBox1(uneRepresentation.getLibelle);
        }
    }
    
    
    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
