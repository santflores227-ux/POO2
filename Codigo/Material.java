package Codigo;

public class Material {
    private String nombre;
    private double precio;
    private int id;

    public Material(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public void actualizarPrecio(double nuevoPrecio){
        this.precio = nuevoPrecio;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public double getPrecio(){
        return precio;
    }




}