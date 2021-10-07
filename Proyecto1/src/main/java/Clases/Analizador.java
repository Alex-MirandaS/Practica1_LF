/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Enums.TipoToken;
import Main.Principal;
import Objetos.Texto;
import Objetos.Token;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Analizador {

    private Lector lector = new Lector();

    //Se encarga de realizar las correcciones al texto y evaluarlo, fila por fila
    public ArrayList<Token> evaluarTextoTotal(ArrayList<String> filas) {
        ArrayList<Token> tokens = new ArrayList<>();
        ArrayList<Token> temp = null;
        for (int i = 0; i < filas.size(); i++) {
            temp = evaluarFilaTexto(filas.get(i), i + 1);
            for (int j = 0; j < temp.size(); j++) {
                tokens.add(temp.get(j));
            }
        }
        return tokens;
    }

    //Se encarga de evaluar el texto de una fila
    public ArrayList<Token> evaluarFilaTexto(String textoNormal, int fila) {
        ArrayList<Texto> textoSeparado = separar(textoNormal, fila);
        return verificar(textoSeparado);
    }

    /*Se encarga de separar el bloque de texto en una lista de palabras, 
    las cuales son determinadas por un salto de linea o un espacio*/
    public ArrayList<Texto> separar(String textoFila, int fila) {
        ArrayList<Texto> temporal = new ArrayList<>();
        String textoTemp = "";
        int i;
        for (i = 0; i < textoFila.length(); i++) {
            if (textoFila.charAt(i) != ' ') {
                textoTemp += textoFila.charAt(i);
            } else if (textoFila.charAt(i) == ' ' && textoTemp.length() != 0) {
                temporal.add(new Texto(textoTemp, fila, i));
                textoTemp = "";
            }
        }
        if (textoTemp.length() != 0) {
            temporal.add(new Texto(textoTemp, fila, i));
        }

        return temporal;
    }

//Se encarga de verificar cada una de las palabras de la lista, para identificar a que tipo de token podrian pertenecer
    private ArrayList<Token> verificar(ArrayList<Texto> textoSeparado) {
        ArrayList<Token> temp = new ArrayList<>();
        for (int i = 0; i < textoSeparado.size(); i++) {
            verificarTipoToken(textoSeparado.get(i), temp);
        }
        return temp;
    }

//Se encarga de clasificar el token al cual podria pertenecer una palabra, segun su caracter inicial
    private void verificarTipoToken(Texto texto, ArrayList<Token> lista) {
        char caracterInicial = texto.getValor().charAt(0);

        if (evaluarCHAR(caracterInicial, InformaciónTokens.alfabetoLetras)) {
            evaluarIdentificador(texto, lista);
        } else if (evaluarCHAR(caracterInicial, InformaciónTokens.alfabetoDigitos)) {
            evaluarNumero(texto, lista);
        } else if (evaluarCHAR(caracterInicial, InformaciónTokens.alfabetoSignosPuntuacion)) {
            evaluarPuntuacion(texto, lista);
        } else if (evaluarCHAR(caracterInicial, InformaciónTokens.alfabetoSignosOperacion)) {
            evaluarOperador(texto, lista);
        } else if (evaluarCHAR(caracterInicial, InformaciónTokens.alfabetoSignosAgrupacion)) {
            evaluarAgrupacion(texto, lista);
        } else {
            evaluarError(texto, lista);
        }
    }
//Se encarga de evaluar un texto, tomandolo como un posible identificador
    private void evaluarIdentificador(Texto texto, ArrayList<Token> lista) {
        int cCaracteres = lector.iniciarLector(texto, TipoToken.IDENTIFICADOR, lista);
        darSeguimiento(cCaracteres, texto, lista);
    }
//Se encarga de evaluar un texto, tomandolo como un posible numero
    private void evaluarNumero(Texto texto, ArrayList<Token> lista) {
        int cCaracteres = lector.iniciarLector(texto, TipoToken.NUMERO, lista);
        evaluarDecimal(cCaracteres, texto, lista);
    }
//Se encarga de evaluar un texto, tomandolo como un posible puntuacion
    private void evaluarPuntuacion(Texto texto, ArrayList<Token> lista) {
        int cCaracteres = lector.iniciarLector(texto, TipoToken.PUNTUACION, lista);
        darSeguimiento(cCaracteres, texto, lista);
    }
//Se encarga de evaluar un texto, tomandolo como un posible operador
    private void evaluarOperador(Texto texto, ArrayList<Token> lista) {
        int cCaracteres = lector.iniciarLector(texto, TipoToken.OPERADOR, lista);
        darSeguimiento(cCaracteres, texto, lista);
    }
//Se encarga de evaluar un texto, tomandolo como un posible agrupacion
    private void evaluarAgrupacion(Texto texto, ArrayList<Token> lista) {
        int cCaracteres = lector.iniciarLector(texto, TipoToken.AGRUPACION, lista);
        darSeguimiento(cCaracteres, texto, lista);
    }
//Se encarga de evaluar y tratar a un texto como error
    private void evaluarError(Texto texto, ArrayList<Token> lista) {
        lector.iniciarLector(texto, TipoToken.ERROR, lista);
    }
//Se encarga de verificar si un char en espeficico es parte del abecedario aceptado por el automata
    private boolean evaluarCHAR(char charEvaluado, String[] datos) {
        for (int i = 0; i < datos.length; i++) {
            if (String.valueOf(charEvaluado).equalsIgnoreCase(datos[i])) {
                return true;
            }
        }
        return false;
    }
//Se encarga de crear un nuevo texto con el residuo de uno fallido, ya que esto permite la recuperación de errores
    private Texto redimensionarTexto(Texto texto, int cCaracteres) {
        Texto textoTemp = null;
        char[] caracteres = texto.getValor().toCharArray();
        String nuevoTexto = "";
        for (int i = cCaracteres; i < texto.getValor().length(); i++) {
            nuevoTexto += caracteres[i];
        }
        textoTemp = new Texto(nuevoTexto, texto.getFila(), texto.getColumna());
        return textoTemp;
    }
/*Es el encargado de verficicar si es necesario seguir leyendo un texto en espeficico, solamente si el mismo contiene 
  residuos de texto  */
    private void darSeguimiento(int cCaracteres, Texto texto, ArrayList<Token> lista) {
        if (cCaracteres != texto.getValor().length()) {
            verificarTipoToken(redimensionarTexto(texto, cCaracteres), lista);
        }
    }
//Se encarga de evaluar un texto, tomandolo como un posible decimal
    private void evaluarDecimal(int cCaracteres, Texto texto, ArrayList<Token> lista) {

        if (cCaracteres != texto.getValor().length()) {
 
            if (lista.size() != 0) {
                lista.remove(lista.size() - 1);
            }
            int cCaracteres1 = lector.iniciarLector(texto, TipoToken.DECIMAL, lista);
            darSeguimiento(cCaracteres1, texto, lista);
        }
    }

    public Lector getLector() {
        return lector;
    }
    
}
