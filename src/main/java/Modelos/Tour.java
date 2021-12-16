package Modelos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.Conexion;
import Modelos.Reserva;
import Modelos.Cliente;
import java.util.ArrayList;
import java.util.Date;



import java.util.Date;

/*@author aherrado*/
public class Tour {

    
    private int idtour;
    private String destino;
    private String nombre;
    private String descripcion;
    private String precio;
    private Date fecha;

    public Tour() {
    }

    public Tour(int idtour, String destino, String nombre, String descripcion, String precio, Date fecha) {
        this.idtour = idtour;
        this.destino = destino;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha = fecha;
    }

    public int getIdtour() {
        return idtour;
    }

    public void setIdtour(int idtour) {
        this.idtour = idtour;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
