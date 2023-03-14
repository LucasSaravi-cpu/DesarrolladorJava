package Clase5CarritoDeCompra;

public class DescuentoPorMonto extends Descuento {
    private double montoMinimo;

    public DescuentoPorMonto(String nombre, double porcentajeDescuento, double montoMinimo) {
        super(nombre, porcentajeDescuento);
        this.montoMinimo = montoMinimo;
    }

    public double getMontoMinimo() {
        return montoMinimo;
    }

    public boolean aplicaDescuento(double precioTotal) {
        return precioTotal >= montoMinimo;
    }
}