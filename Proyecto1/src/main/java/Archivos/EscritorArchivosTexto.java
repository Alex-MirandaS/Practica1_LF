/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
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

    //donde se guardan los archivos
    private String ubicación = "archivos/Archivo Guardado.txt";

    public void guardarArchivoTexto(String texto) throws IOException, FileNotFoundException {
        File archivo = new File(ubicación);
        File temp = new File(archivo.getParentFile().getAbsolutePath());
        if (!temp.exists()) {
            temp.mkdirs();
        }
        FileWriter fichero = new FileWriter(archivo);
        fichero.write(texto);
        fichero.close();
    }

}
