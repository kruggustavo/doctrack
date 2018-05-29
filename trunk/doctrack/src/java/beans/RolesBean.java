package beans;

import controllers.UserController;
import entities.users.Roles;
import entities.users.Usuarios;
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
public class RolesBean implements Serializable{
    private static final long serialVersionUID = -66807331336342632L;
    
    private UserController controller = new UserController();

    private List rolesList;
    private Roles selectedRol;
    
    public void nuevoRol(){
        
    }
    
    public void eliminarRol(){
        
    }
    
    public void guardarRol(){
        
    }

    public List getRolesList() {
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
    
    
}
