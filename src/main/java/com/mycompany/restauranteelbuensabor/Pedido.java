/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maria Cristina
 */
public class Pedido {
    private final List<ItemPedido> items = new ArrayList<>();

    public void agregarItem(Producto producto, int cantidad) {
    for (ItemPedido item : items) {
        if (item.getProducto().getNombre().equals(producto.getNombre())) {
            item.setCantidad(item.getCantidad() + cantidad);
            return;
        }
    }
    items.add(new ItemPedido(producto, cantidad));
}

    public double calcularSubtotal() {
        double subtotal = 0;

        for (ItemPedido item : items) {
            subtotal += item.calcularSubtotal();
        }

        return subtotal;
    }

    public int contarItemsDiferentes() {
    int contador = 0;

    for (ItemPedido item : items) {
        if (item.getCantidad() > 0) {
            contador++;
        }
    }

    return contador;
}

    public boolean tieneProductos() {
        return !items.isEmpty();
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public void limpiar() {
        items.clear();
    }
    
}
