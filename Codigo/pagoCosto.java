public class pagoCosto{
    String descripcion;
    int costo;
    int dia;
    boolean remarcado;
    public pagoCosto(String descripcion, int costo, int dia){
        if (descripcion == null){
            this.descripcion = "Sin descripcion";
        } else {
            this.descripcion = descripcion;
        }
        this.costo = costo;
        if(dia == null){
            this.dia = 0;
        } else {
            this.dia = dia;
        }
    }
    public void setRemarcado(boolean remarcado){
        this.remarcado = remarcado;
    }
    public String getDescripcion(){
        return descripcion;
    }
}