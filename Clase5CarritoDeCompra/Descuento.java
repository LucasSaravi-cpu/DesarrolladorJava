package Clase5CarritoDeCompra;

public class Descuento {
    private String nombre;
    private double porcentajeDescuento;

    public Descuento(String nombre, double porcentajeDescuento) {
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public double aplicarDescuento(double precio) {
        return precio - (precio * porcentajeDescuento / 100);
    }
}

