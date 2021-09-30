/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Enums.TipoToken;
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
    private boolean error;
    private String[] estadosAceptacion;
    private String[][] funcionDeTransicion;

//solo se cambia el estado actual
    public int iniciarLector(Texto texto, TipoToken tipo, ArrayList<Token> tokens) {

        reiniciarLector(tipo);

        boolean tokenValido = false;
        for (int i = 0; i < texto.getValor().length(); i++) {
            char actual = texto.getValor().charAt(i);
            tokenValido = verificarTokenValido(actual);
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
            tokens.add(new Token(cadena, 1, 1, tipo));
        } else {
            tokens.add(new Token(cadena, 1, 1, TipoToken.ERROR));
        }
        return cadena.length();
    }

    private boolean verificarTokenValido(char actual) {
        for (int j = 0; j < funcionDeTransicion.length; j++) {
            char tipoToken = obtenerTipoCaracter(actual);
            String primeraPosicion = funcionDeTransicion[j][0];
            String valor = funcionDeTransicion[j][1];
            String siguiente = funcionDeTransicion[j][2];

            if (primeraPosicion.equalsIgnoreCase(estadoActual) && valor.equalsIgnoreCase(String.valueOf(tipoToken))) {
                estadoActual = siguiente;
                cadena += actual;
                return true;
            }
        }
        cadena += actual;
        return false;
    }

    public char obtenerTipoCaracter(char actual) {

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

    private boolean evaluarCHAR(char charEvaluado, String[] datos) {
        for (int i = 0; i < datos.length; i++) {
            if (String.valueOf(charEvaluado).equalsIgnoreCase(datos[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarEstadosAceptacion() {
        for (int i = 0; i < estadosAceptacion.length; i++) {
            if (estadoActual.equalsIgnoreCase(estadosAceptacion[i])) {
                return true;
            }
        }
        return false;
    }

    private void reiniciarLector(TipoToken tipo) {
        this.tipo = tipo;
        definirEstadosYFuncion(tipo);
        estadoActual = "S0";
        cadena = "";
    }
}
