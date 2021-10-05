/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Main.Principal;
import javax.swing.JButton;

/**
 *
 * @author Alex
 */
public class ReportesGUI extends javax.swing.JFrame {

    private Principal principal;

    public ReportesGUI(Principal principal) {
        initComponents();
        this.principal = principal;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rErrores = new javax.swing.JButton();
        rTokens = new javax.swing.JButton();
        rLexemas = new javax.swing.JButton();
        rAFD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText(" ");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("  ");
        jPanel1.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        jLabel3.setText("     ");
        jPanel1.add(jLabel3, java.awt.BorderLayout.LINE_END);

        jLabel4.setText("     ");
        jPanel1.add(jLabel4, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        jLabel5.setText("REPORTES");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel5);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("   ");
        jPanel3.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jLabel7.setText("   ");
        jPanel3.add(jLabel7, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.GridLayout(2, 2));

        rErrores.setText("REPORTE DE ERRORES");
        rErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rErroresActionPerformed(evt);
            }
        });
        jPanel4.add(rErrores);

        rTokens.setText("REPORTE DE TOKENS");
        rTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rTokensActionPerformed(evt);
            }
        });
        jPanel4.add(rTokens);

        rLexemas.setText("RECUENTO DE LEXEMAS");
        rLexemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rLexemasActionPerformed(evt);
            }
        });
        jPanel4.add(rLexemas);

        rAFD.setText("AFD OPTIMO");
        jPanel4.add(rAFD);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rErroresActionPerformed
        principal.reporteErrores();
    }//GEN-LAST:event_rErroresActionPerformed

    private void rTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rTokensActionPerformed
       principal.reporteTokens();
    }//GEN-LAST:event_rTokensActionPerformed

    private void rLexemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rLexemasActionPerformed
        principal.recuentoLexemas();
    }//GEN-LAST:event_rLexemasActionPerformed

    public JButton getrAFD() {
        return rAFD;
    }

    public JButton getrErrores() {
        return rErrores;
    }

    public JButton getrLexemas() {
        return rLexemas;
    }

    public JButton getrTokens() {
        return rTokens;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton rAFD;
    private javax.swing.JButton rErrores;
    private javax.swing.JButton rLexemas;
    private javax.swing.JButton rTokens;
    // End of variables declaration//GEN-END:variables
}