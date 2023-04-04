package ejemploHash;

import java.util.Objects;

public class Producto {
    private String nombre;
    private String descripcion;
    private String fechaAlta;
    private float pesoKg;
    private float precio;
    private int stock;

    public Producto(String nombre, String descripcion, String fechaAlta, float pesoKg, float precio, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaAlta = fechaAlta;
        this.pesoKg = pesoKg;
        this.precio = precio;
        this.stock = stock;
    }

    // Sobrescribimos el método hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, fechaAlta, pesoKg, precio, stock);
    }

    // Sobrescribimos el método equals()
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) obj;
        return this.nombre.equals(other.nombre) &&
                this.descripcion.equals(other.descripcion) &&
                this.fechaAlta.equals(other.fechaAlta) &&
                this.pesoKg == other.pesoKg &&
                this.precio == other.precio &&
                this.stock == other.stock;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public float getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(float pesoKg) {
        this.pesoKg = pesoKg;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
