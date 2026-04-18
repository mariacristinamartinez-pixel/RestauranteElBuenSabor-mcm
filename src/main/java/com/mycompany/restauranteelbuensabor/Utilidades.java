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

    public static double calcular(
            double precio,
            double cantidad,
            double descuento,
            double porcentajeIVA,
            double porcentajePropina,
            int numeroItems,
            boolean aplicarPropina) {

        double resultado = 0;
        double ivacalculado = 0;
        double resultadoFinal = 0;

// calcula el resultado
        resultado = precio * cantidad;

        if (descuento > 0) {
            resultado = resultado - (resultado * descuento);
        }

        ivacalculado = resultado * porcentajeIVA;
        resultado = resultado + ivacalculado;

        if (aplicarPropina) {
            resultado = resultado + (resultado * porcentajePropina);
        }
// imprime restaurante
        System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado");

        resultadoFinal = resultado;

        return resultadoFinal;

    }

    public static boolean validar() {
        int cantidadItems = 0;
        int indice = 0;

        while (indice < Datos.cantidades.length) {
            if (Datos.cantidades[indice] > 0) {
                cantidadItems = cantidadItems + 1;

            }

            indice++;

        } // fin while
        // reinicia si no hay nada - efecto secundario no documentado
        if (cantidadItems == 0) {

            Datos.total = 0;

            Datos.temporal = "";

        }

        return cantidadItems> 0;

    }

    public static void reiniciar() {
// metodo antiguo de calculo - pendiente revisar
// public static double calcOld(double precio, int cant){
// double resultado = 0;
// resultado = precio * cant;
// resultado = resultado + (resultado * 0.19);
// if(resultado > 50000){
// resultado = resultado + (resultado * 0.10);}
// System.out.println("RESTAURANTE EL BUEN SABOR");
// System.out.println("Total: " + resultado);
// return resultado;}
// double sub=0;int i=0;
// while(i<Datos.nom.length){
// sub=sub+Datos.p[i]*Datos.cant[i];i++;}
// if(sub>50000){ sub=sub+(sub*0.19); sub=sub+(sub*0.10); }
// else{ sub=sub+(sub*0.19); }
// Datos.tot=sub;
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
