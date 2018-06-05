package beans;

import controllers.UserController;
import entities.users.Roles;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author usuario
 */

@ManagedBean
@SessionScoped
public class RolesBean implements Serializable{
    private static final long serialVersionUID = -66807331336342632L;
 
    private UserController controller = new UserController();
    private List<String> yesNoOptions = Arrays.asList(new String[]{"Si", "No"});
    private List rolesList;
    private Roles selectedRol;
    
    public void nuevoRol(){
        selectedRol = new Roles();
        selectedRol.setDescripcion("");
    }
    
    public void eliminarRol(){
        if (rolesList.size() > 1){
            //Obtener cantidad de administradores
            int cantidadAdministradores = controller.getRolAdmins().size();
            
            //Solo eliminamos roles si administradores > 1 y si actual no es administrador
            if (cantidadAdministradores > 1 || selectedRol.getAdministraconfiguraciones().equals("No")){
                if (selectedRol != null){
                    String desc = selectedRol.getDescripcion();
                    selectedRol.setDescripcion("(INACTIVO) " + desc);
                    
                    controller.saveRol(selectedRol);
                }
                selectedRol = null;                            
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aviso", "No se puede eliminar único rol de administrador"));    
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aviso", "No se puede eliminar único rol"));    
        }
    }
    
    public void guardarRol(){
        controller.saveRol(selectedRol);
        selectedRol = null;
    }

    public List getRolesList() {
        rolesList = controller.getRolesList();
        return rolesList;
    }

    public void setRolesList(List rolesList) {
        this.rolesList = rolesList;
    }

    public Roles getSelectedRol() {
        return selectedRol;
    }

    public void setSelectedRol(Roles selectedRol) {
        this.selectedRol = selectedRol;
    }

    public List<String> getYesNoOptions() {
        return yesNoOptions;
    }

    public void setYesNoOptions(List<String> yesNoOptions) {
        this.yesNoOptions = yesNoOptions;
    }
    
    
}
