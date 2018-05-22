/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
        
        Usuarios u = new Usuarios();
        u.setId(1);
        u.setAlias("hola");
        u.setNombrecompleto("hola chau");
        
        l.add(u);
        return l;
    }
}
