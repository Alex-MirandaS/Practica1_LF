/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Objetos.Texto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author richard
 */
public class LectorArchivosEnTexto {

    //File=archivo
    //FileReader necesita a un archivo para poder leerlo
    //BufferedReader lee el texto del archivo
    public ArrayList<String> leerFichero(File archivo) throws FileNotFoundException, IOException {
        ArrayList<String> textos = new ArrayList<>();
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        //int fila = 1;
        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
           textos.add(linea);
        }
        fr.close();
        return textos;
    }
}
