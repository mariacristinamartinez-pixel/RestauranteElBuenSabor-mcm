/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restauranteelbuensabor;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Producto> menu = MenuRestaurante.obtenerMenu();
        Pedido pedido = new Pedido();

        int numeroFactura = 1;
        boolean ejecutando = true;

        while (ejecutando) {

            System.out.println("========================================");
            System.out.println("    RESTAURANTE EL BUEN SABOR");
            System.out.println("========================================");
            System.out.println("1. Ver carta");
            System.out.println("2. Agregar producto");
            System.out.println("3. Ver pedido");
            System.out.println("4. Generar factura");
            System.out.println("5. Nueva mesa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    // mostrar carta
                    System.out.println("------ CARTA ------");
                    for (int i = 0; i < menu.size(); i++) {
                        Producto p = menu.get(i);
                        System.out.printf("%d. %-20s $%,.0f%n",
                                (i + 1),
                                p.getNombre(),
                                p.getPrecio());
                    }
                    break;

                case 2:
                    // agregar producto
                    System.out.print("Numero de producto: ");
                    int indice = sc.nextInt();

                    if (indice > 0 && indice <= menu.size()) {

                        System.out.print("Cantidad: ");
                        int cantidad = sc.nextInt();

                        if (cantidad > 0) {

                            Producto seleccionado = menu.get(indice - 1);
                            pedido.agregarItem(seleccionado, cantidad);

                            System.out.println("Producto agregado:");
                            System.out.println(" -> " + seleccionado.getNombre() + " x" + cantidad);

                        } else {
                            System.out.println("Cantidad invalida.");
                        }

                    } else {
                        System.out.println("Producto no existe.");
                    }
                    break;

                case 3:
                    // ver pedido
                    if (pedido.tieneProductos()) {

                        System.out.println("---- PEDIDO ----");

                        for (ItemPedido item : pedido.getItems()) {
                            System.out.printf("%-20s x%-5d $%,.0f%n",
                                    item.getProducto().getNombre(),
                                    item.getCantidad(),
                                    item.calcularSubtotal());
                        }

                        System.out.printf("Subtotal: $%,.0f%n", pedido.calcularSubtotal());

                    } else {
                        System.out.println("No hay productos en el pedido.");
                    }
                    break;

                case 4:
                    // generar factura
                    if (pedido.tieneProductos()) {

                        Factura factura = new Factura(pedido, numeroFactura);
                        Facturaimpresor.imprimir(factura);

                        numeroFactura++;

                    } else {
                        System.out.println("No hay productos para facturar.");
                    }
                    break;

                case 5:
                    // nueva mesa
                    pedido.limpiar();
                    System.out.println("Pedido reiniciado.");
                    break;

                case 0:
                    ejecutando = false;
                    System.out.println("Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

            System.out.println();
        }

        sc.close();
    }
}
