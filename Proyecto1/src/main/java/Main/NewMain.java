/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Clases.Analizador;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("INTRODUZCA VALORES");
        String valores = scanner.nextLine();
        
        Analizador analizador = new Analizador();
        //analizador.evaluarTexto(valores);
    }
    
}
