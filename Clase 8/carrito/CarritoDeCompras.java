package carrito;
import java.util.ArrayList;
import java.util.List;
public class CarritoDeCompras {
    private List<ItemCarrito> items = new ArrayList<>();

    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemCarrito(producto, cantidad));
    }

    public void eliminarItem(int index) {
        items.remove(index);
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public float getPrecioTotal() throws NoHayStockException {
        float precioTotal = 0;
        for (ItemCarrito item : items) {
            precioTotal += item.getPrecio();
        }
        return precioTotal;
    }
}

//el método getPrecioTotal arroja la excepción NoHayStockException si alguno de los productos
// no tiene stock disponible. El método agregarItem permite agregar un nuevo elemento al carrito,
// mientras que el método este funcionando
