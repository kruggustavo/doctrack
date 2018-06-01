package controllers;

import entities.seguimiento.Gestiondocumentos;
import java.util.List;
import util.Transactions;

/**
 *
 * @author Lucas Fleitas
 */
public class GestionDocController {
    Transactions t = Transactions.getInstance();
    
    //metodo para insertar y actualizar
    public void saveGestiondocumentos(Gestiondocumentos gdoc){
        t.saveEntity(gdoc);
    }
    
    public List getSeguimientoList(){
        List l = t.getList("from Seguimiento");
        return l;
    }
}
