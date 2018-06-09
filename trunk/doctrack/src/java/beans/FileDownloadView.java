/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author user
 */
@ManagedBean
public class FileDownloadView {
    private StreamedContent file;
     
    public FileDownloadView() {        
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/manual/manualUsuario.pdf");
        file = new DefaultStreamedContent(stream, "file/pdf", "manualDeUsuario.pdf");
    }
 
    public StreamedContent getFile() {
        return file;
    }
    
}
