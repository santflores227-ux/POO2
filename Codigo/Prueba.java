package Codigo;

public class Prueba {
    public class main {
        public static void main(String[] args) {
            Material material = new Material("Madera", 10.0);
            System.out.println("Nombre del material: " + material.getNombre());
            System.out.println("Precio del material: " + material.getPrecio());

            // Actualizar el precio
            material.actualizarPrecio(12.5);
            System.out.println("Nuevo precio del material: " + material.getPrecio());

            // Crear un objeto pagoCosto
            pagoCosto costo = material.crearCosto();
            System.out.println("Costo creado con precio: " + costo.getPrecio());
        }
    }
}
