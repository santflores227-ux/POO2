package Codigo;

public class Material {
    private String nombre;
    private double precio;
    private Sistema sistema;

    public Material(Sistema sistema,String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public void actualizarPrecio(double nuevoPrecio){
        this.precio = nuevoPrecio;
    }
}