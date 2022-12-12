
package com.inventory.UI;

import com.inventory.DAO.UserDAO;
import com.inventory.DTO.UserDTO;
import com.inventory.Database.ConnectionFactory;

import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;



public class Dashboard extends javax.swing.JFrame {

    CardLayout layout;
    String userSelect;
    String username;
    String fullName;
    UserDTO userDTO;
    LocalDateTime outTime;
    /**
     * Creates new form Dashboard
     */
    public Dashboard(String username, String userType, UserDTO userDTO) {
        initComponents();
        setLocationRelativeTo(this);
        navPanel.setVisible(false);
        menuPanel.setVisible(true);
        layout = new CardLayout();
        userSelect = userType;
        this.username = username;
        this.userDTO = userDTO;
        if("EMPLOYEE".equalsIgnoreCase(userType))
            notForEmployee();
        currentUserSession();

        displayPanel.setLayout(layout);
        displayPanel.add("Home", new HomePage(username));
        displayPanel.add("Users", new PaginaUsers());
        displayPanel.add("Customers", new PaginaClientes());
        displayPanel.add("Products", new PaginaProductos(username, this));
        displayPanel.add("Suppliers", new PaginaProveedores());
        displayPanel.add("Current Stock", new PaginaStockActual(username));
        displayPanel.add("Sales", new PaginaVentas(username, this));
        displayPanel.add("Purchase", new PaginaCompras(this));
        displayPanel.add("Logs", new PaginaUserLogs());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                outTime = LocalDateTime.now();
                userDTO.setOutTime(String.valueOf(outTime));
                userDTO.setUsername(username);
                new UserDAO().addUserLogin(userDTO);
                super.windowClosing(e);
            }
        });

        setTitle("Sistema de Gestión de Inventarios");
        setVisible(true);
    }

    // Methods to display different sections in the mainframe
    public void addHomePage(){
        layout.show(displayPanel, "Home");
    }
    public void addUsersPage() {
        layout.show(displayPanel, "Users");
    }
    public void addCustPage() {
        layout.show(displayPanel, "Customers");
    }
    public void addProdPage() {
        layout.show(displayPanel, "Products");
    }
    public void addSuppPage() {
        layout.show(displayPanel, "Suppliers");
    }
    public void addStockPage() {
        layout.show(displayPanel, "Current Stock");
    }
    public void addSalesPage() {
        layout.show(displayPanel, "Sales");
    }
    public void addPurchasePage() {
        layout.show(displayPanel, "Purchase");
    }
    public void addLogsPage() {
        layout.show(displayPanel, "Logs");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        menuButton = new javax.swing.JButton();
        navPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        prodButton = new javax.swing.JButton();
        stockButton = new javax.swing.JButton();
        custButton = new javax.swing.JButton();
        suppButton = new javax.swing.JButton();
        salesButton = new javax.swing.JButton();
        usersButton = new javax.swing.JButton();
        purchaseButton = new javax.swing.JButton();
        logsButton = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();
        userPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Manager");
        setBounds(new java.awt.Rectangle(400, 100, 0, 0));

        menuPanel.setPreferredSize(new java.awt.Dimension(120, 26));

        menuButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventory/UI/Icons/menu_icon_150667.png"))); // NOI18N
        menuButton.setText("MENU");
        menuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        navPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventory/UI/Icons/homepages_home_house_icon_150665.png"))); // NOI18N
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        prodButton.setText("Productos");
        prodButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodButtonActionPerformed(evt);
            }
        });

        stockButton.setText("Stock Actual");
        stockButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockButtonActionPerformed(evt);
            }
        });

        custButton.setText("Clientes");
        custButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        custButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custButtonActionPerformed(evt);
            }
        });

        suppButton.setText("Proveedores");
        suppButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        suppButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppButtonActionPerformed(evt);
            }
        });

        salesButton.setText("Ventas");
        salesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesButtonActionPerformed(evt);
            }
        });

        usersButton.setText("Usuario");
        usersButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersButtonActionPerformed(evt);
            }
        });

        purchaseButton.setText("Compras");
        purchaseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseButtonActionPerformed(evt);
            }
        });

        logsButton.setText("Usuario Logs");
        logsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navPanelLayout = new javax.swing.GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prodButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stockButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(custButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(suppButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(purchaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        navPanelLayout.setVerticalGroup(
            navPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(prodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(custButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(suppButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        displayPanel.setLayout(new java.awt.CardLayout());

        nameLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        nameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventory/UI/Icons/user_icon_150670.png"))); // NOI18N
        nameLabel.setText("USUARIO:");
        nameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inventory/UI/Icons/log-out_icon-icons.com_50106.png"))); // NOI18N
        logoutButton.setText("Salir");
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton)
                .addGap(20, 20, 20))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(navPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        int opt = JOptionPane.showConfirmDialog(
                null,
                "<html>¿Seguro que quiere salir?<br>Deberá iniciar sesion de nuevo.<html>",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);
        if (opt==JOptionPane.YES_OPTION){
            outTime = LocalDateTime.now();
            userDTO.setOutTime(String.valueOf(outTime));
            userDTO.setUsername(username);
            new UserDAO().addUserLogin(userDTO);
            dispose();
            PaginaLogin logPage = new PaginaLogin();
            logPage.setVisible(true);
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void usersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersButtonActionPerformed
        addUsersPage();
    }//GEN-LAST:event_usersButtonActionPerformed

    private void salesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesButtonActionPerformed
        addSalesPage();
    }//GEN-LAST:event_salesButtonActionPerformed

    private void suppButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppButtonActionPerformed
        addSuppPage();
    }//GEN-LAST:event_suppButtonActionPerformed

    private void custButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custButtonActionPerformed
        addCustPage();
    }//GEN-LAST:event_custButtonActionPerformed

    private void stockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockButtonActionPerformed
        addStockPage();
    }//GEN-LAST:event_stockButtonActionPerformed

    private void prodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodButtonActionPerformed
        addProdPage();
    }//GEN-LAST:event_prodButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        //dispose();
        addHomePage();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        navPanel.setVisible(!navPanel.isVisible());
    }//GEN-LAST:event_menuButtonActionPerformed

    private void purchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseButtonActionPerformed
        addPurchasePage();
    }//GEN-LAST:event_purchaseButtonActionPerformed

    private void logsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logsButtonActionPerformed
        addLogsPage();
    }//GEN-LAST:event_logsButtonActionPerformed

    // Method to display the user currently logged in
    public void currentUserSession() {
        UserDTO userDTO = new UserDTO();
        new UserDAO().getFullName(userDTO, username);
        nameLabel.setText("User: " + userDTO.getFullName() + " ("+userSelect+")");
    }

    //Metodo para visualizar 'User' y 'UserLogs' solo para administradores.
    public void notForEmployee(){
        navPanel.remove(usersButton);
        navPanel.remove(logsButton);
        //navPanel.remove(salesButton);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton custButton;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JButton homeButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton logsButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton menuButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel navPanel;
    private javax.swing.JButton prodButton;
    private javax.swing.JButton purchaseButton;
    private javax.swing.JButton salesButton;
    private javax.swing.JButton stockButton;
    private javax.swing.JButton suppButton;
    private javax.swing.JPanel userPanel;
    private javax.swing.JButton usersButton;
    // End of variables declaration//GEN-END:variables
}
