public class App {
    private boolean enEjecucion;
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        InterfazGrafica interfaz = new InterfazGrafica();
        App app = new App();
        app.iniciarSistema(sistema,interfaz);
    }
    public void iniciarSistema(Sistema sistema, InterfazGrafica interfaz){
        enEjecucion = true;
        while (enEjecucion == true){
            int opcion = interfaz.mostrarMenu();
            switch(opcion){
                case 1:
                    iniciarMenuMateriales(sistema, interfaz);
                    break;
                case 2:
                    iniciarMenuFacturas(sistema,interfaz);
                    break;
                case 3:
                    enEjecucion = false;
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }
    public void iniciarMenuMateriales(Sistema sistema,InterfazGrafica interfaz){
        boolean volver = false;
        while(volver == false){
            int opcionMateriales = interfaz.mostrarMenuMateriales(sistema.getMateriales());
            switch(opcionMateriales){
                case 1:
                    String nombre;
                    nombre = interfaz.pedirNombre();
                    double precio;
                    precio = interfaz.pedirPrecio();
                    sistema.crearMaterial(nombre, precio);
                    break;
                case 2:
                    System.out.println("Regresando al menu principal...");
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.Regresando al menu principal...");
                    volver = true;
                    break;
                        }
        }
    }
    public void iniciarMenuFacturas(Sistema sistema,InterfazGrafica interfaz){
        boolean volver = false;
        while(volver == false){
            int opcionFacturas = interfaz.mostrarMenuFacturas(sistema.getFacturas());
            switch(opcionFacturas){
                case 1:
                    String nombre;
                    nombre = interfaz.pedirNombre();
                    String descripcion;
                    descripcion = interfaz.pedirDescripcion();
                    double precio;
                    precio = interfaz.pedirPrecio();
                    sistema.crearPagoCosto(nombre, precio, descripcion);
                    break;
                case 2:
                    System.out.println("Regresando al menu principal...");
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.Regresando al menu principal");
                    volver = true;
                    break;
                        }
        }
    }
}
