package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "reservaController")
@SessionScoped
public class ReservaController implements Serializable {

    /**
     * Creates a new instance of ReservaController
     */
    public ReservaController() {
        
    }
    
}
