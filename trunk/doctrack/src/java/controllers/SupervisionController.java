/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.institution.Distritos;
import entities.institution.Supervisiones;
import java.util.List;
import util.Transactions;

/**
 *
 * @author usuario
 */
public class SupervisionController {
    Transactions t = Transactions.getInstance();
    
    public void saveSupervision(Supervisiones u){
        t.saveEntity(u);
    }
    
    public List getSupervisionList(){
        List l = t.getList("from Supervisiones");
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
    
    public void deleteSupervision(Supervisiones u){
        t.deleteEntity(u);
    }
    
}
