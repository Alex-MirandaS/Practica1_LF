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
public class Lector {

    private String estadoActual = "S0";
    private String cadena = "";
    private TipoToken tipo;
    private String[] estadosAceptacion;
    private String[][] funcionDeTransicion;
    private ArrayList<String> movimientos;
    private ArrayList<ArrayList<String>> movimientosTotales = new ArrayList<>();

//Se encarga de iniciar el Lector, con un texto y el tipo de token posible, y el arreglo en donde se guardará el resultado
    public int iniciarLector(Texto texto, TipoToken tipo, ArrayList<Token> tokens) {

        reiniciarLector(tipo);

        boolean tokenValido = false;
        int columnaInicio = texto.getColumna() - texto.getValor().length();
        if (tipo != TipoToken.ERROR) {
            añadirPalabraRegistro(texto.getValor());
            for (int i = 0; i < texto.getValor().length(); i++) {
                char actual = texto.getValor().charAt(i);
                tokenValido = verificarTokenValido(actual);
                columnaInicio++;
                if (tipo.equals(TipoToken.DECIMAL)) {
                    if (tokenValido == false) {
                        break;
                    }
                } else {
                    if (tokenValido == false || !verificarEstadosAceptacion()) {
                        break;
                    }
                }
            }
            if (tokenValido == true && verificarEstadosAceptacion()) {
                tokens.add(new Token(cadena, texto.getFila(), texto.getColumna(), tipo));
            } else {
                tokens.add(new Token(cadena, texto.getFila(), columnaInicio, TipoToken.ERROR));
            }
        } else {
            tokens.add(new Token(texto.getValor(), texto.getFila(), texto.getColumna(), TipoToken.ERROR));
        }

        return cadena.length();
    }
//Es el encargado de realizar los movimientos respectivos del automata, siguiendo las transiciones
    private boolean verificarTokenValido(char actual) {
        for (int j = 0; j < funcionDeTransicion.length; j++) {
            char tipoToken = obtenerTipoCaracter(actual);
            String primeraPosicion = funcionDeTransicion[j][0];
            String valor = funcionDeTransicion[j][1];
            String siguiente = funcionDeTransicion[j][2];

            if (primeraPosicion.equalsIgnoreCase(estadoActual) && valor.equalsIgnoreCase(String.valueOf(tipoToken))) {
                añadirMovimientoRegistro(siguiente, actual);
                estadoActual = siguiente;
                cadena += actual;
                return true;
            }
        }
        guardarMovimientosTotales();
        cadena += actual;
        return false;
    }
//Evalua un caracter y devuelve el tipo de caracter al que pertenece segun el alfabeto
    private char obtenerTipoCaracter(char actual) {

        if (evaluarCHAR(actual, InformaciónTokens.alfabetoLetras)) {
            return 'L';
        } else if (evaluarCHAR(actual, InformaciónTokens.alfabetoDigitos)) {
            return 'D';
        } else if (evaluarCHAR(actual, InformaciónTokens.alfabetoDigitos)) {
            return 'D';
        } else if (evaluarCHAR(actual, InformaciónTokens.alfabetoSignosOperacion)) {
            return 'O';
        } else if (evaluarCHAR(actual, InformaciónTokens.alfabetoSignosAgrupacion)) {
            return 'A';
        } else {
            if (tipo.equals(TipoToken.DECIMAL)) {
                if (String.valueOf(actual).equalsIgnoreCase(".")) {
                    return 'P';
                }
            } else if (evaluarCHAR(actual, InformaciónTokens.alfabetoSignosPuntuacion)) {
                return 'S';
            } else {
                return 'E';
            }
        }
        return 'E';
    }
/*Se encarga de otorgarle los valores al lector, tanto los estados de aceptación y la funcion de transicion
  dependiendo del tipo del token del cual se va a evaluar*/
    private void definirEstadosYFuncion(TipoToken tipo) {
        switch (tipo) {
            case IDENTIFICADOR:
                this.estadosAceptacion = InformaciónTokens.estadosAceptacionIdentificador;
                this.funcionDeTransicion = InformaciónTokens.funcionTransicionIdentificador;
                break;
            case NUMERO:
                this.estadosAceptacion = InformaciónTokens.estadosAceptacionNumero;
                this.funcionDeTransicion = InformaciónTokens.funcionTransicionNumero;
                break;
            case DECIMAL:
                this.estadosAceptacion = InformaciónTokens.estadosAceptacionDecimal;
                this.funcionDeTransicion = InformaciónTokens.funcionTransicionDecimal;
                break;
            case PUNTUACION:
                this.estadosAceptacion = InformaciónTokens.estadosAceptacionPuntuacion;
                this.funcionDeTransicion = InformaciónTokens.funcionTransicionPuntuacion;
                break;
            case OPERADOR:
                this.estadosAceptacion = InformaciónTokens.estadosAceptacionOperador;
                this.funcionDeTransicion = InformaciónTokens.funcionTransicionOperador;
                break;
            case AGRUPACION:
                this.estadosAceptacion = InformaciónTokens.estadosAceptacionAgrupacion;
                this.funcionDeTransicion = InformaciónTokens.funcionTransicionAgrupacion;
                break;
        }

    }
//Devuelve una verificación si el char enviado existe dentro de un alfabeto en especifico
    private boolean evaluarCHAR(char charEvaluado, String[] datos) {
        for (int i = 0; i < datos.length; i++) {
            if (String.valueOf(charEvaluado).equalsIgnoreCase(datos[i])) {
                return true;
            }
        }
        return false;
    }
//Verifica si el estado actual corresponde a un estado de aceptación
    private boolean verificarEstadosAceptacion() {
        for (int i = 0; i < estadosAceptacion.length; i++) {
            if (estadoActual.equalsIgnoreCase(estadosAceptacion[i])) {
                return true;
            }
        }
        return false;
    }
//Es el encargado de reiniciar el lector, segun el tipo de token nuevo que se evaluara
    private void reiniciarLector(TipoToken tipo) {
        this.tipo = tipo;
        definirEstadosYFuncion(tipo);
        estadoActual = "S0";
        cadena = "";
    }
//Se encarga de agregar una nueva palabra al registro de AFD optimo
    private void añadirPalabraRegistro(String token) {
        movimientos = new ArrayList<>();
        movimientos.add(token);
    }
//Se encarga de agregar un nuevo movimiento al registro de AFD optimo
    private void añadirMovimientoRegistro(String estado, char valor) {
        movimientos.add("Me moví del estado " + estadoActual + " al estado " + estado + " con una " + valor);
    }
//Se encarga de guardar y agregar el registro total de una palabra a una lista con todos los registros de todos los lexemas
    private void guardarMovimientosTotales() {
        movimientosTotales.add(movimientos);
    }

    public ArrayList<ArrayList<String>> getMovimientosTotales() {
        return movimientosTotales;
    }
    
}
