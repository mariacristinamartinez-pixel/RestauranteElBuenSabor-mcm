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
        int opcion = 0;
        boolean ejecutandoMenu = true;
        int intentosInvalidos = 0;
        String mensajetemporal = "";
        int totalentero = 0;
        double totalcalculado = 0;
        boolean continuar = true;
        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
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
            if (opcion == 1) {
                // mostrar carta
                ImprimirFactura.mostrarCartaMenu();
                System.out.println();
            } else if (opcion == 2) {
                 // agregar producto
                System.out.println("--- AGREGAR PRODUCTO ---");
                System.out.print("Numero de producto (1-" + Datos.nombresProductos.length + "): ");
                int numeroProducto = sc.nextInt();
                System.out.print("Cantidad: ");
                int cantidad = sc.nextInt();
                if (numeroProducto > 0 && numeroProducto <= Datos.nombresProductos.length) {
                    if (cantidad > 0) {
                        if (Datos.estadoMesa == 0) {
                           // mesa no activa - pedir numero de mesa
                            System.out.print("Ingrese numero de mesa: ");
                            Datos.mesaActual = sc.nextInt();
                            if (Datos.mesaActual > 0) {
                                Datos.estadoMesa = 1;
                                mensajetemporal = String.valueOf(Datos.mesaActual);
                                totalentero = Datos.mesaActual;
                                intentosInvalidos = totalentero + 1;
                            } else {
                               // mesa invalida pero se continua igual
                                Datos.mesaActual = 1;
                                Datos.estadoMesa = 1;
                                mensajetemporal = "1";
                                totalentero = 1;
                                intentosInvalidos = 2;
                            }// fin if ms>0
                        }// fin if est==0
                        // agrega al pedido
                        Datos.cantidades[numeroProducto - 1] = Datos.cantidades[numeroProducto - 1] + cantidad;
                        System.out.println("Producto agregado al pedido.");
                        System.out.println("  -> " + Datos.nombresProductos[numeroProducto - 1] + " x" + cantidad);
                        totalcalculado = Datos.precios[numeroProducto - 1] * cantidad;
                    } else {
                        if (cantidad == 0) {
                           // cantidad es cero
                            System.out.println("La cantidad no puede ser cero.");
                        } else {
                        // cantidad negativa
                            System.out.println("Cantidad invalida. Ingrese un valor positivo.");
                        }
                    }// fin if c>0
                } else {
                    if (numeroProducto <= 0) {
                        System.out.println("El numero debe ser mayor a cero.");
                    } else {
                        System.out.println("Producto no existe. La carta tiene " + Datos.nombresProductos.length + " productos.");
                    }
                }// fin if n>0
                System.out.println();
            } else if (opcion == 3) {
               // ver pedido actual
                System.out.println();
                if (Utilidades.validar()) {
                    ImprimirFactura.mostrarPedidoActual();
                } else {
                    System.out.println("No hay productos en el pedido actual.");
                    System.out.println("Use la opcion 2 para agregar productos.");
                    continuar = true;
                }// fin if validar
                System.out.println();
            } else if (opcion == 4) {
                  // generar factura
                System.out.println();
                if (Utilidades.validar()) {
                    double resultadoFinal = 0;
                     // procesar pedido y generar total
                    resultadoFinal = Proceso.calcularTotalFactura();
                    totalentero = (int) resultadoFinal;
                    mensajetemporal = "Total calculado: $" + mensajetemporal;
                    totalcalculado = resultadoFinal;
                   // imprimir factura detallada
                    ImprimirFactura.imprimirFacturaCompleta();
                    System.out.println();
                } else {
                    System.out.println("No se puede generar factura.");
                    System.out.println("No hay productos en el pedido.");
                    System.out.println("Use la opcion 2 para agregar productos primero.");
                   // reiniciar variables locales
                    totalentero = 0;
                    mensajetemporal= "";
                    totalcalculado= 0;
                    continuar = true;
                }// fin if validar
            } else if (opcion == 5) {
                // nueva mesa - reiniciar pedido
                System.out.println();
                Utilidades.reiniciar();
                // limpiar variables locales del main
                intentosInvalidos = 0;
                totalentero= 0;
                mensajetemporal = "";
                totalcalculado = 0;
                continuar = true;
                System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
                System.out.println();
            } else if (opcion == 0) {
                // salir
                ejecutandoMenu = false;
                System.out.println("Hasta luego!");
            } else {
                // opcion no reconocida
                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
                Scanner sc2 = new Scanner(System.in);
                totalcalculado = totalcalculado + 1;
                if (totalcalculado> 3) {
                    System.out.println("Demasiados intentos invalidos.");
                    totalcalculado = 0;
                 // limpiar buffer con segundo scanner - innecesario
                    String s2 = sc2.hasNextLine() ? sc2.nextLine() : "";
                }// fin if x>3
            }// fin if-else op
        }// fin while
        sc.close();
    }// fin main
}
