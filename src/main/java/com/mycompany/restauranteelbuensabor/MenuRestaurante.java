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
public class MenuRestaurante {
    
    // Menú estático de ejemplo (simula datos persistidos en base de datos)
    public static List<Producto> obtenerMenu() {

        List<Producto> menu = new ArrayList<>();

        menu.add(new Producto("Bandeja Paisa", 32000));
        menu.add(new Producto("Sancocho de Gallina", 28000));
        menu.add(new Producto("Arepa con Huevo", 8000));
        menu.add(new Producto("Jugo Natural", 7000));
        menu.add(new Producto("Gaseosa", 4500));
        menu.add(new Producto("Cerveza Poker", 6000));
        menu.add(new Producto("Agua Panela", 3500));
        menu.add(new Producto("Arroz con Pollo", 25000));

        return menu;
    }
    
}
