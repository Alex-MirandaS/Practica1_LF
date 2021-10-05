/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class EscritorArchivosTexto {

    //donde se guardn los archivos
    private String ubicación = "/home/alex/Escritorio/6to Semestre Sistemas/LENGUAJES FORMALES Y DE PROGRAMACIÓN/Tareas/PRACTICA 1/";

    public void guardarArchivoTexto(String texto) throws IOException, FileNotFoundException {
        FileWriter fichero = new FileWriter(ubicación+"Archivo Guardado.txt");
        fichero.write(texto);
        fichero.close();
    }

}
