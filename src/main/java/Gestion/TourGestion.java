package Gestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.Conexion;
import Modelos.Tour;
import java.util.ArrayList;
import java.util.Date;

/*@author aherrado*/
public class TourGestion {
    
////Tour: int idtour, String destino, String nombre, String descripcion, String precio, Date fecha)
     private static final String SQL_INSERT_TOUR = "INSERT INTO tourVALUES(?, ?, ?, ?, ?,?)";
    public static boolean insertar (Tour tour){
        
        try{
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_INSERT_TOUR);
            sentencia.setInt(1, tour.getIdtour());
            sentencia.setString(2, tour.getDestino());
            sentencia.setString(2, tour.getNombre());
            sentencia.setString(3, tour.getDescripcion());
            sentencia.setString(4, tour.getPrecio());
            sentencia.setObject(5, tour.getFecha());
            return sentencia.executeUpdate()>0;
            
        }catch (SQLException ex){
            Logger.getLogger(TourGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
        return false;
       
    }
    
    private static final String SQL_SELECT_TOURES= "Select * from tour";
    
    public static ArrayList<Tour> getToures(){
        
        ArrayList<Tour> lista= new ArrayList<>();
        try{
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_TOURES);
            ResultSet rs = consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Tour (//Tour: int idtour, String destino, String nombre, String descripcion, String precio, Date fecha)
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6)));
            }
            
        }catch (SQLException ex){
            Logger.getLogger(TourGestion.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return lista;
    }
    
    
    
    
}
