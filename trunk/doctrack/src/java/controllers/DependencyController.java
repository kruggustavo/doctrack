/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.institucion.Dependencias;
import java.util.List;
import util.LoggerUtil;
import util.Transactions;

/**
 *
 * @author usuario
 */

public class DependencyController {
    Transactions t = Transactions.getInstance();
    
    public void saveDependency(Dependencias u){
        t.saveEntity(u);
        LoggerUtil.logInfo("Creacion de Dependencia `" + u.getNombre()+ "`");
    }
    
    public List getDependencyList(){
        List l = t.getList("from Dependencias");
        return l;
    }
    
    public void deleteDependency(Dependencias u){
        t.deleteEntity(u);
    }

    public List getDependenciaNombreList(String nombre) {
        List l = t.getList("from Dependencias where nombre = '"+ nombre +"' ");
        return l;
    }

    public List getDependenciaActList(String nombre, Long id) {
        List l = t.getList("FROM Dependencias WHERE nombre = '"+ nombre +"' and id != '"+ id +"' ");
        return l;
    }
    
}
