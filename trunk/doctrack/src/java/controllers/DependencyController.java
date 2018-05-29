/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.institucion.Dependencias;
import java.util.List;
import util.Transactions;

/**
 *
 * @author usuario
 */
public class DependencyController {
    Transactions t = Transactions.getInstance();
    
    public void saveDependency(Dependencias u){
        t.saveEntity(u);
    }
    
    public List getDependencyList(){
        List l = t.getList("from Dependencias");
        return l;
    }
    
    public void deleteDependency(Dependencias u){
        t.deleteEntity(u);
    }
    
}
