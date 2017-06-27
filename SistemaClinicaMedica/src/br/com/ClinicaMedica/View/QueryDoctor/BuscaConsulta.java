/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ClinicaMedica.View.QueryDoctor;

import br.com.ClinicaMedica.Controller.Message;
import br.com.ClinicaMedica.Controller.QueryDoctorController;
import br.com.ClinicaMedica.Entity.QueryDoctor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscaConsulta extends javax.swing.JDialog {

    
    private QueryDoctorController queryController = new  QueryDoctorController();
    private List<QueryDoctor> querys;
    private QueryDoctor query = new QueryDoctor();
    
    
    public BuscaConsulta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        buttonController();
        txtSearch.setEnabled(false);
    }

    public void buttonController(){
        //Não esta selecionado a tabela
        if(tableQuery.getSelectedRow() == -1){
            btnExclui.setEnabled(false);
        }else{
            btnExclui.setEnabled(true);
        }  
    }
    
    public void showSearch(String field, String search){
        DefaultTableModel modelo = (DefaultTableModel) tableQuery.getModel();
        modelo.setNumRows(0);

        /* Verificação se a pessoa está procurando pelo nome não */
        if(field == null && search == null){
            querys = queryController.getAll();
        }else{
            querys = queryController.search(field, search);
        }

        if(querys.isEmpty()){
            new Message().warningMsg(this, "Nenhum cadastro de consultas encontrado!");
        }else{
            for(QueryDoctor q : querys){
                modelo.addRow(new Object[]{
                    q.getIdQuery(),
                    q.getPatient().getName(),
                    q.getPatient().getPhone(),
                    
                    q.getDoctor().getName(),
                    q.getHistoric().getDate(),
                    
                    q.getSick(),
                    q.getState()
                });
            } 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableQuery = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnExclui = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbSeach = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableQuery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome Paciente", "Telefone Paciente", "Nome Medico", "Data", "Doença", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableQuery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableQueryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableQuery);

        btnSearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\IAGO\\Documents\\Faculdade\\2Ano1Sem\\Ambiente Visual - Romualdo\\Icones\\icons\\find.png")); // NOI18N
        btnSearch.setText("Pesquisar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnExclui.setIcon(new javax.swing.ImageIcon("C:\\Users\\IAGO\\Documents\\Faculdade\\2Ano1Sem\\Ambiente Visual - Romualdo\\Icones\\icons\\delete.png")); // NOI18N
        btnExclui.setText("Excluir");
        btnExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Busca de Consultas");

        jLabel2.setText("Pesquisar:");

        cbSeach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione!", "Nome do paciente", "Nome do medico", "Todos" }));
        cbSeach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtSearch)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSeach, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 388, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(btnExclui, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbSeach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnExclui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbSeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeachActionPerformed
        txtSearch.setText("");
        if(cbSeach.getSelectedIndex() == 0){
            btnSearch.setEnabled(false);
            txtSearch.setEnabled(false);
        }else if(cbSeach.getSelectedIndex() == 3){
            txtSearch.setEnabled(false);
            btnSearch.setEnabled(true);
        }else{
            btnSearch.setEnabled(true);
            txtSearch.setEnabled(true);
        }
    }//GEN-LAST:event_cbSeachActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableQuery.getModel();
        model.setNumRows(0);
        
        switch (cbSeach.getSelectedIndex()){
            case 1:
                showSearch("patient.name",txtSearch.getText());
            break;
            case 2:
                showSearch("doctor.name",txtSearch.getText());
            break;  
            case 3:
                showSearch(null,null);
            break;
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tableQueryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableQueryMouseClicked
        // TODO add your handling code here:
        buttonController();
    }//GEN-LAST:event_tableQueryMouseClicked

    private void btnExcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiActionPerformed

        int validation = new Message().askMsg(this,"Deseja realmente excluir "
                + "esssa consulta?");
        
        if(validation == JOptionPane.YES_OPTION){
            //Capturando o ID
            query.setIdQuery((int) tableQuery.getModel().getValueAt(tableQuery.getSelectedRow(), 0));
            queryController.delet(query);
            new Message().infoMsg(this, "Consulta excluida!");
            showSearch(null, null);
        }
    }//GEN-LAST:event_btnExcluiActionPerformed


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
            java.util.logging.Logger.getLogger(BuscaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscaConsulta dialog = new BuscaConsulta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExclui;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbSeach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableQuery;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
