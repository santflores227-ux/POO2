
public class pagoCosto{
    private String descripcion;
    private double costo;
    private int dia;
    private boolean remarcado;
    private int id;
    public pagoCosto(double costo,String descripcion,int dia){
        this.descripcion = descripcion;
        this.costo = costo;
        this.dia = dia;
    }
    public void setRemarcado(boolean remarcado){
        this.remarcado = remarcado;
    }
    public boolean getRemarcado(){
        return remarcado;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDia(int dia){
        this.dia = dia;
    }
    public int getDia(){
        return dia;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setCosto(double costo){
        this.costo = costo;
    }
    public double getCosto(){
        return costo;
    }

}