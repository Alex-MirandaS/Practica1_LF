/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Archivos.EscritorArchivosTexto;
import Archivos.LectorArchivosEnTexto;
import Clases.Analizador;
import Controladores.ControlPrincipal;
import GUI.PrincipalGUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alex
 */
public class Principal {

    //GUI
    private PrincipalGUI principalGUI = new PrincipalGUI(this);
    //CLASES
    private LectorArchivosEnTexto lectorArchivos = new LectorArchivosEnTexto();
    private EscritorArchivosTexto escritorArchivos = new EscritorArchivosTexto();
    private Analizador analizador = new Analizador();
    private ControlPrincipal controlPrincipal = new ControlPrincipal(this);

    public void inicio() {
        principalGUI.setVisible(true);
    }

    public void cargarArchivo() {
        controlPrincipal.seleccionarArchivo();
        controlPrincipal.mostrarTextArea();
    }

    public void guardarArchivo() {
        try {
            escritorArchivos.guardarArchivoTexto(principalGUI.getAreaTexto().getText(), "ARCHIVO GUARDADO");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reporteErrores() {
        controlPrincipal.verificarTokens();
        controlPrincipal.abrirReporteErrores();
    }

    public void reporteTokens() {
        controlPrincipal.verificarTokens();
        controlPrincipal.abrirReporteTokens();
    }

    public void recuentoLexemas() {
        controlPrincipal.verificarTokens();
        controlPrincipal.abrirRecuentoLexemas();
    }

    public PrincipalGUI getPrincipalGUI() {
        return principalGUI;
    }

    public LectorArchivosEnTexto getLectorArchivos() {
        return lectorArchivos;
    }

    public EscritorArchivosTexto getEscritorArchivos() {
        return escritorArchivos;
    }

    public Analizador getAnalizador() {
        return analizador;
    }

    public ControlPrincipal getControlPrincipal() {
        return controlPrincipal;
    }

}
