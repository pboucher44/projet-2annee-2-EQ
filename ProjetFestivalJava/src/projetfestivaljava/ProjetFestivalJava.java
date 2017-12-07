/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetfestivaljava;

/**
 *
 * @author rdemazeau
 */
public class ProjetFestivalJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        vue.VueRepresentation uneVue = new vue.VueRepresentation();
        controleur.CtrlRepresentation unControleur = new controleur.CtrlRepresentation(uneVue);
        // afficher la vue
        uneVue.setVisible(true);
    }
    
}
