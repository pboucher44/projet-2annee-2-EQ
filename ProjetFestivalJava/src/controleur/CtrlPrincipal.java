/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import javax.swing.JOptionPane;
/**
 *
 * @author pboucher
 */
public class CtrlPrincipal {


    private CtrlRepresentation ctrlLesRepresentations;
    private CtrlMenu ctrlMenu;
    private CtrlReservation ctrlReservation;
    
    public void afficherLeMenu() {
        this.ctrlLesRepresentations.getReserv().setVisible(false);
        this.ctrlReservation.getReserv().setVisible(false);
        this.ctrlMenu.getMenu().setVisible(true);
    }
    
    public void afficherLesRepresentations() {
        this.ctrlLesRepresentations.getReserv().setVisible(true);
        this.ctrlReservation.getReserv().setVisible(false);
        this.ctrlMenu.getMenu().setVisible(false);
    }
    
    public void afficherLesReservation() {
        this.ctrlLesRepresentations.getReserv().setVisible(false);
        this.ctrlReservation.getReserv().setVisible(true);
        this.ctrlMenu.getMenu().setVisible(false);
    }
    
     public void quitterApplication()
    {       
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "Representation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }
    
    public CtrlRepresentation getCtrlRepresentation() {
        return ctrlLesRepresentations;
    }
    
    public void setCtrlRepresentation(CtrlRepresentation ctrlLesRepresentations) {
        this.ctrlLesRepresentations = ctrlLesRepresentations;
    }
    
    public void setCtrlMenu(CtrlMenu ctrlMenu) {
        this.ctrlMenu = ctrlMenu;
    }

    public void setCtrlReservation(CtrlReservation ctrlReservation) {
        this.ctrlReservation = ctrlReservation;
    }
    
    
    
}
