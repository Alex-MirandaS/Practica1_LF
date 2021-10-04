/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Alex
 */
public class Contable {

    private Token token;
    private int cantidad;

    public Contable(Token token) {
        this.token = token;
        this.cantidad = 1;
    }

    public Token getToken() {
        return token;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void sumarUnidadCantidad() {
        this.cantidad += 1;
    }

}
