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
import javax.swing.JButton;
import vue.VueMenu;
/**
 *
 * @author Unknow
 */
public class CtrlMenu implements WindowListener,ActionListener{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    private vue.VueMenu menu;
    private CtrlPrincipal ctrlPrincipal;
    
    
    public CtrlMenu (vue.VueMenu vue, CtrlPrincipal ctrl){
        this.menu=vue;
        this.menu.addWindowListener(this);
        this.menu.getjButton1().addActionListener(this);
        this.menu.getjButton2().addActionListener(this);
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

    public VueMenu getMenu() {
        return menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.menu.getjButton1())){
            ctrlPrincipal.afficherLesRepresentations();
        }else if(e.getSource().equals(this.menu.getjButton2())){
            ctrlPrincipal.afficherAuth();
        }
    }
 
}

