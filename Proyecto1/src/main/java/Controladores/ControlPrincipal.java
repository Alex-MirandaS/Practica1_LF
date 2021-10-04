/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Enums.TipoToken;
import GUI.PrincipalGUI;
import GUI.TablaResultados;
import Main.Principal;
import Objetos.Contable;
import Objetos.Token;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class ControlPrincipal {

    private Principal principal;

    private ArrayList<String> filasArchivo = new ArrayList<>();
    private ArrayList<Token> tokens = new ArrayList<>();

    public ControlPrincipal(Principal principal) {
        this.principal = principal;
    }

    public ArrayList<String> seleccionarArchivo() {

        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(principal.getPrincipalGUI());

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //aqui selecciono y guardo el FILE que va a utilizar el FileReader
            File fichero = fileChosser.getSelectedFile();

            try {
                filasArchivo = principal.getLectorArchivos().leerFichero(fichero);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo");
                ex.printStackTrace();
            }
        }
        return filasArchivo;
    }

    public void mostrarTextArea() {
        principal.getPrincipalGUI().getAreaTexto().setText("");
        for (int i = 0; i < filasArchivo.size(); i++) {
            principal.getPrincipalGUI().getAreaTexto().append(filasArchivo.get(i));
            principal.getPrincipalGUI().getAreaTexto().append(System.getProperty("line.separator"));
        }
    }

    public void verificarTokens() {
        tokens = principal.getAnalizador().evaluarTextoTotal(filasArchivo);
    }

    public void abrirReporteErrores() {

        TablaResultados tabla = new TablaResultados();
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.getTabla().setModel(modelo);
        modelo.addColumn("CADENA DE ERROR");
        modelo.addColumn("FILA");
        modelo.addColumn("COLUMNA");

        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getTipo().equals(TipoToken.ERROR)) {
                modelo.addRow(new Object[]{tokens.get(i).getValor(), tokens.get(i).getFila(), tokens.get(i).getColumna()});
            }
        }
        tabla.setVisible(true);
    }

    public void abrirReporteTokens() {
        TablaResultados tabla = new TablaResultados();
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.getTabla().setModel(modelo);
        modelo.addColumn("TOKEN");
        modelo.addColumn("LEXEMA");
        modelo.addColumn("FILA");
        modelo.addColumn("COLUMNA");

        for (int i = 0; i < tokens.size(); i++) {
            if (!tokens.get(i).getTipo().equals(TipoToken.ERROR)) {
                modelo.addRow(new Object[]{tokens.get(i).getTipo().getNombre(), tokens.get(i).getValor(), tokens.get(i).getFila(), tokens.get(i).getColumna()});
            }
        }
        tabla.setVisible(true);

    }

    public void abrirRecuentoLexemas() {
        ArrayList<Contable> contables = recontarTokens();
        TablaResultados tabla = new TablaResultados();
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.getTabla().setModel(modelo);

        modelo.addColumn("LEXEMA");
        modelo.addColumn("TOKEN");
        modelo.addColumn("CANTIDAD");

        for (int i = 0; i < contables.size(); i++) {
            modelo.addRow(new Object[]{contables.get(i).getToken().getValor(), contables.get(i).getToken().getTipo().getNombre(), contables.get(i).getCantidad()});
        }
        tabla.setVisible(true);
    }

    public ArrayList<Contable> recontarTokens() {
        ArrayList<Token> tokensTemp = new ArrayList<>();
        ArrayList<Contable> contables = new ArrayList<>();
        boolean valorEncontrado = false;
        Token temp;
        Contable tempc;
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getTipo() != TipoToken.ERROR) {
                tokensTemp.add(tokens.get(i));
            }
        }

        for (int i = 0; i < tokensTemp.size(); i++) {
            valorEncontrado = false;
            temp = tokensTemp.get(i);
            if (contables.size() != 0) {
                for (int j = 0; j < contables.size(); j++) {
                    tempc = contables.get(j);
                    if (temp.getValor().equals(tempc.getToken().getValor())) {
                        contables.get(j).sumarUnidadCantidad();
                        valorEncontrado = true;
                        break;
                    }
                }
                if (!valorEncontrado) {
                    contables.add(new Contable(tokensTemp.get(i)));
                }
            } else {
                contables.add(new Contable(tokensTemp.get(i)));
            }

        }
        burbuja(contables);
        return contables;
    }
    
    public void burbuja(ArrayList<Contable> contables) {
        int i, j;
        Contable aux;
        for (i = 0; i < contables.size() - 1; i++) {
            for (j = 0; j < contables.size() - i - 1; j++) {
                //cambiar a <
                if (contables.get(j + 1).getCantidad() > contables.get(j).getCantidad()) {
                    aux = contables.get(j + 1);
                    contables.set(j+1, contables.get(j));
                    contables.set(j, aux);
                }
            }
        }
}

}
