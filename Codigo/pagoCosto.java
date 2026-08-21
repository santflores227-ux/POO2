package Codigo;

public class pagoCosto{
    String descripcion;
    int costo;
    int dia;
    boolean remarcado;
    public pagoCosto(int costo,String descripcion){
        if (descripcion == null){
            this.descripcion = "Sin descripcion";
        } else {
            this.descripcion = descripcion;
        }
        this.costo = costo;
    }
    public void setRemarcado(boolean remarcado){
        this.remarcado = remarcado;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDia(int dia){
        this.dia = dia;
    }
}