/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ClinicaMedica.View.Patient;

import br.com.ClinicaMedica.Controller.Message;
import br.com.ClinicaMedica.Controller.PatientController;
import br.com.ClinicaMedica.Entity.Patient;
import br.com.ClinicaMedica.View.QueryDoctor.CadastroConsultas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author IAGO
 */
public class BuscaPacientes extends javax.swing.JDialog {

    private Patient patient = new Patient();
    private PatientController controllerPatient = new PatientController();
    private List<Patient> patients;
    
    private boolean checkScreen = false;
    public BuscaPacientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        buttonController();
        btnSearch.setEnabled(false);
        txtSearch.setEnabled(false);
    }
    
    //Construtor para abrir na tela de cadastro de consultas
    public BuscaPacientes(CadastroConsultas owner, boolean modal) {
        super(owner, modal);
        initComponents();
        btnEdit.setEnabled(false);
        btnNew.setEnabled(false);
        btnDelet.setEnabled(false);
        checkScreen = true;
    }
    
    public void buttonController(){
        //Não esta selecionado
        if(tablePaciente.getSelectedRow() == -1){
            btnEdit.setEnabled(false);
            btnDelet.setEnabled(false);
        }else{
            btnEdit.setEnabled(true);
            btnDelet.setEnabled(true);
        }  
    }
    
    public void showSearch(String field, String search){
        DefaultTableModel model = (DefaultTableModel) tablePaciente.getModel();
        model.setNumRows(0);
        /* Verificação se a pessoa está procurando pelo nome não */
        if(field == null && search == null){
            patients = controllerPatient.getAll();
        }else{
            patients = controllerPatient.searchId(field, search);
        }

        if(patients.isEmpty()){
            new Message().warningMsg(this, "Nenhum cadastro de cliente encontrado!");
        }else{
            for(Patient p : patients){
                model.addRow(new Object[]{
                    p.getIdPatient(),
                    p.getName(),
                    p.getAddress(),
                    p.getPhone(),
                });
            } 
        }
    }
    
    public void captureData(){
        String id    = String.valueOf(tablePaciente.getModel().getValueAt(tablePaciente.getSelectedRow(), 0));
        
        patient.setIdPatient(Integer.parseInt(id));
        patient.setName(String.valueOf(tablePaciente.getModel().getValueAt(tablePaciente.getSelectedRow(), 1)));
        patient.setAddress(String.valueOf(tablePaciente.getModel().getValueAt(tablePaciente.getSelectedRow(), 2)));
        patient.setPhone(String.valueOf(tablePaciente.getModel().getValueAt(tablePaciente.getSelectedRow(), 3)));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePaciente = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnDelet = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca de Pacientes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Busca de Paciente!");

        jLabel2.setText("Pesquisar:");

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione!", "Nome", "Id", "Todos" }));
        cbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSearchActionPerformed(evt);
            }
        });

        txtSearch.setToolTipText("");
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        tablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Endereço", "Telefone", "Data da ultima consulta", "Ultima doença"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePaciente);

        btnSearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\IAGO\\Documents\\Faculdade\\2Ano1Sem\\Ambiente Visual - Romualdo\\Icones\\icons\\find.png")); // NOI18N
        btnSearch.setText("Pesquisar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnNew.setIcon(new javax.swing.ImageIcon("C:\\Users\\IAGO\\Documents\\Faculdade\\2Ano1Sem\\Ambiente Visual - Romualdo\\Icones\\icons\\add.png")); // NOI18N
        btnNew.setText("Cadastrar Novo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelet.setIcon(new javax.swing.ImageIcon("C:\\Users\\IAGO\\Documents\\Faculdade\\2Ano1Sem\\Ambiente Visual - Romualdo\\Icones\\icons\\delete.png")); // NOI18N
        btnDelet.setText("Excluir");
        btnDelet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon("C:\\Users\\IAGO\\Documents\\Faculdade\\2Ano1Sem\\Ambiente Visual - Romualdo\\Icones\\icons\\pencil.png")); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(btnDelet, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnDelet)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(898, 408));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchActionPerformed
        txtSearch.setText("");
        if(cbSearch.getSelectedIndex() == 0){
            btnSearch.setEnabled(false);
            txtSearch.setEnabled(false);
        }else if(cbSearch.getSelectedIndex() == 3){
            txtSearch.setEnabled(false);
            btnSearch.setEnabled(true);
        }else{
            btnSearch.setEnabled(true);
            txtSearch.setEnabled(true);
        }
        
    }//GEN-LAST:event_cbSearchActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CadastroPacientes cadastro = new CadastroPacientes(this, true);
        cadastro.setVisible(true);
        cadastro.requestFocus();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) tablePaciente.getModel();
        modelo.setNumRows(0);
        
        switch (cbSearch.getSelectedIndex()){
            case 1:
                showSearch("name",txtSearch.getText());
            break;
            case 2:
                showSearch("idPatient",txtSearch.getText());
            break;  
            case 3:
                //txtPesquisa.setEnabled(false);
                showSearch(null,null);
            break;
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePacienteMouseClicked
        // TODO add your handling code here:
        buttonController();
    }//GEN-LAST:event_tablePacienteMouseClicked

    private void btnDeletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletActionPerformed
        int validation = new Message().askMsg(this, "Deseja realmente excluir esse paciente?");
        
        if(validation == JOptionPane.YES_OPTION){
            patient.setIdPatient((int) tablePaciente.getModel().getValueAt(tablePaciente.getSelectedRow(), 0)); 
            controllerPatient.delet(patient);
            new Message().infoMsg(this, "Paciente deletado do sistema!");
            showSearch(null,null);
        }

    }//GEN-LAST:event_btnDeletActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        captureData();
        this.dispose();
        CadastroPacientes cadastro = new CadastroPacientes(this, true, patient);
        cadastro.setVisible(true);
        cadastro.requestFocus();

    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(cbSearch.getSelectedIndex() == 2){
            txtSearch.setText(txtSearch.getText().replaceAll("[^0-9]", ""));
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    
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
            java.util.logging.Logger.getLogger(BuscaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscaPacientes dialog = new BuscaPacientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDelet;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePaciente;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
