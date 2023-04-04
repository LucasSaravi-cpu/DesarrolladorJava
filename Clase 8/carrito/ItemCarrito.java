package carrito;

public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() throws NoHayStockException {
        if (!producto.hayStock()) {
            throw new NoHayStockException(producto);
        }
        return this.cantidad * this.producto.getPrecio();
    }
}

        //La excepción NoHayStockException se arroja si el producto no tiene stock disponible.
        //En caso contrario, se calcula el precio del item multiplicando la cantidad por el
        //precio del producto.