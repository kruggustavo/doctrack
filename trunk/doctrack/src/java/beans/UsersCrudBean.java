/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.UserController;
import entities.users.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author usuario
 */

@ManagedBean
@ViewScoped
public class UsersCrudBean implements Serializable{
    private List usersList;
    private Usuarios selectedUser;
    private UserController controller = new UserController();

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
    
    
}
