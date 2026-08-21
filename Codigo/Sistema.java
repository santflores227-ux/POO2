package Codigo
public class Sistema{
    PagoCosto[] pagoCosto;
    Material[] materiales;
    public Sistema(){
        materiales = new Material[100];
        pagoCosto = new PagoCosto[1000];
    }
    public void crearPagoCosto(double costo,String descripcion,int dia){
        PagoCosto pago = new PagoCosto(this,costo,descripcion,dia);
        agregarPagoCosto(pago);
    }
    public void agregarPagoCosto(PagoCosto pago){
        for(int i=0;i<pagoCosto.length;i++){
            if(pagoCosto[i]==null){
                pagoCosto[i] = pago;
                break;
            }
        }
        System.out.println("No hay mas espación para agregar pagos");
    }
    public void crearMaterial(String nombre, double precio){
        Material material = new Material(this,nombre,precio);
        agregarMaterial(material);
    }
    public void agregarMaterial(Material material){
        for(int i=0;i<materiales.length;i++){
            if(materiales[i]==null){
                materiales[i] = material;
                break;
            }
        }
        System.out.println("No hay mas espación para agregar materiales");
    }
}
