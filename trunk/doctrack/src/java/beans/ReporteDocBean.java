/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import entities.reporte.ReporteDocumento;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Ivan
 */

@ManagedBean
@ViewScoped
public class ReporteDocBean {
    
    private String sup;
    private String fecha;
    
   
    public String getSup() {
        return sup;
    }

    public void setSup(String sup) {
        this.sup = sup;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
     public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
              
        ReporteDocumento repdocsup = new ReporteDocumento();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("../ReportesJasper/Documentos_Supervicion.jasper");
       
        repdocsup.getReporteSup(ruta,this.fecha);        
        FacesContext.getCurrentInstance().responseComplete();               
    }        
     
     public void verReporteF() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
               
        ReporteDocumento repdocsup = new ReporteDocumento();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("../ReportesJasper/Documentos_fecha.jasper");
       
        repdocsup.getReporteSup(ruta,this.fecha);        
        FacesContext.getCurrentInstance().responseComplete();               
    }   
}
