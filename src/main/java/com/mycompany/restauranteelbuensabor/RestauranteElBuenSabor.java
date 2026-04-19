/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;
        boolean ejecutandoMenu = true;
        int intentosInvalidos = 0;

        System.out.println("========================================");
        System.out.println("    " + Datos.NOMBRE_RESTAURANTE);
        System.out.println("    " + Datos.DIRECCION);
        System.out.println("    NIT: " + Datos.NIT);
        System.out.println("========================================");

        while (ejecutandoMenu) {

            System.out.println("1. Ver carta");
            System.out.println("2. Agregar producto al pedido");
            System.out.println("3. Ver pedido actual");
            System.out.println("4. Generar factura");
            System.out.println("5. Nueva mesa");
            System.out.println("0. Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    ImprimirFactura.mostrarCartaMenu();
                    System.out.println();
                    break;

                case 2:
                    System.out.println("--- AGREGAR PRODUCTO ---");

                    System.out.print("Numero de producto (1-" + Datos.nombresProductos.length + "): ");
                    int numeroProducto = sc.nextInt();

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();

                    if (numeroProducto > 0 && numeroProducto <= Datos.nombresProductos.length) {

                        if (cantidad > 0) {

                            if (Datos.estadoMesa == 0) {
                                System.out.print("Ingrese numero de mesa: ");
                                Datos.mesaActual = sc.nextInt();

                                if (Datos.mesaActual <= 0) {
                                    Datos.mesaActual = 1;
                                }

                                Datos.estadoMesa = 1;
                            }

                            Datos.cantidades[numeroProducto - 1] += cantidad;

                            System.out.println("Producto agregado al pedido.");
                            System.out.println("  -> " + Datos.nombresProductos[numeroProducto - 1] + " x" + cantidad);

                        } else {
                            System.out.println("Cantidad invalida. Debe ser mayor a cero.");
                        }

                    } else {
                        System.out.println("Producto no existe.");
                    }

                    System.out.println();
                    break;

                case 3:
                    System.out.println();

                    if (Utilidades.validar()) {
                        ImprimirFactura.mostrarPedidoActual();
                    } else {
                        System.out.println("No hay productos en el pedido actual.");
                    }

                    System.out.println();
                    break;

                case 4:
                    System.out.println();

                    if (Utilidades.validar()) {

                        double total = Proceso.calcularTotalFactura();

                        System.out.println("Total calculado: $" + (int) total);

                        ImprimirFactura.imprimirFacturaCompleta();
                        System.out.println();

                    } else {
                        System.out.println("No hay productos en el pedido.");
                    }

                    break;

                case 5:
                    System.out.println();

                    Utilidades.reiniciar();

                    System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
                    System.out.println();

                    break;

                case 0:
                    ejecutandoMenu = false;
                    System.out.println("Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion no valida. Seleccione entre 0 y 5.");

                    intentosInvalidos++;

                    if (intentosInvalidos > 3) {
                        System.out.println("Demasiados intentos invalidos.");
                        intentosInvalidos = 0;
                    }

                    break;
            }
        }

        sc.close();
    }
}
