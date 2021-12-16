package Controller;

import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import Modelos.Conexion;
import Modelos.Reserva;



@Named(value = "reporteClienteController")
@SessionScoped
public class ReporteClienteController implements Serializable {

    public ReporteClienteController() {
    }
    
   public void verPdf(){
        
        try{           
            File jasper = new File (FacesContext.getCurrentInstance()
            .getExternalContext().getRealPath("/cliente/Cliente.jasper"));
            
            JasperPrint reporteJasper= JasperFillManager.fillReport(jasper.getPath(),null, Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse)
                    FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            respuesta.setContentType("application/pdf");
            respuesta.addHeader("Content-Type", "application/pdf");
            ServletOutputStream flujo= respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper,flujo);
            FacesContext.getCurrentInstance().responseComplete();
            
        }catch (JRException ex){
            Logger.getLogger(ReporteClienteController.class.getName()).log(Level.SEVERE,null,ex);
        }catch (IOException ex){
            Logger.getLogger(ReporteClienteController.class.getName()).log(Level.SEVERE,null,ex);
        }

    }
   
   public void descargarPdf(){
        
        try{           
            File jasper = new File (FacesContext.getCurrentInstance()
            .getExternalContext().getRealPath("/cliente/Cliente.jasper"));
            
            JasperPrint reporteJasper= JasperFillManager.fillReport(jasper.getPath(),null, Conexion.getConexion());
            HttpServletResponse respuesta = (HttpServletResponse)
                    FacesContext.getCurrentInstance().getExternalContext().getResponse();
            
            respuesta.addHeader("Content-disposition", "attachement; filename=reporte.pdf");
            ServletOutputStream flujo= respuesta.getOutputStream();
            JasperExportManager.exportReportToPdfStream(reporteJasper,flujo);
            FacesContext.getCurrentInstance().responseComplete();
            
        }catch (JRException ex){
            Logger.getLogger(ReporteClienteController.class.getName()).log(Level.SEVERE,null,ex);
        }catch (IOException ex){
            Logger.getLogger(ReporteClienteController.class.getName()).log(Level.SEVERE,null,ex);
        }

    }
   
 
    
}
