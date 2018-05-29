package beans;

import controllers.DependencyController;
import entities.institucion.Dependencias;
import java.io.Serializable;
import java.util.List;;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author usuario
 */

@ManagedBean
@SessionScoped
public class DependencyBean implements Serializable{
    private static final long serialVersionUID = -6680733133634363295L;

    private Integer id;
    private String nombre;
    private String email;
    private String interno;
    
    
    private List districtList;
    
    
    private Dependencias selectedDependency;
    
    
    private DependencyController controller = new DependencyController();

    //Métodos usados como actionListeners del CRUD de Dependencias & Roles
    public void nuevoDependencia(){
        selectedDependency = new Dependencias();
    }
    
    public void guardarDependencia(){                  
        controller.saveDependency(selectedDependency);
        selectedDependency = null;
    }
    
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
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
