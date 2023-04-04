package ejemploHash;
import java.util.HashSet;

public class EjemploHashSet {
    public static void main(String[] args) {
        // Creamos algunos productos
        Producto producto1 = new Producto("Zapatillas", "Deportivas", "2022-03-19", 0.5f, 50.0f, 10);
        Producto producto2 = new Producto("Camisa", "Formal", "2022-03-18", 0.3f, 20.0f, 5);
        Producto producto3 = new Producto("Zapatillas", "Deportivas", "2022-03-19", 0.5f, 50.0f, 10);

        // Creamos un HashSet de productos
        HashSet<Producto> productos = new HashSet<>();

        // Agregamos los productos al HashSet
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        //Preguntamos si el producto 3 ya está en el Set
        if (productos.contains(producto3)) {
            System.out.println("El producto " + producto3.getNombre() + " ya está en el HashSet");
        } else {
            System.out.println("El producto " + producto3.getNombre() + " no está en el HashSet");
        }

        // Imprimimos los productos del HashSet
        System.out.println("Productos en el HashSet:");
        for (Producto p : productos) {
            System.out.println(p.getNombre());
        }
    }
}
