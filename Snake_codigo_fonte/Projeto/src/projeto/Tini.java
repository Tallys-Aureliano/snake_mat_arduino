/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;
import java.awt.EventQueue;
import java.awt.AWTEvent;
import java.awt.AWTException;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.JOptionPane;
import static projeto.Grade.nivel;
import java.awt.Image;
import java.net.URL;
import javax.swing.JLabel;

/**
 *
 * @author tatat
 */
public class Tini extends javax.swing.JFrame {

    public static boolean Facil = false;
    public static boolean Medio = true;
    public static boolean Difici = true;
    /**
     * Creates new fo rm a
     */


   
    boolean sonodmais = false;
    String cabecaAvatar = "cabeca.png";
    String corpoAvatar = "bola.png";
    
    public Tini() {
        initComponents();
        setSize(520, 540);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.GREEN);
    }
    
                /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();
        jFNome = new javax.swing.JFormattedTextField();
        jLIdade = new javax.swing.JLabel();
        jFIdade = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        JBgd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBInstru = new javax.swing.JButton();
        jButtonMedio = new javax.swing.JButton();
        jButtonDificil = new javax.swing.JButton();
        jButtonFacil = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLNome.setText("Nome:");
        getContentPane().add(jLNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 40, -1));

        jFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jFNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 33, 210, -1));

        jLIdade.setText("Idade:");
        getContentPane().add(jLIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 53, -1));

        try {
            jFIdade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFIdadeActionPerformed(evt);
            }
        });
        getContentPane().add(jFIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 63, 43, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 106, -1, -1));

        JBgd.setText("Guardar Dados");
        JBgd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBgdActionPerformed(evt);
            }
        });
        getContentPane().add(JBgd, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 228, -1, -1));

        jLabel1.setText("Anos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 66, -1, -1));

        jBInstru.setText("Instruções");
        jBInstru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInstruActionPerformed(evt);
            }
        });
        getContentPane().add(jBInstru, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 228, -1, -1));

        jButtonMedio.setText("Médio");
        jButtonMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMedioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 128, -1, -1));

        jButtonDificil.setText("Dificil");
        jButtonDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDificilActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDificil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 157, 61, -1));

        jButtonFacil.setText("Fácil");
        jButtonFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFacilActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFacil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 94, 61, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/CM.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, -50, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto/Manda_3.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFNomeActionPerformed

    private void jFIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFIdadeActionPerformed

    private void JBgdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBgdActionPerformed
        sonodmais = true;
        Aluno um = new Aluno();
        try {

            um.setIdade(Integer.parseInt(
                    jFIdade.getText()));
            um.setNome(jFNome.getText());

        } catch (NullPointerException jv) {
            JOptionPane.showMessageDialog(null,
                    "ERROU... \n DIGITE SUA IDADE, NOME  CERTO POR FAVORssssss\n E ESCOLHA O NIVEL ");

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null,
                    "Errou... \n DIGITE SUA IDADE, NOME  CERTO ssss POR FAVOR \n E ESCOLHA O NIVEL");

        }

// TODO add your handling code here:
    }//GEN-LAST:event_JBgdActionPerformed

    private void jBInstruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInstruActionPerformed
        if (Aluno.idade > 03 && nivel >= 2) {
            Instrucoes instru = new Instrucoes();

        } else {
            JOptionPane.showMessageDialog(null, "Guarde os Dados "
                    + "\n DIGITE SUA IDADE, NOME CERTO, POR FAVOR  \n E ESCOLHA O NIVEL ");

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jBInstruActionPerformed

    private void jButtonDificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDificilActionPerformed
        Grade.nivel = 3;
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDificilActionPerformed

    private void jButtonMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMedioActionPerformed
        Grade.nivel = 4;
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMedioActionPerformed

    private void jButtonFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFacilActionPerformed
        Grade.nivel = 6;
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonFacilActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new RunnableImpl());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBgd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBInstru;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonDificil;
    private javax.swing.JButton jButtonFacil;
    private javax.swing.JButton jButtonMedio;
    private javax.swing.JFormattedTextField jFIdade;
    private javax.swing.JFormattedTextField jFNome;
    private javax.swing.JLabel jLIdade;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

       
        public void run() {
            new Tini().setVisible(true);
        }
    }

}