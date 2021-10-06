/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Main.Principal;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Alex
 */
public class PrincipalGUI extends javax.swing.JFrame {

    private Principal principal;

    public PrincipalGUI(Principal principal) {
        initComponents();
        areaTexto.setEditable(false);
        guardar.setEnabled(false);
        editar.setEnabled(false);
        reportes.setEnabled(false);
        this.principal = principal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        carga = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        busqueda = new javax.swing.JButton();
        reportes = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IDENTIFICADOR");

        jPanel4.setLayout(new java.awt.GridLayout(3, 4));
        jPanel4.add(jLabel7);
        jPanel4.add(jLabel1);
        jPanel4.add(jLabel2);
        jPanel4.add(jLabel8);

        carga.setText("CARGA");
        carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargaActionPerformed(evt);
            }
        });
        jPanel4.add(carga);

        editar.setText("EDITAR");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        jPanel4.add(editar);

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel4.add(guardar);

        busqueda.setText("BUSQUEDA");
        busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaActionPerformed(evt);
            }
        });
        jPanel4.add(busqueda);

        reportes.setText("REPORTES");
        reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesActionPerformed(evt);
            }
        });
        jPanel4.add(reportes);
        jPanel4.add(jLabel11);
        jPanel4.add(jLabel3);

        salir.setText("SALIR");
        jPanel4.add(salir);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel9.setText("TEXTO");
        jPanel8.add(jLabel9, java.awt.BorderLayout.PAGE_START);

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        jPanel8.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel8, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        principal.guardarArchivo();
        areaTexto.setEditable(false);
        guardar.setEnabled(false);
        editar.setEnabled(true);
        reportes.setEnabled(true);
    }//GEN-LAST:event_guardarActionPerformed

    private void cargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargaActionPerformed
        principal.cargarArchivo();
        editar.setEnabled(true);
        reportes.setEnabled(true);
    }//GEN-LAST:event_cargaActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        areaTexto.setEditable(true);
        editar.setEnabled(false);
        guardar.setEnabled(true);
        reportes.setEnabled(false);
    }//GEN-LAST:event_editarActionPerformed

    private void reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesActionPerformed
        principal.reportes();
    }//GEN-LAST:event_reportesActionPerformed

    private void busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaActionPerformed
        principal.busquedaPatrones();
    }//GEN-LAST:event_busquedaActionPerformed

    public JTextArea getAreaTexto() {
        return areaTexto;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton busqueda;
    private javax.swing.JButton carga;
    private javax.swing.JButton editar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reportes;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
