/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.institucion.Superviciones;
import entities.seguimiento.Documentos;
import entities.seguimiento.Seguimiento;
import entities.seguimiento.Tramitantes;
import java.util.List;
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
    }
    
    //metodo para insertar y actualizar de seguimiento
    public void saveSeguimiento(Seguimiento sg)
    {
        t.saveEntity(sg);
    }
    
    public List getDocumentosList(){
        List l = t.getList("from Documentos");
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
    
    public Documentos getDocumentoEntity(String numeroDoc)
    {
        Documentos l = (Documentos) t.getEntity("from Documentos where numeroDoc = '"+ numeroDoc +"' ");
        return l;
    }
}
