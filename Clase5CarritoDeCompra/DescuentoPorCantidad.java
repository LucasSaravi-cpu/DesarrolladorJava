package Clase5CarritoDeCompra;

public class DescuentoPorCantidad extends Descuento {
    private int cantidadMinima;

    public DescuentoPorCantidad(String nombre, double porcentajeDescuento, int cantidadMinima) {
        super(nombre, porcentajeDescuento);
        this.cantidadMinima = cantidadMinima;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public boolean aplicaDescuento(int cantidad) {
        return cantidad >= cantidadMinima;
    }
}
