package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TransactionTable extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    Connection conn;
    JTable transactiontbl; 
    
    
     public TransactionTable() {
        initComponents();

        Fetch();
        
        transactiontbl = tblTransaction;
        tableModel = (DefaultTableModel) tblTransaction.getModel();
    }

 
      private void Fetch() {
        String displaysql = "SELECT * FROM tbl_combined";
        try (Connection conn = new InventorySystem().getConnection()){
            PreparedStatement pst = conn.prepareStatement(displaysql);
            ResultSet rs = pst.executeQuery();

            // Clear existing rows from the table
            DefaultTableModel model = (DefaultTableModel)tblTransaction.getModel();
            model.setRowCount(0); // Clear the table before populating

            // Iterate through the result set and add data to the table
            while (rs.next()) {
               model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3),
                   rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
               });
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }
      

  
//        public DefaultTableModel getTableModel() {
//        DefaultTableModel model = new DefaultTableModel();
//        try {
//            String displaysql = "SELECT * FROM tbl_combined";
//            PreparedStatement pst = conn.prepareStatement(displaysql);
//            ResultSet rs = pst.executeQuery();
//            
//            model.addColumn("Item ID");
//            model.addColumn("Category");
//            model.addColumn("Item Name");
//            model.addColumn("Quantity");
//            model.addColumn("Unit Price");
//            model.addColumn("Transaction Type");
//            model.addColumn("Date Addasdasdasded");
//
//            while (rs.next()) {
//                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3),
//                    rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
//                });
//            }
//        } catch (SQLException e) {
//            System.out.println("Error executing SQL query: " + e.getMessage());
//        }
//        return model;
//    }
        
      
    private void editRow() {
        // Method to edit the selected row
        int selectedRowIndex = tblTransaction.getSelectedRow();
        if (selectedRowIndex != -1) { // If a row is selected
            // Let's say you want to edit the data in the second column (1-based index)
//            String newValue = "New Value"; // New value you want to set
            Object[] rowData = new Object[tableModel.getColumnCount()]; // Create an array to hold the selected row data
                    for (int i = 0; i < tableModel.getColumnCount(); i++) {
                        rowData[i] = tableModel.getValueAt(selectedRowIndex, i); // Get data from each column of the selected row
                    }
            InventoryManagement Home3Frame = new InventoryManagement();
            Home3Frame.setVisible(true);
            Home3Frame.pack();
            Home3Frame.setLocationRelativeTo(null);
            Home3Frame.updateItem(rowData);
            
//            this.dispose();
//            tableModel.setValueAt(newValue, selectedRowIndex, 1); // Update the value in the table model
        }
    }

    
    public void updateTable(Object[] rowData) {
        tableModel.addRow(rowData);
    }

    public void addDataToTable(Object[] rowData) {
        tableModel.addRow(rowData);
    }

     public void updateDataInTable(int rowIndex, Object[] rowData) {
        // Check if rowIndex is valid
        if (rowIndex >= 0 && rowIndex < tableModel.getRowCount()) {
            for (int i = 0; i < rowData.length; i++) {
                tableModel.setValueAt(rowData[i], rowIndex, i);
            }
        } else {
            System.out.println("Invalid row index");
        }
    }


       public void deleteDataFromTable(int rowIndex) {
        // Check if rowIndex is valid
        if (rowIndex >= 0 && rowIndex < tableModel.getRowCount()) {
            tableModel.removeRow(rowIndex);
        } else {
            System.out.println("Invalid row index");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnSummary = new javax.swing.JButton();
        lblTransactionTbl = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaction = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));

        jPanel3.setBackground(new java.awt.Color(254, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(212, 281));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventorysystem/PADAYON2.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("        Transaction Table");
        jLabel4.setToolTipText("");

        jButton4.setBackground(new java.awt.Color(254, 255, 255));
        jButton4.setForeground(new java.awt.Color(153, 153, 153));
        jButton4.setText("        Office Inventory System");
        jButton4.setActionCommand("Login");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(254, 255, 255));
        jButton7.setForeground(new java.awt.Color(153, 153, 153));
        jButton7.setText("        Inventory Management");
        jButton7.setActionCommand("Login");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        btnSummary.setBackground(new java.awt.Color(254, 255, 255));
        btnSummary.setForeground(new java.awt.Color(153, 153, 153));
        btnSummary.setText("        Summary Table");
        btnSummary.setActionCommand("Login");
        btnSummary.setBorder(null);
        btnSummary.setBorderPainted(false);
        btnSummary.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSummary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(94, 94, 94)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSummary)
                .addContainerGap(340, Short.MAX_VALUE))
        );

        lblTransactionTbl.setBackground(new java.awt.Color(255, 255, 255));
        lblTransactionTbl.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTransactionTbl.setForeground(new java.awt.Color(255, 255, 255));
        lblTransactionTbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTransactionTbl.setText("Transaction Table");
        lblTransactionTbl.setToolTipText("");
        lblTransactionTbl.setAlignmentY(0.0F);
        lblTransactionTbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnEdit.setText("Edit");
        btnEdit.setBorderPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        tblTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Item ID", "Category", "Item Name", "Quantity", "Unit Price", "Transaction Type", "Date Added"
            }
        ));
        jScrollPane1.setViewportView(tblTransaction);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTransactionTbl, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(0, 239, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTransactionTbl)
                    .addComponent(btnEdit))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        OfficeInventory Home2Frame = new OfficeInventory();
        Home2Frame.setVisible(true);
        Home2Frame.pack();
        Home2Frame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        InventoryManagement itemPanel = new InventoryManagement();
        itemPanel.setVisible(true);
        itemPanel.pack();
        itemPanel.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

          editRow();

//       int rowIndex = tblTransaction.getSelectedRow();
//        if (rowIndex != -1) {
//            Object[] rowData = new Object[7];
//            for (int i = 0; i < 7; i++) {
//                rowData[i] = tblTransaction.getValueAt(rowIndex, i);
//            }
//            InventoryManagement itemPanel = new InventoryManagement(rowData);
//            itemPanel.setVisible(true);
//            itemPanel.pack();
//            itemPanel.setLocationRelativeTo(null);
//            dispose(); // Close the TransactionTable window
//        } else {
//            JOptionPane.showMessageDialog(null, "Please select a row to edit.");
//        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummaryActionPerformed
        SummaryTable summaryPanel = new SummaryTable();
        summaryPanel.setVisible(true);
        summaryPanel.pack();
        summaryPanel.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnSummaryActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransactionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TransactionTable().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSummary;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTransactionTbl;
    private javax.swing.JTable tblTransaction;
    // End of variables declaration//GEN-END:variables

    void setItems(List<InventoryItem> items) {
         DefaultTableModel model = (DefaultTableModel) transactiontbl.getModel();
    model.setRowCount(0);

    for (InventoryItem Item : items) {
        Object[] rowData = {item.getId(), item.getName(), item.getPrice()};
        model.addRow(rowData);
        }
    }

    List<InventoryItem> getItems() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

