package Gestion;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.Conexion;
import Modelos.Reserva;
import Modelos.Cliente;
import java.util.ArrayList;


public class ReservaGestion {
    
    private static final String SQL_INSERT_RESERVA = "INSERT INTO reserva(idcliente, nombre, descripcion, precio) VALUES(?, ?, ?, ?)";
    
    public static boolean insertar (Reserva reserva){
        
        try{
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_INSERT_RESERVA);
            sentencia.setString(1, reserva.getIdCliente());
            sentencia.setString(2, reserva.getNombre());
            sentencia.setString(3, reserva.getDescripcion());
            sentencia.setDouble(4, reserva.getPrecio());
            
            
            return sentencia.executeUpdate()>0;
            
        }catch (SQLException ex){
            Logger.getLogger(ReservaGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
       
    }
    
    private static final String SQL_UPDATE_RESERVA = "UPDATE reserva set idcliente=?, nombre=?, descripcion=?, precio=?";
    
    public static boolean actualizar (Reserva reserva){
        
        try{
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_UPDATE_RESERVA);
            sentencia.setString(1, reserva.getIdCliente());
            sentencia.setString(2, reserva.getNombre());
            sentencia.setString(3, reserva.getDescripcion());
            sentencia.setDouble(4, reserva.getPrecio());
            
            
            return sentencia.executeUpdate()>0;
            
        }catch (SQLException ex){
            Logger.getLogger(ReservaGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
       
    }
    
    private static final String SQL_DELETE_RESERVA= "delete from reserva where idreserva=?";
    
    public static boolean eliminar (Reserva reserva){
        
        try{
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_DELETE_RESERVA);
            consulta.setInt(1, reserva.getIdReserva());
            
            return consulta.executeUpdate()>0; 
            
        }catch (SQLException ex){
            Logger.getLogger(ReservaGestion.class.getName()).log(Level.SEVERE,null, ex);
            
        }
        return false;
    }
    
    private static final String SQL_SELECT_RESERVAS= "Select * from reserva";
    
    public static ArrayList<Reserva> getReservas(){
        
        ArrayList<Reserva> lista= new ArrayList<>();
        
        try{
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_RESERVAS);
            ResultSet rs = consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Reserva (rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5)));
            }
            
        }catch (SQLException ex){
            Logger.getLogger(ReservaGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return lista;
    }
    
    private static final String SQL_SELECT_CLIENTE_RESERVA = "select * from cliente where id=?";
    
    public static Cliente getCliente(String id){
        
        Cliente cliente = null;
        
        try{
            
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_CLIENTE_RESERVA);
            consulta.setString(1, id);
            ResultSet datos = consulta.executeQuery();
            if (datos.next()){
                cliente= new Cliente(
                        datos.getString(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5)
                );
            }
            
        }catch (SQLException ex){
            Logger.getLogger(ReservaGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return cliente;
        
    }
    
}
