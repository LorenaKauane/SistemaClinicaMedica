
package br.com.ClinicaMedica.View.Doctor;

import br.com.ClinicaMedica.Controller.DoctorController;
import br.com.ClinicaMedica.Controller.Message;
import br.com.ClinicaMedica.Entity.Doctor;
import br.com.ClinicaMedica.View.QueryDoctor.CadastroConsultas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuscaDoutor extends javax.swing.JDialog {
  
    private Doctor doctor                       = new Doctor(); 
    private DoctorController doctorController   = new DoctorController();
    private List<Doctor> doctors                = new ArrayList<>();
    private boolean checkScreen                 = false;
    
    public BuscaDoutor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        buttonController();
        btnSearch.setEnabled(false);
        txtSearch.setEnabled(false);
    }
    
     //Construtor para abrir na tela de cadastro de consultas
    public BuscaDoutor(CadastroConsultas owner, boolean modal) {
        super(owner, modal);
        initComponents();
        btnEdita.setEnabled(false);
        btnNew.setEnabled(false);
        btnExclui.setEnabled(false);
        checkScreen = true;
    }
    
    public void captureData(){
        String id    = String.valueOf(tableDoctor.getModel().getValueAt(tableDoctor.getSelectedRow(), 0));
        
        doctor.setIdDoctor(Integer.parseInt(id));
        doctor.setName(String.valueOf(tableDoctor.getModel().getValueAt(tableDoctor.getSelectedRow(), 1)));
        doctor.setSpecialization(String.valueOf(tableDoctor.getModel().getValueAt(tableDoctor.getSelectedRow(), 2)));
    }
    
    public void buttonController(){
        if(tableDoctor.getSelectedRow() == -1){
            btnExclui.setEnabled(false);
            btnEdita.setEnabled(false);
        }else{
            btnExclui.setEnabled(true);
            btnEdita.setEnabled(true);
        }
    }
    
    public void showSearch(String field, String search){
        DefaultTableModel model = (DefaultTableModel) tableDoctor.getModel();
        model.setNumRows(0);
        /* Verificação se a pessoa está procurando pelo nome não */
        if(field == null && search == null){
            doctors = doctorController.getAll();
        }else{
            doctors = doctorController.searchId(field, search);
        }

        if(doctors.isEmpty()){
            new Message().warningMsg(this, "Nenhum cadastro de cliente encontrado!");
        }else{
            for(Doctor d : doctors){
                model.addRow(new Object[]{
                    d.getIdDoctor(),
                    d.getName(),
                    d.getSpecialization(),
                });
            } 
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDoctor = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnExclui = new javax.swing.JButton();
        btnEdita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Busca de Doutor");

        jLabel2.setText("Pesquisar:");

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione!", "Nome", "Especialização", "Todos" }));
        cbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSearchActionPerformed(evt);
            }
        });

        tableDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Especialização"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDoctorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDoctor);

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

        btnExclui.setIcon(new javax.swing.ImageIcon("C:\\Users\\IAGO\\Documents\\Faculdade\\2Ano1Sem\\Ambiente Visual - Romualdo\\Icones\\icons\\delete.png")); // NOI18N
        btnExclui.setText("Excluir");
        btnExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiActionPerformed(evt);
            }
        });

        btnEdita.setIcon(new javax.swing.ImageIcon("C:\\Users\\IAGO\\Documents\\Faculdade\\2Ano1Sem\\Ambiente Visual - Romualdo\\Icones\\icons\\pencil.png")); // NOI18N
        btnEdita.setText("Editar");
        btnEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditaActionPerformed(evt);
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
                                .addComponent(btnExclui, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                .addComponent(btnEdita, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
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
                            .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnExclui)
                    .addComponent(btnEdita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchActionPerformed
        // TODO add your handling code here:
        
        if(cbSearch.getSelectedIndex() == 0){
            txtSearch.setEnabled(false);
            btnSearch.setEnabled(false);
        }else if(cbSearch.getSelectedIndex() == 3){
             txtSearch.setEnabled(false);
             btnSearch.setEnabled(true);
        }else{
            txtSearch.setEnabled(true);
            btnSearch.setEnabled(true);
        }
        
    }//GEN-LAST:event_cbSearchActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CadastroDoutor cadastro = new CadastroDoutor(this,true);
        cadastro.setVisible(true);
        cadastro.requestFocus();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableDoctor.getModel();
        model.setNumRows(0);
        
        switch(cbSearch.getSelectedIndex()){
            
            case 1:
                showSearch("name", txtSearch.getText());
            break;
            
            case 2:
                showSearch("specialization", txtSearch.getText());
            break;
            
            case 3:
                showSearch(null, null);
            break;
            
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tableDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDoctorMouseClicked
        // TODO add your handling code here:
        if(checkScreen){
            if(evt.getClickCount() == 2){
                captureData();
                checkScreen = false;
                this.dispose();
                CadastroConsultas cadastro = new CadastroConsultas(this, true, doctor);
                cadastro.setVisible(true);
            }
        }else{
            buttonController();
        }
        
    }//GEN-LAST:event_tableDoctorMouseClicked

    private void btnExcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiActionPerformed
        // TODO add your handling code here:
        int validation = new Message().askMsg(this, "Deseja realmente excluir este medico?");
        
        if(validation == JOptionPane.YES_OPTION){
            doctor.setIdDoctor((int) tableDoctor.getModel().getValueAt(tableDoctor.getSelectedRow(), 0));
            doctorController.delet(doctor);
            new Message().infoMsg(this, "Deletado!");
            showSearch(null, null);
        }
        
    }//GEN-LAST:event_btnExcluiActionPerformed

    private void btnEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditaActionPerformed
        // TODO add your handling code here:
        captureData();

        this.dispose();
        CadastroDoutor cadastro = new CadastroDoutor(this, true, doctor);
        cadastro.setVisible(true);
        cadastro.requestFocus();
        
    }//GEN-LAST:event_btnEditaActionPerformed


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
            java.util.logging.Logger.getLogger(BuscaDoutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaDoutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaDoutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaDoutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscaDoutor dialog = new BuscaDoutor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnEdita;
    private javax.swing.JButton btnExclui;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDoctor;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
