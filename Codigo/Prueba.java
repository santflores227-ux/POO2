package Codigo;

public class Prueba {
    public static void main(String[] args) {
        Material madera = new Material("Madera de abeto",11.6);
        pagoCosto costoMadera = madera.crearCosto();
        System.out.println("Costo de la madera: " + costoMadera.costo);
}
}