package beans;

import controllers.SupervisionController;
import entities.institution.Distritos;
import entities.institution.Supervisiones;
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
public class SupervisionBean implements Serializable{
    private static final long serialVersionUID = -6680733133634363295L;

    private String nombreCompleto;
    private String alias;
    private String clave;
    
    private List usersList;
    private List distritosList;
    
    private Supervisiones selectedSupervision;
    private String selectedDistrict;
    
    private SupervisionController controller = new SupervisionController();

    //Métodos usados como actionListeners del CRUD de Supervisions & Distritos
    public void nuevoSupervision(){
        selectedSupervision = new Supervisiones();
    }
    
    public void guardarSupervision(){          
        //Buscamos Distrito a partir de la descripcion elegida en pantalla
        Distritos r = null;
        if (selectedDistrict == null){
            r = (Distritos) controller.getDistritosList().get(0);
            selectedDistrict = r.getNombre();
        }else{
            r = controller.getDistrictEntity(selectedDistrict);
        }
        //selectedSupervision.getIdDistrito(r);
        
        controller.saveSupervision(selectedSupervision);
        selectedSupervision = null;
    }
    
    public void eliminarSupervision(){
        controller.deleteSupervision(selectedSupervision);
        selectedSupervision = null;
    }
    
    // Getters y Setters
    public List getSupervisionList() {
        usersList = controller.getSupervisionList();
        return usersList;
    }

    public void setSupervisionList(List usersList) {
        this.usersList = usersList;
    }

    public Supervisiones getSelectedSupervision() {
        return selectedSupervision;
    }

    public void setSelectedSupervision(Supervisiones selectedSupervision) {
        this.selectedSupervision = selectedSupervision;
    }
    
    public List getDistritosList() {
        distritosList = controller.getDistritosList();
        return distritosList;
    }

    public void setDistritosList(List distritosList) {
        this.distritosList = distritosList;
    }

    public String getSelectedDistrict() {
        return selectedDistrict;
    }

    public void setSelectedDistrict(String selectedDistrict) {
        this.selectedDistrict = selectedDistrict;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
