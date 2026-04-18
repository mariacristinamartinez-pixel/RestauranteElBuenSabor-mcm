/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class ImprimirFactura {

    public static void mostrarCartaMenu() {
        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");

        int indice = 0;

        while (indice < Datos.nombresProductos.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (indice + 1), Datos.nombresProductos[indice], Datos.precios[indice]);
            indice++;
        } // fin while
        System.out.println("========================================");
    }

    public static void mostrarPedidoActual() {

        double subtotal = 0;
        int indice = 0;

        System.out.println("--- PEDIDO ACTUAL ---");

        while (indice < Datos.nombresProductos.length) {

            if (Datos.cantidades[indice] > 0) {
               // imprime producto con cantidad y subtotal parcial
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombresProductos[indice], Datos.cantidades[indice],
                        (Datos.precios[indice] * Datos.cantidades[indice]));
                 // suma al subtotal
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];

            }
            indice++;
        }  // fin while
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);

    }

    public static void imprimirFacturaCompleta() {
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        double propina = 0;
        int cantidadItems = 0;
        double subtotalDescuento = 0;
         // calcula subtotal otra vez
        int indice = 0;
        while (indice < Datos.nombresProductos.length) {

            if (Datos.cantidades[indice] > 0) {

                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
                cantidadItems = cantidadItems + 1;

            }

            indice++;

        } // fin while
        if (cantidadItems > 3) {

          subtotalDescuento = subtotal - (subtotal * 0.05);

        } else {

            subtotalDescuento = subtotal;
        }

        if (subtotalDescuento > 50000) {

            iva = subtotalDescuento * 0.19;
            total = subtotalDescuento + iva;
            propina = total * 0.10;
            total = total + propina;

        } else {

            iva = subtotalDescuento * 0.19;
            total = subtotalDescuento + iva;
            propina= 0;

        } // fin if-else

        String sep = "========================================";
        System.out.println(sep);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(sep);
        System.out.printf("FACTURA No. %03d%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");
// imprime cada item del pedido

        indice = 0;

        while (indice < Datos.nombresProductos.length) {

            if (Datos.cantidades[indice] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombresProductos[indice], Datos.cantidades[indice],
                        (Datos.precios[indice] * Datos.cantidades[indice]));

            }

            indice++;

        } // fin while

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotalDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);

        if (propina > 0) {

            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);

        } // fin if prop

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(sep);
        System.out.println("Gracias por su visita!");
        System.out.println("El Buen Sabor - Valledupar");
        System.out.println(sep);
       // actualiza estado e incrementa factura - tres responsabilidades en un metodo

        Datos.numeroFactura = Datos.numeroFactura + 1;
        Datos.estadoMesa = 0;
        Datos.total = total;

    }

    public static void imprimirFacturaResumen() {
        double subtotal = 0;
        double iva = 0;
        double total= 0;
        double propina = 0;
        int cantidadItems = 0;
        double subtotalDescuento= 0;

        // calcula subtotal otra vez igual que en imprimirFacturaCompleta
        int indice = 0;

        while (indice < Datos.nombresProductos.length) {
            if (Datos.cantidades[indice] > 0) {

                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
                cantidadItems = cantidadItems + 1;

            }

            indice++;

        }// fin while
        if (cantidadItems > 3) {
           subtotalDescuento= subtotal - (subtotal * 0.05);
        } else {
            subtotalDescuento = subtotal;
        }
        if (subtotalDescuento > 50000) {
            iva = subtotalDescuento * 0.19;
            total = subtotalDescuento+ iva;
            propina = total * 0.10;
            total = total + propina;
        } else {
            iva = subtotalDescuento * 0.19;
            total= subtotalDescuento + iva;
            propina = 0;
        }// fin if-else
        String sep = "========================================";
        System.out.println(sep);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(sep);
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotalDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);
        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);
        }// fin if prop
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(sep);
    }
}
