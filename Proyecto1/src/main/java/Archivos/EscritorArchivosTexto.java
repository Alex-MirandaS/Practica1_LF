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

    //donde se guardn los archivos binarios
    private String ubicación;

    public EscritorArchivosTexto(String ubicación) {
        this.ubicación = ubicación;
    }

    public void guardarArchivoTexto(ArrayList<String> filasTexto, String nombre) throws IOException, FileNotFoundException {
        FileWriter fichero = new FileWriter(ubicación+nombre+".txt");
        for (int i = 0; i < filasTexto.size(); i++) {
            fichero.write(filasTexto.get(i)+"\n");
        }
        fichero.close();
    }

}
