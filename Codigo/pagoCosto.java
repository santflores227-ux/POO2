package Codigo;

public class pagoCosto{
    String descripcion;
    double costo;
    int dia;
    boolean remarcado;
    Sistema sistema;
    public pagoCosto(Sistema sistema,double costo,String descripcion,int dia){
        this.descripcion = descripcion;
        this.costo = costo;
        this.dia = dia;
        this.sistema = sistema;
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
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}