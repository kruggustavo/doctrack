/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.users.Funcionarios;
import entities.users.Roles;
import entities.users.Usuarios;
import java.util.List;
import util.LoggerUtil;
import util.Transactions;

/**
 *
 * @author usuario
 */
public class UserController {
    Transactions t = Transactions.getInstance();
    
    public void saveUser(Usuarios u){        
        t.saveEntity(u);
        LoggerUtil.logInfo("Creacion usuario con alias `" + u.getAlias() + "`");
    }
    
    public Usuarios getLoginUser(String user, String pass){
        Usuarios u;
        try{
            u = (Usuarios) t.getList("from Usuarios where alias = '" + user + "' and clave = '" + pass + "'").get(0);
        }catch (java.lang.IndexOutOfBoundsException n){
            u = null;
        }
        return u;
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
        LoggerUtil.logInfo("Eliminacion usuario con alias `" + u.getAlias() + "`");
    }
    
    public void saveRol(Roles r){
        t.saveEntity(r);
        LoggerUtil.logInfo("Creacion rol de usuario `" + r.getDescripcion() + "`");
    }
    
    public void deleteRol(Roles r){
        t.deleteEntity(r);
        LoggerUtil.logInfo("Eliminacion rol de usuario `" + r.getDescripcion() + "`");
    }
    
    public List getRolAdmins(){
        List l = t.getList("from Roles where administraconfiguraciones ='Si'");
        return l;
    }
    
    public List getAdminUsers(){
        List l = t.getList("from Usuarios where idRol.administraconfiguraciones ='Si'");
        return l;
    }
    
    public void saveEmployee(Funcionarios r){
        t.saveEntity(r);
    }
    
    public void deleteEmployee(Funcionarios r){        
        t.deleteEntity(r);
        LoggerUtil.logInfo("Eliminacion funcionario ´" + r.getNombreCompleto() + "´");
    }
    
    public List getEmployeesList(){
        List l = t.getList("from Funcionarios where nombreCompleto not like '(INACTIVO)%'");
        return l;
    }
    
    public void executeSqlQuery(String sql){
        t.executeSqlQuery(sql);
    }
}
