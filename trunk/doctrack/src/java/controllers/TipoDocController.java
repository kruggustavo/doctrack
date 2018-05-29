/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import util.Transactions;
import entities.seguimiento.Tipodocumento;
import java.util.List;

/**
 *
 * @author Lucas Fleitas
 */
public class TipoDocController {
    Transactions t = Transactions.getInstance();
    
    //metodo para insertar y actualizar
    public void SaveTipoDoc(Tipodocumento tp){
        t.saveEntity(tp);
    }
    
    public List getTipoDocList(){
        List l = t.getList("from Tipodocumento");
        return l;
    }
    
    public void deleteTipoDoc(Tipodocumento tp){
        t.deleteEntity(tp);
    }
}
