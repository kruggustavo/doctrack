package controllers;

import entities.institucion.Areas;
import entities.seguimiento.Gestiondocumentos;
import entities.seguimiento.Seguimiento;
import java.util.List;
import util.LoggerUtil;
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
        LoggerUtil.logInfo("Nuevo Movimiento de Seguimiento Nª  `" + gdoc.getIdSeguimiento().getId() + "`");
    }
    
    //tambien creo un metodo saveSeguimiento aquie para que actualice el estado general
    public void saveSeguimiento(Seguimiento segDoc)
    {
        t.saveEntity(segDoc);
        LoggerUtil.logInfo("Cambio de Estado de Seguimiento de Documento Nª  `" + segDoc.getId() + "`");
    }
    
    public List getSeguimientoList(){
        List l = t.getList("from Seguimiento sg where sg.estadogeneral = '"+"Recibido"+"' or sg.estadogeneral = '"+"Procesado"+"' order by sg.id desc");
        return l;
    }
    
    public List getAreasList()
    {
        List l = t.getList("from Areas");
        return l;
    }
    
    public Areas getAreaEntity(String nombre)
    {
        Areas l = (Areas) t.getEntity("from Areas where nombre = '"+ nombre +"' ");
        return l;
    }
    
    public List getUltimaGestionList(Long idSeguimiento){ //limit 1 no funciona en hibernate
        List l = t.getList("from Gestiondocumentos gd where gd.idSeguimiento = '"+ idSeguimiento +"' order by gd.id desc");
        return l;
    }
}
