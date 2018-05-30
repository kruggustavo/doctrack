/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.users.Roles;
import entities.users.Usuarios;
import java.util.List;
import util.Transactions;

/**
 *
 * @author usuario
 */
public class UserController {
    Transactions t = Transactions.getInstance();
    
    public void saveUser(Usuarios u){
        t.saveEntity(u);
    }
    
    public List getUsersList(){
        List l = t.getList("from Usuarios");
        return l;
    }
    
    public List getRolesList(){
        List l = t.getList("from Roles");
        return l;
    }
    
    public Roles getRolEntity(String descripcion){
        Roles l = (Roles) t.getEntity("from Roles where descripcion ='" + descripcion + "'");
        return l;
    }
    
    public void deleteUser(Usuarios u){
        t.deleteEntity(u);
    }
    
    public void saveRol(Roles r){
        t.saveEntity(r);
    }
    
    public void deleteRol(Roles r){
        t.deleteEntity(r);
    }
    
    public List getRolAdmins(){
        List l = t.getList("from Roles where administraconfiguraciones ='Si'");
        return l;
    }
    
    public List getAdminUsers(){
        List l = t.getList("from Usuarios where idRol.administraconfiguraciones ='Si'");
        return l;
    }
    
    
}
