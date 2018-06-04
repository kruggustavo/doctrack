/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import util.Authorization;
import util.HibernateUtil;

/**
 *
 * @author Ivan
 */

@ManagedBean
@SessionScoped
public class ReportesBean {
    private String supervision = "";
    private Date fechaInicio = new Date();
    private Date fechaFin = new Date();
    
    private HashMap parameters = new HashMap();
    
    public void documentoPorFecha() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, JRException {
        parameters.clear();
        parameters.put("usuario", Authorization.currentUser.getAlias());
        parameters.put("fechaInicio", fechaInicio);
        parameters.put("fechaFin", fechaFin);
        parameters.put("distrito", "%"); 
        if (supervision != null){
            parameters.put("distrito", (supervision.length() > 0? supervision : "%"));
        }
        
        buildReportAsResponse("/reports/Documentos_fecha.jasper", parameters);
    }        
    
    //Construye el reporte rellenando con datos y devuelve un response
    private void buildReportAsResponse(String reportPath, HashMap param) throws IOException, SQLException, JRException{        
        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        
        InputStream reportStream = facesContext.getExternalContext().getResourceAsStream(reportPath);
        ServletOutputStream servletOutputStream = response.getOutputStream();
        
        JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, param, getSqlConnection());
        
        response.setContentType("application/pdf");
        servletOutputStream.flush();
        servletOutputStream.close();
    }

    private Connection getSqlConnection() throws SQLException{
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();        
        s.getTransaction().begin();

        SessionImplementor sessionImplementor = (SessionImplementor) s.getSessionFactory().getCurrentSession();
        Connection connection = sessionImplementor.getJdbcConnectionAccess().obtainConnection();        

        s.getTransaction().commit();
        return connection;
    }
    
    public String getSupervision() {
        return supervision;
    }

    public void setSupervision(String supervision) {
        this.supervision = supervision;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
  
}