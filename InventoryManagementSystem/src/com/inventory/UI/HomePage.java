/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.UI;
import java.util.Date;
import com.inventory.DAO.UserDAO;
import com.inventory.DTO.UserDTO;



public class HomePage extends javax.swing.JPanel {

    String userSelect;
    /**
     * Creates new form HomePage
     */
    public HomePage(String username, String userType) {
        
        initComponents();
        userSelect = userType;
        UserDTO userDTO = new UserDTO();
        new UserDAO().getFullName(userDTO, username);
        //welcomeLabel.setText("USER AUTORIZADO:  " + userDTO.getFullName());
        //Date date = new Date();
        //intimeLabel.setText("INTIME: "+date.toString());
        //rolLabel.setText("ROL: " + userSelect);

    
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(246, 246, 246));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventory/UI/Icons/testbackgroundjava.jpg"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 590));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
