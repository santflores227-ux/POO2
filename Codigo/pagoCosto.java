package Codigo;

public class pagoCosto{
    String descripcion;
    double costo;
    int dia;
    boolean remarcado;
    public pagoCosto(double costo,String descripcion,int dia){
        this.descripcion = descripcion;
        this.costo = costo;
        this.dia = dia;
    }
    public pagoCosto(double costo){
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