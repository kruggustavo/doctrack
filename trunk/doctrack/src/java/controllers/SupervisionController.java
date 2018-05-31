/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.institucion.Distritos;
import entities.institucion.Superviciones;
import java.util.List;
import util.Transactions;

/**
 *
 * @author usuario
 */
public class SupervisionController {
    Transactions t = Transactions.getInstance();
    
    public void saveSupervision(Superviciones u){
        t.saveEntity(u);
    }
    
    public List getSupervisionList(){
        List l = t.getList("from Superviciones");
        return l;
    }
    
    public List getDistritosList(){
        List l = t.getList("from Distritos");
        return l;
    }
    
    public Distritos getDistrictEntity(String nombre){
        Distritos l = (Distritos) t.getEntity("from Distritos where nombre  ='" + nombre + "'");
        return l;
    }
    
    public void deleteSupervision(Superviciones u){
        t.deleteEntity(u);
    }
    
}
