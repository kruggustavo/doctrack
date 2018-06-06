/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.institucion.Areas;
import entities.institucion.Dependencias;
import java.util.List;
import util.LoggerUtil;
import util.Transactions;

/**
 *
 * @author Lucas Fleitas
 */

public class AreasController {
    
    Transactions t = Transactions.getInstance();
    
    public void saveAreas(Areas a){
        t.saveEntity(a);
        LoggerUtil.logInfo("Creacion de Sector `" + a.getNombre()+ "`");
    }
    
    public List getAreasList(){
        List l = t.getList("from Areas");
        return l;
    }
    
    //lista de dependencias
    public List getDependenciasList(){
        List l = t.getList("from Dependencias");
        return l;
    }
    
    public Dependencias getDependenciaEntity(String nombre)
    {
        Dependencias dp = (Dependencias) t.getEntity("from Dependencias where nombre  ='" + nombre + "'");
        return dp;
    }

    public List getNombreAreaList(String nombre) {
        List l = t.getList("from Areas where nombre = '"+ nombre +"' ");
        return l;
    }

    public List getActareaList(String nombre, Long id) {
        List l = t.getList("FROM Areas WHERE nombre = '"+ nombre +"' and id != '"+ id +"' ");
        return l;
    }
}
