package Clase5CarritoDeCompra;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;

    public Carrito() {
        this.items = new ArrayList<ItemCarrito>();
    }

    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemCarrito(producto, cantidad));
    }

    public void eliminarItem(int indice) {
        items.remove(indice);
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public double getPrecioTotal() {
        double precioTotal = 0;
        for (ItemCarrito item : items) {
            precioTotal += item.getPrecioTotal();
        }
        return precioTotal;
    }
}