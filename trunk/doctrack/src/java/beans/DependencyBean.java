package beans;

import controllers.DependencyController;
import entities.institucion.Dependencias;
import java.io.Serializable;
import java.util.List;import javax.faces.application.FacesMessage;
;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class DependencyBean implements Serializable{

    private static final long serialVersionUID = 2143118587002340795L;
   
    private String nombre;
    private String email;
    private String interno;
    //list de dependencia para la tabla
    private List districtList;
    //objeto dependencia
    private Dependencias selectedDependency;
    //instancia del controlador
    private DependencyController controller = new DependencyController();

    //Métodos usados como actionListeners del CRUD de Dependencias & Roles
    public void nuevoDependencia(){
        selectedDependency = new Dependencias();
    }
    
    public void guardarDependencia(){                  
        int resultadoEnc = controller.getDependenciaNombreList(selectedDependency.getNombre()).size();
        System.out.println("tamaño lista "+resultadoEnc);
        if(resultadoEnc <= 0)
        { 
            controller.saveDependency(selectedDependency);
            selectedDependency = null; 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Dependencia Creada con éxito!"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "Ya existe la Dependencia especificada"));
        }
    }
    
    public void actualizarDependencia(){                  
        int resultadoEnc = controller.getDependenciaActList(selectedDependency.getNombre(), selectedDependency.getId()).size();
        System.out.println("tamaño lista "+resultadoEnc);
        if(resultadoEnc <= 0)
        { 
            controller.saveDependency(selectedDependency);
            selectedDependency = null; 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Dependencia Actualizada con éxito!"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "Ya existe la Dependencia especificada"));
        }
    }
    
    //por lo momento no utilizo este boton
    public void eliminarDependencia(){
        controller.deleteDependency(selectedDependency);
        selectedDependency = null;
    }
    
    // Getters y Setters
    public List getDependencyList() {
        districtList = controller.getDependencyList();
        return districtList;
    }

    public void setDependencyList(List districtList) {
        this.districtList = districtList;
    }

    public Dependencias getSelectedDependency() {
        return selectedDependency;
    }

    public void setSelectedDependency(Dependencias selectedDependency) {
        this.selectedDependency = selectedDependency;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public String getinterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }
}
