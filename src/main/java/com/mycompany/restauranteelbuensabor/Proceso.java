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
    
    
    public static double calcularSubtotal(){
        double subtotal = 0;
        int indice = 0;

        while (indice < Datos.nombresProductos.length) {
            if (Datos.cantidades[indice] > 0) {
                subtotal += Datos.precios[indice] * Datos.cantidades[indice];
            }
            indice++;
        }
        
        return 0;
        
    }
    
    public static int contarItems(){
        int cantidadItems = 0;
        int indice = 0;

        while (indice < Datos.nombresProductos.length) {
            if (Datos.cantidades[indice] > 0) {
                cantidadItems++;
            }
            indice++;
        }

        return cantidadItems;
        
    }
    
    public static double calcularIVA(double base) {
        return base * Datos.TASA_IVA;
    }
    
    public static double aplicarDescuento(double subtotal, int cantidadItems) {
        if (cantidadItems > Datos.MIN_ITEMS_DESCUENTO) {
            return subtotal - (subtotal * Datos.TASA_DESCUENTO);
        }
        return subtotal;
    }
    public static double calcularPropina(double totalParcial) {
        if (totalParcial > Datos.UMBRAL_PROPINA) {
            return totalParcial * Datos.TASA_PROPINA;
        }
        return 0;
    }
    
    

   public static double calcularTotalFactura() {

        double subtotal = calcularSubtotal();
        int cantidadItems = contarItems();

        double base = aplicarDescuento(subtotal, cantidadItems);
        double iva = calcularIVA(base);

        double total = base + iva;

        double propina = calcularPropina(total);
        total += propina;

        Datos.total= total;
        Datos.estadoMesa = 1;

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

        double resultado = precio * cantidad;

        if (descuento > 0) {
            resultado -= (resultado * descuento);
        }

        double iva = resultado * porcentajeIVA;
        resultado += iva;

        if (aplicarPropina) {
            double propina = resultado * porcentajePropina;
            resultado += propina;
        }

        if (numeroItems > 3) {
            resultado -= (resultado * 0.01);
        }

        return resultado;
    }
}
