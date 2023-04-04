package carrito;

public class EjemploExcepcion {
    public static void main(String[] args) {
        //Instancio objetos Producto que seria lo que está en mi tienda
        Producto productoConStock = new Producto("Zapatillas", 50.0f, 10);
        Producto productoSinStock = new Producto("Camisa", 20.0f, 0);

        //Acá alguien me está queriendo comprar 2 zapas y 1 camisa but no hay camisas
        ItemCarrito itemConStock = new ItemCarrito(productoConStock, 2);
        ItemCarrito itemSinStock = new ItemCarrito(productoSinStock, 1);

        //Genero un carrito de compras (canasto) donde guardar su items (productos)
        CarritoDeCompras carrito = new CarritoDeCompras();
        carrito.agregarItem(itemConStock.getProducto(), itemConStock.getCantidad());
        carrito.agregarItem(itemSinStock.getProducto(), itemSinStock.getCantidad());

        try {
            float precioTotal = carrito.getPrecioTotal();
            System.out.println("El precio total del carrito es: " + precioTotal);
        } catch (NoHayStockException e) {
            System.out.println("No hay stock del producto: " + e.getProducto().getNombre());
        }
    }
}
