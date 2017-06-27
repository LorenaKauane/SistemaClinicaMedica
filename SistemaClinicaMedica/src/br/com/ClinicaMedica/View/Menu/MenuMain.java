
package br.com.ClinicaMedica.View.Menu;

import br.com.ClinicaMedica.View.Doctor.BuscaDoutor;
import br.com.ClinicaMedica.View.Doctor.CadastroDoutor;
import br.com.ClinicaMedica.View.Patient.BuscaPacientes;
import br.com.ClinicaMedica.View.Patient.CadastroPacientes;
import br.com.ClinicaMedica.View.QueryDoctor.BuscaConsulta;
import br.com.ClinicaMedica.View.QueryDoctor.CadastroConsultas;


public class MenuMain extends javax.swing.JFrame {

    
    public MenuMain() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastroMedicos = new javax.swing.JButton();
        cadastroPacientes = new javax.swing.JButton();
        cadastroConsultas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnCadastroConsultas = new javax.swing.JMenuItem();
        mnCadastroPacientes = new javax.swing.JMenuItem();
        mnCadastroMedicos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);

        cadastroMedicos.setIcon(new javax.swing.ImageIcon("C:\\Users\\IAGO\\Documents\\Faculdade\\2Ano1Sem\\Ambiente Visual - Romualdo\\Icones\\icons\\user_suit.png")); // NOI18N
        cadastroMedicos.setText("Cadastrar Medicos");
        cadastroMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroMedicosActionPerformed(evt);
            }
        });

        cadastroPacientes.setIcon(new javax.swing.ImageIcon("C:\\Users\\IAGO\\Documents\\Faculdade\\2Ano1Sem\\Ambiente Visual - Romualdo\\Icones\\icons\\user.png")); // NOI18N
        cadastroPacientes.setText("Cadastrar Pacientes");
        cadastroPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroPacientesActionPerformed(evt);
            }
        });

        cadastroConsultas.setIcon(new javax.swing.ImageIcon("C:\\Users\\IAGO\\Documents\\Faculdade\\2Ano1Sem\\Ambiente Visual - Romualdo\\Icones\\icons\\vcard_add.png")); // NOI18N
        cadastroConsultas.setText("Cadastrar Constultas");
        cadastroConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroConsultasActionPerformed(evt);
            }
        });

        jLabel1.setText("Cadastros");

        jMenu1.setText("Cadastros");

        mnCadastroConsultas.setText("Consultas");
        mnCadastroConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastroConsultasActionPerformed(evt);
            }
        });
        jMenu1.add(mnCadastroConsultas);

        mnCadastroPacientes.setText("Pacientes");
        mnCadastroPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastroPacientesActionPerformed(evt);
            }
        });
        jMenu1.add(mnCadastroPacientes);

        mnCadastroMedicos.setText("Medicos");
        mnCadastroMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastroMedicosActionPerformed(evt);
            }
        });
        jMenu1.add(mnCadastroMedicos);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Buscas");

        jMenuItem6.setText("Busca Pacientes");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Busca Medicos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Busca por consultas");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Exit");

        jMenuItem5.setText("Sair");
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastroConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadastroPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cadastroMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastroMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastroPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(cadastroConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnCadastroMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastroMedicosActionPerformed
        CadastroDoutor cadastro = new CadastroDoutor(this, true);
        cadastro.setVisible(true);
        cadastro.requestFocus();
    }//GEN-LAST:event_mnCadastroMedicosActionPerformed

    private void cadastroMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroMedicosActionPerformed
        CadastroDoutor cadastro = new CadastroDoutor(this, true);
        cadastro.setVisible(true);
        cadastro.requestFocus();
    }//GEN-LAST:event_cadastroMedicosActionPerformed

    private void cadastroPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroPacientesActionPerformed
        
        CadastroPacientes cadastro = new CadastroPacientes(this, true);
        cadastro.setVisible(true);
        cadastro.requestFocus();
    }//GEN-LAST:event_cadastroPacientesActionPerformed

    private void mnCadastroPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastroPacientesActionPerformed
        // TODO add your handling code here:
        CadastroPacientes cadastro = new CadastroPacientes(this, true);
        cadastro.setVisible(true);
        cadastro.requestFocus();
    }//GEN-LAST:event_mnCadastroPacientesActionPerformed

    private void cadastroConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroConsultasActionPerformed
       CadastroConsultas cadastro = new CadastroConsultas(this,true);
       cadastro.setVisible(true);
        cadastro.requestFocus();
    }//GEN-LAST:event_cadastroConsultasActionPerformed

    private void mnCadastroConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastroConsultasActionPerformed
        // TODO add your handling code here:
       CadastroConsultas cadastro = new CadastroConsultas(this,true);
       cadastro.setVisible(true);
       cadastro.requestFocus();
    }//GEN-LAST:event_mnCadastroConsultasActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        BuscaPacientes busca = new BuscaPacientes(this, true);
        busca.setVisible(true);
        busca.requestFocus();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        BuscaDoutor busca = new BuscaDoutor(this,true);
        busca.setVisible(true);
        busca.requestFocus();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        BuscaConsulta busca = new BuscaConsulta(this, true);
        busca.setVisible(true);
        busca.requestFocus();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

  
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
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastroConsultas;
    private javax.swing.JButton cadastroMedicos;
    private javax.swing.JButton cadastroPacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem mnCadastroConsultas;
    private javax.swing.JMenuItem mnCadastroMedicos;
    private javax.swing.JMenuItem mnCadastroPacientes;
    // End of variables declaration//GEN-END:variables
}
