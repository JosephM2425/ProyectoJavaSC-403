package Modelos;

import java.util.Date;

public class Reserva {
    
    private String idCliente;
    private String nombre;
    private String descripcion;
    private double precio;
    private Date fecha;

    public Reserva(){
        
    }

    public Reserva(String idCliente, String nombre, String descripcion, double precio, Date fecha) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha = fecha;
    }
   
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
     
}
