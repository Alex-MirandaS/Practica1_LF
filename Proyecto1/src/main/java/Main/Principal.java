/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Archivos.EscritorArchivosTexto;
import Archivos.LectorArchivosEnTexto;
import Clases.Analizador;
import Controladores.ControlPrincipal;
import GUI.BusquedaGUI;
import GUI.PrincipalGUI;
import GUI.ReportesGUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public class Principal {

    //GUI
    private PrincipalGUI principalGUI = new PrincipalGUI(this);
    private ReportesGUI reportesGUI = new ReportesGUI(this);
    private BusquedaGUI busquedaGUI;
    //CLASES
    private LectorArchivosEnTexto lectorArchivos = new LectorArchivosEnTexto();
    private EscritorArchivosTexto escritorArchivos = new EscritorArchivosTexto();
    private Analizador analizador = new Analizador();
    private ControlPrincipal controlPrincipal = new ControlPrincipal(this);

    public void inicio() {
        principalGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        principalGUI.setVisible(true);
    }

    public void cargarArchivo() {
        controlPrincipal.seleccionarArchivo();
        controlPrincipal.mostrarTextArea(principalGUI.getAreaTexto());
    }

    public void guardarArchivo() {
        controlPrincipal.guardarArchivo();
    }

    public void reportes() {
        controlPrincipal.mostrarReportes();
    }

    public void reporteErrores() {
        controlPrincipal.abrirReporteErrores();
    }

    public void reporteTokens() {
        controlPrincipal.abrirReporteTokens();
    }

    public void recuentoLexemas() {
        controlPrincipal.abrirRecuentoLexemas();
    }

    public void reporteAFD() {
        controlPrincipal.abrirReporteAFD();
    }

    public void busquedaPatrones() {
        busquedaGUI = new BusquedaGUI(this);
        busquedaGUI.setVisible(true);
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

    public ReportesGUI getReportesGUI() {
        return reportesGUI;
    }

    public BusquedaGUI getBusquedaGUI() {
        return busquedaGUI;
    }

}
