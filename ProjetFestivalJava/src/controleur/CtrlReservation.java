/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modele.dao.DaoRepresentation;
import modele.metier.Representation;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modele.dao.DaoGroupe;
import vue.VueRepresentation;
import vue.VueReservation;

/**
 *
 * @author Unknow
 */
public class CtrlReservation implements WindowListener,MouseListener,ActionListener{
    private vue.VueReservation reserv;
    private ArrayList<Representation> lesRepresentations;
    private CtrlPrincipal ctrlPrincipal;
    
    public CtrlReservation(vue.VueReservation vue, CtrlPrincipal ctrl){
        this.reserv=vue;
        this.reserv.addWindowListener(this);
        this.reserv.getjTable1().addMouseListener(this);
        this.reserv.getjButton2().addActionListener(this);
        this.reserv.getjButton1().addActionListener(this);
        this.ctrlPrincipal = ctrl;
        afficheLesReserv();
    }
    private void afficheLesReserv() {
        try {
            lesRepresentations= (ArrayList<Representation>) DaoRepresentation.selectAll();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlRepresentation.class.getName()).log(Level.SEVERE, null, ex);
        }
        JTable jtable1 = this.reserv.getjTable1();
        DefaultTableModel model = (DefaultTableModel) jtable1.getModel();
        
        for (Representation uneRepresentation : lesRepresentations){
            model.addRow(new Object[]{uneRepresentation.getGroupe().getNom()});
        }
        
        this.reserv.setjTable1(jtable1);
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

    public VueReservation getReserv() {
        return reserv;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = reserv.getjTable1().getSelectedRow();
        String groupeChoisis = (String) reserv.getjTable1().getValueAt(row, 0);
        String groupeChoisisRes = null;
        String idGroupeChoisis=null;
        try {
            idGroupeChoisis=DaoGroupe.selectIdGroupeByNom(groupeChoisis);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlRepresentation.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            groupeChoisisRes=DaoRepresentation.selectRepresentationParGroupe(idGroupeChoisis).toString();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlRepresentation.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Date currentTime = new Date();
            String dateDebut = DaoRepresentation.selectRepresentationParGroupe(idGroupeChoisis).getDate();
            String heureDebut = DaoRepresentation.selectRepresentationParGroupe(idGroupeChoisis).getHeureDebut();
            int annee = Integer.parseInt(dateDebut.substring(0,4));
            int mois = Integer.parseInt(dateDebut.substring(5,7));
            int jour = Integer.parseInt(dateDebut.substring(8,10));
            int heure = Integer.parseInt(heureDebut.substring(0,2));
            int minutes = Integer.parseInt(heureDebut.substring(3,5));
            
            Date dateConcert = new Date(annee-1900, mois, jour,heure,minutes);
            if(DaoRepresentation.selectRepresentationParGroupe(idGroupeChoisis).getPlacesDispo()==0 && dateConcert.before(currentTime)){
                reserv.getjLabel3().setText("Le concert est passé");
                this.reserv.getjButton1().setEnabled(false);
            }else if(dateConcert.before(currentTime)){
                reserv.getjLabel3().setText("Le concert est passé");
                this.reserv.getjButton1().setEnabled(false);
            }else if(DaoRepresentation.selectRepresentationParGroupe(idGroupeChoisis).getPlacesDispo()==0){
                reserv.getjLabel3().setText("Il n'y a plus de places");
                this.reserv.getjButton1().setEnabled(false);
            }else{
                reserv.getjLabel3().setText("");
                this.reserv.getjButton1().setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlRepresentation.class.getName()).log(Level.SEVERE, null, ex);
        }
        reserv.getjLabel2().setText(groupeChoisisRes);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.reserv.getjButton2())){
            ctrlPrincipal.afficherLeMenu();
        }else if(e.getSource().equals(this.reserv.getjButton1())){
            int row = reserv.getjTable1().getSelectedRow();
            String groupeChoisis = (String) reserv.getjTable1().getValueAt(row, 0);
                
            String nbPlacesAEnlever = this.reserv.getjTextField2().getText();
            int nbPlacesDisp=0;
            String idGroupeChoisis = null;
            try {
                idGroupeChoisis = DaoGroupe.selectIdGroupeByNom(groupeChoisis);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlReservation.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                nbPlacesDisp=DaoRepresentation.selectRepresentationParGroupe(idGroupeChoisis).getPlacesDispo();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlReservation.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(nbPlacesDisp-Integer.parseInt(nbPlacesAEnlever)>=0){
                try {
                        DaoRepresentation.vendrePlace(Integer.parseInt(nbPlacesAEnlever) ,DaoGroupe.selectIdGroupeByNom(groupeChoisis));
                        JOptionPane.showMessageDialog(null, "Les places sont bien réservées !");
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlReservation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Pas assez de places sont disponibles !");
            }
        }
    }
}