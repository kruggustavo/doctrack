/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.UserController;
import entities.users.Roles;
import entities.users.Usuarios;
import java.io.Serializable;
import java.util.List;;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

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
    //private Usuarios newUser;
    private Roles selectedRole;
    
    private UserController controller = new UserController();

    public void nuevoUsuario(){
        System.out.println("Nuevo");
        selectedUser = null;
        alias = "";
        clave = "";
        nombreCompleto = ""; 
    }
    
    public void guardarUsuario(){
        if (selectedRole == null){
            selectedRole = (Roles) controller.getRolesList().get(0);
        }
        if (selectedUser == null) selectedUser = new Usuarios();
        
        selectedUser.setAlias(alias);
        selectedUser.setClave(clave);
        selectedUser.setNombrecompleto(nombreCompleto);
        selectedUser.setIdRol(selectedRole);
       
        System.out.println("alias=");
        System.out.println(alias);
        
        //controller.saveUser(selectedUser);                
    }
    
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

    public Roles getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(Roles selectedRole) {
        this.selectedRole = selectedRole;
    }
/*
    public Usuarios getNewUser() {
        return newUser;
    }

    public void setNewUser(Usuarios newUser) {
        this.newUser = newUser;
    }
*/
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
