package beans;

import controllers.SupervisionController;
import entities.institucion.Distritos;
import entities.users.Funcionarios;
import entities.institucion.Superviciones;
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

    private Long id;
    private String numeroSupervision;
    private String direccion;
    private String telefono;
    private String email;
    
    private List supervisionList;
    private List distritosList;
    private List funcionariosList;
    
    private Superviciones selectedSupervision;
    private String selectedDistrict;
    private String selectedServant;
    
    private SupervisionController controller = new SupervisionController();

    //Métodos usados como actionListeners del CRUD de Supervisions & Distritos
    public void nuevoSupervision(){
        selectedSupervision = new Superviciones();
    }
    
    public void guardarSupervision(){          
        //Buscamos Distrito a partir de la descripcion elegida en pantalla
        Distritos d = null;
        if (selectedDistrict == null){
            d = (Distritos) controller.getDistritosList().get(0);
            selectedDistrict = d.getNombre();
        }else{
            d = controller.getDistrictEntity(selectedDistrict);
        }
        selectedSupervision.setIdDistrito(d);
        
        Funcionarios f = null;
        if (selectedServant == null){
            f = (Funcionarios) controller.getFuncionariosList().get(0);
            selectedServant = f.getNombreCompleto();
        }else{
            f = controller.getFuncionariosEntity(selectedServant);
        }
        selectedSupervision.setIdFuncionario(f);
        
        controller.saveSupervision(selectedSupervision);
        selectedSupervision = null;
    }
    
    public void eliminarSupervision(){
        controller.deleteSupervision(selectedSupervision);
        selectedSupervision = null;
    }
    
    // Getters y Setters
    public List getSupervisionList() {
        supervisionList = controller.getSupervisionList();
        return supervisionList;
    }

    public void setSupervisionList(List supervisionList) {
        this.supervisionList = supervisionList;
    }

    public Superviciones getSelectedSupervision() {
        return selectedSupervision;
    }

    public void setSelectedSupervision(Superviciones selectedSupervision) {
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
    
        
    public List getFuncionariosList() {
        funcionariosList = controller.getFuncionariosList();
        return distritosList;
    }

    public void setFuncionariosList(List funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

      public String getSelectedServant() {
        return selectedServant;
    }

    public void setSelectedServant(String selectedServant) {
        this.selectedServant = selectedServant;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnumeroSupervision() {
        return numeroSupervision;
    }

    public void setnumeroSupervision(String numeroSupervision) {
        this.numeroSupervision = numeroSupervision;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
     public String getTelefono() {
        return telefono;
    }

    public void setClave(String telefono) {
        this.telefono = telefono;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
