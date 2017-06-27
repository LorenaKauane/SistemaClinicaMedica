/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ClinicaMedica.Controller;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author IAGO
 */
public class Message {
    
    public void infoMsg(Component parentComponent,String message){
        JOptionPane.showMessageDialog(parentComponent, message,"Atenção!",JOptionPane.INFORMATION_MESSAGE);
    }
    public void warningMsg(Component parentComponent,String message){
        JOptionPane.showMessageDialog(parentComponent, message,"Atenção!",JOptionPane.WARNING_MESSAGE);
    }
    
    public void erroeMsg(Component parentComponent,String message){
        JOptionPane.showMessageDialog(parentComponent, message,"Atenção!",JOptionPane.ERROR_MESSAGE);
    }
    
    public int askMsg(Component parentComponent,String message){
        return JOptionPane.showConfirmDialog(parentComponent, message, "Atenção!", JOptionPane.YES_NO_OPTION);
    }
    
}
