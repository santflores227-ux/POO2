public class PagoCosto{
    private String nombre;
    private String descripcion;
    private double costo;
    private int dia;
    private boolean remarcado;
    private int id;
    public PagoCosto(String nombre, double costo, String descripcion){
        this.descripcion = descripcion;
        this.costo = costo;
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombreNuevo){
        this.nombre = nombreNuevo;
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