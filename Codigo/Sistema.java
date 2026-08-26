
import java.util.ArrayList;
import java.util.List;
public class Sistema{
    List<Material> materiales;
    List<PagoCosto> pagos;

    //---------------------Constructor-------------------------------
    public Sistema(){
        materiales = new ArrayList<>();
        pagos = new ArrayList<>();
    }
   
    //---------------------Zona de pruebas----------------------

    
    //---------------------Zona de pagos------------------------

    public void crearPagoCosto(String nombre, double costo,String descripcion){
        PagoCosto pago = new PagoCosto(nombre,costo,descripcion);
        agregarPagoCosto(pago);
    }
    public void agregarPagoCosto(PagoCosto pago){
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
    public List<Material> getMateriales(){
        return materiales;
    }
    public List<PagoCosto> getFacturas(){
        return pagos;
    }

}
