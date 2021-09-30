/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author Alex
 */
public enum TipoToken {

    IDENTIFICADOR("IDENTIFICADOR"),
    NUMERO("NUMERO"),
    DECIMAL("DECIMAL"),
    PUNTUACION("PUNTUACION"),
    AGRUPACION("AGRUPACION"),
    OPERADOR("OPERADOR"),
    ERROR("ERROR");

    private String nombre;

    private TipoToken(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
