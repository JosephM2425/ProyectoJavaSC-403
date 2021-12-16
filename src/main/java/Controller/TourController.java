package Controller;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Gestion.TourGestion;
import Modelos.Tour;
import java.util.Date;
import java.util.List;

/*@author aherrado*/
@Named(value = "tourController")
@SessionScoped

public class TourController extends Tour implements Serializable{

    //Tour: int idtour, String destino, String nombre, String descripcion, String precio, Date fecha
    public TourController() {
    }

    
    
    public String insertar(){
        
        if (TourGestion.insertar(this)){
            return "list_tour.xhtml";
            
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible Tour duplicado");
            FacesContext.getCurrentInstance().addMessage("insertReservaForm:id",mensaje);
            return "crear_tour.xhtml";
        } 
    }
    
       
    public List<Tour> getToures(){
        
        return TourGestion.getToures();
        
    }
     
    
    
}
