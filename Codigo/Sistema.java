
import java.util.ArrayList;
import java.util.List;
public class Sistema{
    List<Material> materiales;
    List<pagoCosto> pagos;
    InterfazGrafica interfaz;

    //---------------------Constructor-------------------------------
    public Sistema(){
        materiales = new ArrayList<>();
        pagos = new ArrayList<>();
        interfaz = new InterfazGrafica();
    }
   
    //---------------------Zona de pruebas----------------------

    
    //---------------------Zona de pagos------------------------

    public void crearPagoCosto(double costo,String descripcion,int dia){
        pagoCosto pago = new pagoCosto(costo,descripcion,dia);
        agregarPagoCosto(pago);
    }
    public void agregarPagoCosto(pagoCosto pago){
        pagos.add(pago);
        pago.setId(pagos.size()-1);
    }

     //---------------------Zona de materiales------------------------

    public void crearMaterial(String nombre, double precio){
        Material material = new Material(nombre,precio);
        agregarMaterial(material);
    }
    public void agregarMaterial(Material material){
        materiales.add(material);
        material.setId(materiales.size()-1);
    }
    public void actualizarCostoMaterial(Material material,double nuevoPrecio){
        materiales.get(material.getId()).actualizarPrecio(nuevoPrecio);
    }

}
