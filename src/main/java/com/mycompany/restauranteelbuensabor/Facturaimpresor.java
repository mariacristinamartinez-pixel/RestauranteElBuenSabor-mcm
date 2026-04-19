/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author Maria Cristina
 */
public class Facturaimpresor {
    public static void imprimir(Factura factura) {

        String sep = "========================================";

        System.out.println(sep);
        System.out.println("    El Buen Sabor");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(sep);

        System.out.printf("FACTURA No. %03d%n", factura.getNumero());
        System.out.println("----------------------------------------");

        for (ItemPedido item : factura.getPedido().getItems()) {
            System.out.printf("%-20s x%-6d $%,.0f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.calcularSubtotal());
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", factura.calcularSubtotal());
        System.out.printf("%-27s $%,.0f%n", "Descuento:", factura.calcularDescuento());
        System.out.printf("%-27s $%,.0f%n", "IVA:", factura.calcularIVA());

        if (factura.calcularPropina() > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina:", factura.calcularPropina());
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", factura.calcularTotal());
        System.out.println(sep);
    }
    
}
