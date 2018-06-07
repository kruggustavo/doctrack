/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.institucion.Superviciones;
import entities.seguimiento.Documentos;
import entities.seguimiento.Seguimiento;
import entities.seguimiento.Tipodocumento;
import entities.seguimiento.Tramitantes;
import java.util.List;
import util.LoggerUtil;
import util.Transactions;

/**
 *
 * @author Lucas Fleitas
 */

public class DocumentosController {
     Transactions t = Transactions.getInstance();
    
    //metodo para insertar y actualizar
    public void saveDocumentos(Documentos dc){
        t.saveEntity(dc);
        LoggerUtil.logInfo("Registro de Documento Nª  `" + dc.getNumeroDoc() + "`");
    }
    
    //metodo para insertar y actualizar de seguimiento
    public void saveSeguimiento(Seguimiento sg)
    {
        t.saveEntity(sg);
        LoggerUtil.logInfo("Registro de Seguimiento de Documento Nª  `" + sg.getId() + "`");
    }
    
    public List getDocumentosList(){
        List l = t.getList("from Documentos dc order by dc.id desc");
        return l;
    }
    
    //metodos para obtener el tramitante como clave foranea
    public List getTramitantesList(){
        List l = t.getList("from Tramitantes");
        return l;
    }
    
    public Tramitantes getTramitanteEntity(String ci){
        Tramitantes l = (Tramitantes) t.getEntity("from Tramitantes where ci ='" + ci + "'");
        return l;
    }
    
    //metodos para obtener la supervicion como clave foranea
    public List getSupervicionList(){
        List l = t.getList("from Superviciones");
        return l;
    }
    
    public Superviciones getSupervicionEntity(String numeroSupervision){
        Superviciones l = (Superviciones) t.getEntity("from Superviciones where numeroSupervision ='" + numeroSupervision + "'");
        return l;
    }
    
    public Seguimiento getSeguimientoEntity(Long idDocumento)
    {
        Seguimiento l = (Seguimiento) t.getEntity("from Seguimiento where idDocumento = '"+ idDocumento +"' ");
        return l;
    }
    
    public List getNumdocList(String numeroDoc)
    {
        List l = t.getList("from Documentos where numeroDoc = '"+ numeroDoc +"' ");
        return l;
    }
    
    public List getTipodocumentoList()
    {
        List l = t.getList("from Tipodocumento");
        return l;
    }

    public Tipodocumento getTipodocumentoEntity(String tipodocumento) {
        Tipodocumento l = (Tipodocumento) t.getEntity("from Tipodocumento where nombre ='" + tipodocumento + "'");
        return l;
    }

    public List getDocActList(String numeroDoc, Long id) {
        List l = t.getList("FROM Documentos WHERE numeroDoc = '"+ numeroDoc +"' and id != '"+ id +"' ");
        return l;
    }

    public List getSegEstadoList(String numeroDoc) {
        List l = t.getList("FROM Seguimiento WHERE idDocumento = '"+ numeroDoc +"' and estadogeneral = '"+ "Anulado" +"' ");
        return l;
    }
    
}
