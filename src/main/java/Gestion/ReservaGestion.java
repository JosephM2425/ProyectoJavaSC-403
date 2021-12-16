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
import java.util.Date;


public class ReservaGestion {
    
    private static final String SQL_INSERT_RESERVA = "INSERT INTO reserva(idcliente, nombre, descripcion, precio, fecha) VALUES(?, ?, ?, ?, ?)";
    
    public static boolean insertar (Reserva reserva){
        
        try{
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_INSERT_RESERVA);
            sentencia.setString(1, reserva.getIdCliente());
            sentencia.setString(2, reserva.getNombre());
            sentencia.setString(3, reserva.getDescripcion());
            sentencia.setDouble(4, reserva.getPrecio());
            sentencia.setObject(5, reserva.getFecha());
            
            
            return sentencia.executeUpdate()>0;
            
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
                lista.add(new Reserva (rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDate(6)));
            }
            
        }catch (SQLException ex){
            Logger.getLogger(ReservaGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return lista;
    }
       
    public static final String SQL_SELECT_CLIENTS = "SELECT * from cliente";
    
    public static ArrayList<String> getClientes(){
        
        ArrayList<String> lista= new ArrayList<>();
        
        try{
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_CLIENTS);
            ResultSet rs = consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(rs.getString("email"));
            }
            
        }catch (SQLException ex){
            Logger.getLogger(ReservaGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return lista;
    }
    
}
