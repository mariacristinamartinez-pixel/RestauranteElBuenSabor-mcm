/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Utilidades {

   
   public static boolean validar() {
        int cantidadItems = 0;
        int indice = 0;

        while (indice < Datos.cantidades.length) {
            if (Datos.cantidades[indice] > 0) {
                cantidadItems++;
            }
            indice++;
        }

        if (cantidadItems == 0) {
            Datos.total = 0;
            Datos.temporal = "";
        }

        return cantidadItems > 0;
    }

    public static void reiniciar() {
        int indice = 0;

        while (indice < Datos.cantidades.length) {
            Datos.cantidades[indice] = 0;
            indice++;
        }

        Datos.total = 0;
        Datos.estadoMesa = 0;
        Datos.mesaActual = 0;
        Datos.temporal = "";
    }
}
