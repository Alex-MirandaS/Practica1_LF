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
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

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

    public void guardarArchivo() {

        try {
            principal.getEscritorArchivos().guardarArchivoTexto(principal.getPrincipalGUI().getAreaTexto().getText());
             JOptionPane.showMessageDialog(null, "ARCHIVO GUARDADO, SE NECESITA VOLVER A ABRIRLO");
             principal.getPrincipalGUI().getAreaTexto().setText("");
        } catch (IOException ex) {
            Logger.getLogger(ControlPrincipal.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void mostrarTextArea(JTextArea areaTexto) {
        areaTexto.setText("");
        for (int i = 0; i < filasArchivo.size(); i++) {
            areaTexto.append(filasArchivo.get(i));
            areaTexto.append(System.getProperty("line.separator"));
        }
    }

    public void verificarTokens() {
        tokens = principal.getAnalizador().evaluarTextoTotal(filasArchivo);
    }

    public void mostrarReportes() {
        verificarTokens();
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getTipo().equals(TipoToken.ERROR)) {
                principal.getReportesGUI().getrErrores().setEnabled(true);
                principal.getReportesGUI().getrLexemas().setEnabled(false);
                principal.getReportesGUI().getrTokens().setEnabled(false);
                break;
            }
            principal.getReportesGUI().getrErrores().setEnabled(false);
            principal.getReportesGUI().getrLexemas().setEnabled(true);
            principal.getReportesGUI().getrTokens().setEnabled(true);
        }
        principal.getReportesGUI().setVisible(true);
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

    public void abrirReporteAFD() {

        TablaResultados tabla = new TablaResultados();
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.getTabla().setModel(modelo);
        modelo.addColumn("REPORTE AFD OPTIMO");
        for (int i = 0; i < principal.getAnalizador().getLector().getMovimientosTotales().size(); i++) {
            modelo.addRow(new Object[]{principal.getAnalizador().getLector().getMovimientosTotales().get(i).get(0)});
            for (int j = 1; j < principal.getAnalizador().getLector().getMovimientosTotales().get(i).size(); j++) {
                modelo.addRow(new Object[]{"        " + principal.getAnalizador().getLector().getMovimientosTotales().get(i).get(j)});
            }
            tabla.setVisible(true);
        }
    }

    public void abrirBusquedaPatrones() {
        principal.getBusquedaGUI().setVisible(true);
    }

    
    public void buscarPatron(JTextArea areaTexto, String texto) {
        if (texto.length() >= 1) {
            DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
            Highlighter h = areaTexto.getHighlighter();
            h.removeAllHighlights();
            String text = areaTexto.getText();
            String caracteres = texto;
            Pattern p = Pattern.compile("(?i)" + caracteres);
            Matcher m = p.matcher(text);
            while (m.find()) {
                try {
                    h.addHighlight(m.start(), m.end(), highlightPainter);
                } catch (BadLocationException ex) {
                    Logger.getLogger(Color.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(areaTexto, "la palabra a buscar no puede ser vacia");
        }
    }

    public void burbuja(ArrayList<Contable> contables) {
        int i, j;
        Contable aux;
        for (i = 0; i < contables.size() - 1; i++) {
            for (j = 0; j < contables.size() - i - 1; j++) {
                //cambiar a <
                if (contables.get(j + 1).getCantidad() > contables.get(j).getCantidad()) {
                    aux = contables.get(j + 1);
                    contables.set(j + 1, contables.get(j));
                    contables.set(j, aux);
                }
            }
        }
    }

}
