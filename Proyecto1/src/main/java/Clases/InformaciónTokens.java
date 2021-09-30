/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Alex
 */
public class InformaciónTokens {

    /*DATOS DE LOS TOKENS
    Se incluyen los alfabetos, estados de aceptación y función de transición correspondiente a cada uno de los tipos de token disponibles
    L = Letra
    D = Digito (numero)
    P = Punto
    S = Signo de puntuación
    O = Signo de Operación
    A = Signo de Agrupación
    
     */
    public static final String[] alfabetoLetras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
        "t", "u", "v", "w", "x", "y", "z"};
    public static final String[] alfabetoDigitos = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static final String[] alfabetoSignosPuntuacion = {".", ",", ";", ":"};
    public static final String[] alfabetoSignosOperacion = {"+", "-", "*", "/", "%"};
    public static final String[] alfabetoSignosAgrupacion = {"(", ")", "[", "]", "{", "}"};

    //IDENTIFICADOR
    public static final String[] estadosAceptacionIdentificador = {"S1"};
    public static final String[][] funcionTransicionIdentificador
            = {{"S0", "L", "S1"}, {"S0", "D", "ERROR"},
            {"S1", "L", "S1"}, {"S1", "D", "S1"}};
    //NUMERO
    public static final String[] estadosAceptacionNumero = {"S1"};
    public static final String[][] funcionTransicionNumero
            = {{"S0", "D", "S1"},
            {"S1", "D", "S1"}};
    //DECIMAL
    public static final String[] estadosAceptacionDecimal = {"S3"};
    public static final String[][] funcionTransicionDecimal
            = {{"S0", "D", "S1"}, {"S0", "P", "ERROR"},
            {"S1", "D", "S1"}, {"S1", "P", "S2"},
            {"S2", "D", "S3"}, {"S2", "P", "ERROR"},
            {"S3", "D", "S3"}, {"S1", "P", "ERROR"}};
    //PUNTUACION
    public static final String[] estadosAceptacionPuntuacion = {"S1"};
    public static final String[][] funcionTransicionPuntuacion
            = {{"S0", "S", "S1"},
            {"S1", "S", "ERROR"}};
    //OPERADOR
    public static final String[] estadosAceptacionOperador = {"S1"};
    public static final String[][] funcionTransicionOperador
            = {{"S0", "O", "S1"},
            {"S1", "O", "ERROR"}};
    //AGRUPACION
    public static final String[] estadosAceptacionAgrupacion = {"S1"};
    public static final String[][] funcionTransicionAgrupacion
            = {{"S0", "A", "S1"},
            {"S1", "A", "ERROR"}};

}
