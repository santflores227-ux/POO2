import java.util.Scanner;
import java.util.List;
public class InterfazGrafica {
    private Scanner teclado;
    private int opcion;
    private double opcionDouble;
    private String opcionString; 
    public InterfazGrafica() {
        this.teclado = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("Bienvenido al sistema de gestión de materiales y pagos.");
        System.out.println("1: Menu materiales");
        System.out.println("2: Menu pagos");
        System.out.println("3: Salir");
        opcion = teclado.nextInt();
        teclado.nextLine(); 
        return opcion;
    }
    public int mostrarMenuMateriales(List<Material> materiales) {
        System.out.println("Menu de materiales:");
        for(int i = 0; i <materiales.size(); i++){
            System.out.println(i + ": " + materiales.get(i).getNombre() + " - Precio: " + materiales.get(i).getPrecio());
        }
        System.out.println("\nOpciones:");
        System.out.println("1: Agregar material");
        System.out.println("2: Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        opcion = teclado.nextInt();
        teclado.nextLine(); 
        return opcion;
    }
    public int mostrarMenuFacturas(List<PagoCosto> facturas){
        System.out.println("Menu de facturas");
        for(int i=0; i< facturas.size(); i++){
            System.out.println(i+":"+facturas.get(i).getNombre());
            System.out.println(facturas.get(i).getDescripcion());
            System.out.println(facturas.get(i).getCosto());
            System.out.println("---------------------------------");
        }
        System.out.println("\nOpciones:");
        System.out.println("1: Agregar factura");
        System.out.println("2: Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        opcion = teclado.nextInt();
        teclado.nextLine(); 
        return opcion;
    }
    public String pedirNombre(){
        System.out.println("Ingrese el nombre ");
        opcionString = teclado.nextLine();
        return opcionString;
    }
    public double pedirPrecio(){
        System.out.println("Ingrese el precio ");
        opcionDouble = teclado.nextDouble();
        teclado.nextLine();
        return opcionDouble;
    }
    public String pedirDescripcion(){
        System.out.println("Ingrese una descripción:");
        String descripcion = teclado.nextLine();
        return descripcion;
    }
}
