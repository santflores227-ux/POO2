package Codigo;

public class Material {
    private String nombre;
    private double precio;

    public Material(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public void actualizarPrecio(double nuevoPrecio){
        this.precio = nuevoPrecio;
    }
    public pagoCosto crearCosto(){
        return new pagoCosto(this.precio);
    }
}