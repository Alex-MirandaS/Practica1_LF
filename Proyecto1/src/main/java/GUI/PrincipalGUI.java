/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Main.Principal;
import javax.swing.JTextArea;


/**
 *
 * @author Alex
 */
public class PrincipalGUI extends javax.swing.JFrame {

    private Principal principal;

    public PrincipalGUI(Principal principal) {
        initComponents();
        this.principal = principal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        carga = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        rErrores = new javax.swing.JButton();
        rTokens = new javax.swing.JButton();
        rAFDoptimo = new javax.swing.JButton();
        recuentoLexemas = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IDENTIFICADOR");

        jPanel4.setLayout(new java.awt.GridLayout(3, 3));
        jPanel4.add(jLabel7);
        jPanel4.add(jLabel8);
        jPanel4.add(jLabel11);

        carga.setText("CARGA");
        carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargaActionPerformed(evt);
            }
        });
        jPanel4.add(carga);

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel4.add(guardar);

        rErrores.setText("R. ERRORES");
        rErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rErroresActionPerformed(evt);
            }
        });
        jPanel4.add(rErrores);

        rTokens.setText("R. TOKENS");
        rTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rTokensActionPerformed(evt);
            }
        });
        jPanel4.add(rTokens);

        rAFDoptimo.setText("AFD ÓPTIMO");
        jPanel4.add(rAFDoptimo);

        recuentoLexemas.setText("RECUENTO DE LEXEMAS");
        recuentoLexemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recuentoLexemasActionPerformed(evt);
            }
        });
        jPanel4.add(recuentoLexemas);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel9.setText("TEXTO XDXD");
        jPanel8.add(jLabel9, java.awt.BorderLayout.PAGE_START);

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        jPanel8.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel8, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rTokensActionPerformed
        principal.reporteTokens();
    }//GEN-LAST:event_rTokensActionPerformed

    private void cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargaActionPerformed
        principal.cargarArchivo();
    }//GEN-LAST:event_cargaActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        principal.guardarArchivo();
    }//GEN-LAST:event_guardarActionPerformed

    private void rErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rErroresActionPerformed
        principal.reporteErrores();
    }//GEN-LAST:event_rErroresActionPerformed

    private void recuentoLexemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recuentoLexemasActionPerformed
       principal.recuentoLexemas();
    }//GEN-LAST:event_recuentoLexemasActionPerformed

    public JTextArea getAreaTexto() {
        return areaTexto;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton carga;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rAFDoptimo;
    private javax.swing.JButton rErrores;
    private javax.swing.JButton rTokens;
    private javax.swing.JButton recuentoLexemas;
    // End of variables declaration//GEN-END:variables
}
