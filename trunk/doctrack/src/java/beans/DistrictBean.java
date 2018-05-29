package beans;

import controllers.DistrictController;
import entities.institution.Distritos;
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
public class DistrictBean implements Serializable{
    private static final long serialVersionUID = -6680733133634363295L;

    private Integer id;
    private String nombre;
    
    
    private List districtList;
    
    
    private Distritos selectedDistrict;
    
    
    private DistrictController controller = new DistrictController();

    //Métodos usados como actionListeners del CRUD de Distritos & Roles
    public void nuevoDistrito(){
        selectedDistrict = new Distritos();
    }
    
    public void guardarDistrito(){                  
        controller.saveDistrict(selectedDistrict);
        selectedDistrict = null;
    }
    
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
}
