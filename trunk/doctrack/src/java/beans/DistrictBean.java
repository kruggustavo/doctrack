package beans;

import controllers.DistrictController;
import entities.institucion.Distritos;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Javier Arza
 */
@ManagedBean
@SessionScoped
public class DistrictBean implements Serializable{

    private static final long serialVersionUID = 445916045977154381L;
    

    private String nombre;
    private List districtList;
    //objeto distrito que se usara al seleccionar
    private Distritos selectedDistrict;
    private DistrictController controller = new DistrictController();

    //Métodos usados como actionListeners del CRUD de Distritos & Roles
    public void nuevoDistrito(){
        selectedDistrict = new Distritos();
    }
    
    public void guardarDistrito(){    
        int resultadoEnc = controller.getDistritoNombreList(selectedDistrict.getNombre()).size();
        System.out.println("tamaño lista "+resultadoEnc);
        if(resultadoEnc <= 0)
        {
            controller.saveDistrict(selectedDistrict);
            selectedDistrict = null; 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Distrito Creado con éxito!"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "Ya existe el Distrito especificado"));
        }
    }
    
    public void actualizarDistrito()
    {
        int resultadoEnc = controller.getDistritoActList(selectedDistrict.getNombre(), selectedDistrict.getId()).size();
        System.out.println("tamaño lista "+resultadoEnc);
        if(resultadoEnc <= 0)
        {
            controller.saveDistrict(selectedDistrict);
            selectedDistrict = null; 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Distrito Actualizado con éxito!"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "Ya existe el Distrito especificado"));
        }
    }
    
    //por lo momento no estoy usando este metodo, porque causara error en los FK
    public void eliminarDistrito(){
        controller.deleteDistrict(selectedDistrict);
        selectedDistrict = null;
    }
    
    // Getters y Setters
    public List getDistrictList() {
        districtList = controller.getDistrictList();
        return districtList;
    }

    public void setDistrictList(List districtList) {
        this.districtList = districtList;
    }

    public Distritos getSelectedDistrict() {
        return selectedDistrict;
    }

    public void setSelectedDistrict(Distritos selectedDistrict) {
        this.selectedDistrict = selectedDistrict;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
