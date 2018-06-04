/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.seguimiento.Tramitantes;
import java.util.List;
import util.Transactions;

/**
 *
 * @author Lucas Fleitas
 */

public class TramitantesController {
    Transactions t = Transactions.getInstance();
    
    //metodo para insertar y actualizar
    public void saveTramitantes(Tramitantes tr){
        t.saveEntity(tr);
    }
    
    public List getTramitantesList(){
        List l = t.getList("from Tramitantes");
        return l;
    }
    
    public List getTramitantCiList(String ci){
        List l = t.getList("from Tramitantes where ci = '"+ ci +"' ");
        return l;
    }

    public List getTramitanteActList(String ci, Long id) {
        List l = t.getList("FROM Tramitantes WHERE ci = '"+ ci +"' and id != '"+ id +"' ");
        return l;
    }
}
