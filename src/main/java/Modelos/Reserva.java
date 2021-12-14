package Modelos;

public class Reserva {
    
    private int idCliente;
    private String nombre;
    private String descripcion;
    private double precio;
    
    public Reserva(){
        
    }

    public Reserva(int idCliente, String nombre, String descripcion, double precio) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
