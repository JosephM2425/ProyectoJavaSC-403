package Gestion;

import Modelos.Cliente;
import Modelos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteGestion {
    
    private static final String SQL_INSERT_CLIENTE = "INSERT INTO cliente(nombre, apellido, email, telefono, cedula) VALUES(?, ?, ?, ?, ?)";
    
    public static boolean insertar (Cliente cliente){
        
        try{
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_INSERT_CLIENTE);
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getApellido());
            sentencia.setString(3, cliente.getEmail());
            sentencia.setString(4, cliente.getTelefono());
            sentencia.setString(5, cliente.getCedula());
            
            
            return sentencia.executeUpdate()>0;
            
        }catch (SQLException ex){
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
       
    }
    
    private static final String SQL_UPDATE_CLIENTE = "UPDATE cliente set nombre=?, apellido=?, email=?, telefono=? where cedula=?";
    
    public static boolean actualizar (Cliente cliente){
        
        try{
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_UPDATE_CLIENTE);
            sentencia.setString(5, cliente.getCedula());
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getApellido());
            sentencia.setString(3, cliente.getEmail());
            sentencia.setString(4, cliente.getTelefono());
            
            
            return sentencia.executeUpdate()>0;
            
        }catch (SQLException ex){
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
       
    }
    
    private static final String SQL_DELETE_CLIENTE= "delete from cliente where cedula=?";
    
    public static boolean eliminar (Cliente cliente){
        
        try{
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_DELETE_CLIENTE);
            consulta.setString(1, cliente.getCedula());
            
            return consulta.executeUpdate()>0; 
            
        }catch (SQLException ex){
            Logger.getLogger(ReservaGestion.class.getName()).log(Level.SEVERE,null, ex);
            
        }
        return false;
    }
    
    private static final String SQL_SELECT_CLIENTES= "Select * from cliente";
    
    public static ArrayList<Cliente> getClientes(){
        
        ArrayList<Cliente> lista= new ArrayList<>();
        
        try{
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_CLIENTES);
            ResultSet rs = consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Cliente (rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
            
        }catch (SQLException ex){
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return lista;
    }
    
    private static final String SQL_SELECT_CLIENTE_RESERVA = "select * from cliente where email=email";
    
    public static Cliente getCliente(String email){
        
        Cliente cliente = null;
        
        try{
            
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_CLIENTE_RESERVA);
            consulta.setString(1, email);
            ResultSet datos = consulta.executeQuery();
            if (datos.next()){
                cliente= new Cliente(
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getString(6)
                );
            }
            
        }catch (SQLException ex){
            Logger.getLogger(ClienteGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return cliente;
        
    }
    
}
