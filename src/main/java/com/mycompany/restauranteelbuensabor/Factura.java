/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author Maria Cristina
 */
public class Factura {
    private final Pedido pedido;
    private final int numero;

    private static final double IVA = 0.19;
    private static final double PROPINA = 0.10;
    private static final double DESCUENTO = 0.05;
    private static final double UMBRAL_PROPINA = 50000;
    private static final int MIN_ITEMS_DESCUENTO = 3;

    public Factura(Pedido pedido, int numero) {
        this.pedido = pedido;
        this.numero = numero;
    }

    public double calcularSubtotal() {
        return pedido.calcularSubtotal();
    }

    public double calcularDescuento() {
        if (pedido.contarItemsDiferentes() > MIN_ITEMS_DESCUENTO) {
            return calcularSubtotal() * DESCUENTO;
        }
        return 0;
    }

    public double calcularBase() {
        return calcularSubtotal() - calcularDescuento();
    }

    public double calcularIVA() {
        return calcularBase() * IVA;
    }

    public double calcularPropina() {
        if (calcularBase() > UMBRAL_PROPINA) {
            return (calcularBase() + calcularIVA()) * PROPINA;
        }
        return 0;
    }

    public double calcularTotal() {
        return calcularBase() + calcularIVA() + calcularPropina();
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedido() {
        return pedido;
    }
    
}
