package beans;

import controllers.UserController;
import entities.users.Roles;
import entities.users.Usuarios;
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
public class UsersBean implements Serializable{
    private static final long serialVersionUID = -6680733133634363295L;

    private String nombreCompleto;
    private String alias;
    private String clave;
    
    private List usersList;
    private List rolesList;
    
    private Usuarios selectedUser;
    private String selectedRole;
    
    private UserController controller = new UserController();

    //Métodos usados como actionListeners del CRUD de Usuarios & Roles
    public void nuevoUsuario(){
        selectedUser = new Usuarios();
        selectedUser.setAlias("");
    }
    
    public void editarUsuario(){
        selectedRole = selectedUser.getIdRol().getDescripcion();
    }
    
    public void guardarUsuario(){          
        //Buscamos Rol a partir de la descripcion elegida en pantalla
        Roles r = null;
        if (selectedRole == null){
            r = (Roles) controller.getRolesList().get(0);
            selectedRole = r.getDescripcion();
        }else{
            r = controller.getRolEntity(selectedRole);
        }
        selectedUser.setIdRol(r);
        
        controller.saveUser(selectedUser);
        selectedUser = null;
    }
    
    public void eliminarUsuario(){
        if (usersList.size() > 1){
            //Obtener cantidad de administradores
            int cantidadAdministradores = controller.getAdminUsers().size();
            
            //Solo eliminamos roles si administradores > 1 y si actual no es administrador
            if (cantidadAdministradores > 1 || selectedUser.getIdRol().getAdministraconfiguraciones().equals("No")){
                controller.deleteUser(selectedUser);
                selectedUser = null;                           
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aviso", "No se puede eliminar único administrador"));    
            }
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aviso", "No se puede eliminar único usuario"));    
        }        
    }
    
    // Getters y Setters
    public List getUsersList() {
        usersList = controller.getUsersList();
        return usersList;
    }

    public void setUsersList(List usersList) {
        this.usersList = usersList;
    }

    public Usuarios getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Usuarios selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    public List getRolesList() {
        rolesList = controller.getRolesList();
        return rolesList;
    }

    public void setRolesList(List rolesList) {
        this.rolesList = rolesList;
    }

    public String getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(String selectedRole) {
        this.selectedRole = selectedRole;
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
