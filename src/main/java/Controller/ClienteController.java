package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Gestion.ClienteGestion;
import Modelos.Cliente;

@Named(value = "clienteController")
@SessionScoped
public class ClienteController extends Cliente implements Serializable {

    
    public ClienteController() {
        super("", "", "", "", "");
    }
    
    
    public String inserta (){
        
        if (ClienteGestion.insertar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("editaClienteForm:nombre",mensaje);
            return "edita.xhtml";
        } 
    }
    
    public String modifica (){
        
        if (ClienteGestion.actualizar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible identificación duplicada");
            FacesContext.getCurrentInstance().addMessage("editaClienteForm:nombre",mensaje);
            return "edita.xhtml";
        }
    }
    
    public String elimina (){
        
        if (ClienteGestion.eliminar(this)){
            return "list.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("editaClienteForm:nombre",mensaje);
            return "edita.xhtml";
        }
    }
       
    public List<Cliente> getClientes(){
        
        return ClienteGestion.getClientes();
        
    }
    
}
