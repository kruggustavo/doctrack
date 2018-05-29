/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.users.Funcionarios;
import entities.resolution.Resolucion;
import java.util.List;
import util.Transactions;
/**
 *
 * @author user
 */
public class ResolutionController {
     Transactions t = Transactions.getInstance();
    
    public void saveResolution(Resolucion re){
        t.saveEntity(re);
    }
    
    public List getResolutionList(){
        List l = t.getList("from Resolucion");
        return l;
    }
    
    public List getFuncionariosList(){
        List l = t.getList("from Funcionarios");
        return l;
    }
    
    public Funcionarios getFuncionariosEntity(String nombre_completo){
        Funcionarios f = (Funcionarios) t.getEntity("from Funcionarios where nombre_completo ='" + nombre_completo + "'");
        return f;
    }
    
    public void deleteResolution(Resolucion re){
        t.deleteEntity(re);
    }
    
}
