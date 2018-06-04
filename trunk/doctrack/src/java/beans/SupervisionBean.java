package beans;

import controllers.SupervisionController;
import entities.institucion.Distritos;
import entities.users.Funcionarios;
import entities.institucion.Superviciones;
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
public class SupervisionBean implements Serializable{

    private static final long serialVersionUID = -7768955310856191446L;
   

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
    
    public void editarSupervision()
    {
        selectedDistrict = selectedSupervision.getIdDistrito().getNombre();
        selectedServant = selectedSupervision.getIdFuncionario().getNombreCompleto();
    }
    
    public void guardarSupervision(){ 
        //verifico si la supervision ya no exista       
        int resultadoEnc = controller.getNumsupList(selectedSupervision.getNumeroSupervision()).size();
        System.out.println("tamaño lista "+resultadoEnc);
        if(resultadoEnc <= 0)
        {
            //Buscamos Distrito a partir de la descripcion elegida en pantalla
            Distritos d = null;
            if (selectedDistrict == null){
                d = (Distritos) controller.getDistritosList().get(0);
                selectedDistrict = d.getNombre();
            }else{
                d = controller.getDistrictEntity(selectedDistrict);
            }
            //supervisor que es un funcionario
            Funcionarios f = null;
            if (selectedServant == null){
                f = (Funcionarios) controller.getFuncionariosList().get(0);
                selectedServant = f.getNombreCompleto();
            }else{
                f = controller.getFuncionariosEntity(selectedServant);
            }
            selectedSupervision.setIdDistrito(d);
            selectedSupervision.setIdFuncionario(f);
            //guardamos la supervision
            controller.saveSupervision(selectedSupervision);
            selectedSupervision = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Supervisón creado con éxito"));
       
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "La Supervisión especificada ya existe"));
        }
    }
    
    public void actualizarSupervision(){ 
        //verifico si la supervision ya no exista       
        int resultadoEnc = controller.getActsupList(selectedSupervision.getNumeroSupervision(), selectedSupervision.getId()).size();
        System.out.println("tamaño lista "+resultadoEnc);
        if(resultadoEnc <= 0)
        {
            if(selectedDistrict != null && selectedServant != null)
            {
                Distritos d = null;
                Funcionarios f = null;
                d = controller.getDistrictEntity(selectedDistrict);
                f = controller.getFuncionariosEntity(selectedServant);
                //cargo los datos agregados
                selectedSupervision.setIdDistrito(d);
                selectedSupervision.setIdFuncionario(f);
                //guardamos la supervision
                controller.saveSupervision(selectedSupervision);
                selectedSupervision = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Actualización de Supervisión con éxito"));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "La Supervisión especificada ya existe"));
        }
    }
    
    //por lo momento no usamos este metodo
    public void eliminarSupervision(){
        controller.deleteSupervision(selectedSupervision);
        selectedSupervision = null;
    }
    
    // Getters y Setters
    
    public String getNumeroSupervision() {
        return numeroSupervision;
    }

    public void setNumeroSupervision(String numeroSupervision) {
        this.numeroSupervision = numeroSupervision;
    }
    
    
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
        return funcionariosList;
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
