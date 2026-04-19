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

    public static void imprimirEncabezado() {
        String sep = "========================================";
        System.out.println(sep);
        System.out.println("    " + Datos.NOMBRE_RESTAURANTE);
        System.out.println("    " + Datos.DIRECCION);
        System.out.println("    NIT: " + Datos.NIT);
        System.out.println(sep);

    }

    public static void mostrarCartaMenu() {
        System.out.println("========================================");
        System.out.println("    " + Datos.NOMBRE_RESTAURANTE);
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");

        int indice = 0;

        while (indice < Datos.nombresProductos.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (indice + 1), Datos.nombresProductos[indice],
                    Datos.precios[indice]);
            indice++;
        } // fin while
        System.out.println("========================================");
    }

    public static void mostrarPedidoActual() {
        double subtotal = Proceso.calcularSubtotal();

        System.out.println("--- PEDIDO ACTUAL ---");

        int indice = 0;
        while (indice < Datos.nombresProductos.length) {

            if (Datos.cantidades[indice] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n",
                        Datos.nombresProductos[indice],
                        Datos.cantidades[indice],
                        Datos.precios[indice] * Datos.cantidades[indice]);
            }

            indice++;
        }

        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
    }

     public static void imprimirFacturaCompleta() {

        imprimirEncabezado();

        System.out.printf("FACTURA No. %03d%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");

        int indice = 0;

        while (indice < Datos.nombresProductos.length) {
            if (Datos.cantidades[indice] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n",
                        Datos.nombresProductos[indice],
                        Datos.cantidades[indice],
                        Datos.precios[indice] * Datos.cantidades[indice]);
            }
            indice++;
        }

        System.out.println("----------------------------------------");

        double subtotal = Proceso.calcularSubtotal();
        int items = Proceso.contarItems();
        double base = Proceso.aplicarDescuento(subtotal, items);
        double iva = Proceso.calcularIVA(base);
        double total = base + iva;
        double propina = Proceso.calcularPropina(total);
        total += propina;

        System.out.printf("%-27s $%,.0f%n", "Subtotal:", base);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);

        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);

        System.out.println("========================================");
        System.out.println("Gracias por su visita!");
        System.out.println(Datos.NOMBRE_RESTAURANTE + " - Valledupar");
        System.out.println("========================================");

        Datos.numeroFactura++;
        Datos.estadoMesa = 0;
        Datos.total = total;
    }

    public static void imprimirFacturaResumen() {

        imprimirEncabezado();

        System.out.printf("FACTURA No. %03d (RESUMEN)%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");

        double subtotal = Proceso.calcularSubtotal();
        int items = Proceso.contarItems();
        double base = Proceso.aplicarDescuento(subtotal, items);
        double iva = Proceso.calcularIVA(base);
        double total = base + iva;
        double propina = Proceso.calcularPropina(total);
        total += propina;

        System.out.printf("%-27s $%,.0f%n", "Subtotal:", base);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);

        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);

        System.out.println("========================================");
    }
}
