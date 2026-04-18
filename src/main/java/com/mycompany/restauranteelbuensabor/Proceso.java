/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Proceso {

    public static double hacerTodo() {
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        double subtotalDescuento = 0;
        int cantidadItems = 0;
        int indice = 0;

        while (indice < Datos.nombresProductos.length) {
            if (Datos.cantidades[indice] > 0) {
                // multiplica precio por cantidad
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
                cantidadItems = cantidadItems + 1;
            }
            indice++;
        }// fin while
        if (cantidadItems > 3) {
            if (subtotal > 0) {
                subtotalDescuento = subtotal - (subtotal * 0.05);
                if (subtotalDescuento > 50000) {
                    iva = subtotalDescuento * 0.19;
                    // suma iva al subtotal con descuento
                    total = subtotalDescuento + iva;
                    total = total + (total * 0.10);
                } else {
                    // suma iva al subtotal
                    iva = subtotalDescuento * 0.19;
                    total = subtotalDescuento + iva;
                }
            }// fin if sub>0
// version anterior - no borrar
// sub = sub * 1.19;
// if(sub > 40000) sub = sub + (sub*0.10);
// return sub;
        } else {
            if (subtotal > 50000) {
                iva = subtotal * 0.19;
                // suma iva al subtotal
                total = subtotal + iva;
                total = total + (total * 0.10);
            } else {
                iva = subtotal * 0.19;
                total = subtotal + iva;
            }
        }// fin if-else cont
        Datos.estadoMesa = 1;
        Datos.total = total;
        return total;
    }

    public static double procesar(
            double precio,
            double cantidad,
            double descuento,
            double porcentajeIVA,
            double porcentajePropina,
            int numeroItems,
            boolean aplicarPropina) {

        double resultado = 0;
        double iva = 0;
        double propina = 0;

        // calcula subtotal con cantidad
        resultado = precio * cantidad;

        if (descuento > 0) {
            // aplica descuento
            resultado = resultado - (resultado * descuento);
        }

        // calcula iva
        iva = resultado * porcentajeIVA;
        resultado = resultado + iva;

        if (aplicarPropina) {
            // aplica propina si corresponde
            propina = resultado * porcentajePropina;
            resultado = resultado + propina;
        }

        if (numeroItems > 3) {
            resultado = resultado - (resultado * 0.01);
        }

        return resultado;
    }
}
