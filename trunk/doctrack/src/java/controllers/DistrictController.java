/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.institucion.Distritos;
import java.util.List;
import util.Transactions;

/**
 *
 * @author Javier Arza
 */
public class DistrictController {
    Transactions t = Transactions.getInstance();
    
    public void saveDistrict(Distritos d){
        t.saveEntity(d);
    }
    
    public List getDistrictList(){
        List l = t.getList("from Distritos");
        return l;
    }
    
    public void deleteDistrict(Distritos d){
        t.deleteEntity(d);
    }
    
}
