package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Modelos.Reserva;
import Gestion.ReservaGestion;
import java.util.Date;
import java.util.List;

@Named(value = "reservaController")
@SessionScoped
public class ReservaController extends Reserva implements Serializable {

    public ReservaController() {
    }
        
    public List<String> get_client_email(){
        return ReservaGestion.getClientes();
    }
    
    public String insertar(){
        
        if (ReservaGestion.insertar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible reserva duplicada duplicada");
            FacesContext.getCurrentInstance().addMessage("insertReservaForm:id",mensaje);
            return "crear.xhtml";
        } 
    }
    
       
    public List<Reserva> getReservas(){
        
        return ReservaGestion.getReservas();
        
    }
     
}
