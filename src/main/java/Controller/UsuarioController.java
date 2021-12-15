
package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import Gestion.UsuarioGestion;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Modelos.Usuario;
import java.util.List;

@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    public UsuarioController() {
        super(java.sql.Types.NULL,"","","");
    }
    
    public String valida(){
        
        Usuario usuario= UsuarioGestion.Valida(this.getIdUsuario(), this.getPwUsuario());
        
        if (usuario!=null){
            this.setIdUsuario(usuario.getIdUsuario());
            this.setNombreUsuario(usuario.getNombreUsuario());
            this.setCorreoUsuario(usuario.getCorreoUsuario());
            this.setEdadUsuario(usuario.getEdadUsuario());
            
            return "Principal.xhtml";
        }else{
            
            FacesMessage msg = new FacesMessage (FacesMessage.SEVERITY_ERROR,"Error","Usuario o "
                    + "Contraseña inválidas");
            FacesContext.getCurrentInstance().addMessage("loginForm:Contraseña", msg);
            return "index.xhtml";
            
        }
}
    
    public String registra() {
        
            return "Registro.xhtml";
        
    }
    
    public String registrar() {
        if (UsuarioGestion.registrar(this)) {
            return "index.xhtml";
        }else{
            FacesMessage mensaje= new FacesMessage (FacesMessage.SEVERITY_ERROR,
            "Error","Intente nuevamente!");
            FacesContext.getCurrentInstance().addMessage("RegistroForm",mensaje);
            return "Registro.xhtml";
        }
    }
    
}
