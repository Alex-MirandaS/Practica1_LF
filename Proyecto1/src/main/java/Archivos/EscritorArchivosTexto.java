/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author richard
 */
public class EscritorArchivosTexto<T> {

    //donde se guardn los archivos
    private String ubicación = "/home/alex/Escritorio/6to Semestre Sistemas/LENGUAJES FORMALES Y DE PROGRAMACIÓN/Tareas/PRACTICA 1/";

    public void guardarArchivoTexto(String texto, String nombre) throws IOException, FileNotFoundException {
        FileWriter fichero = new FileWriter(ubicación + nombre + ".txt");
        fichero.write(texto);
        fichero.close();
    }

}
