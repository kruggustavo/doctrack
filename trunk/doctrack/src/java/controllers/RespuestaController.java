/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.seguimiento.Respuesta;
import entities.seguimiento.Seguimiento;
import entities.seguimiento.Tipodocumento;
import entities.users.Funcionarios;
import java.util.List;
import util.LoggerUtil;
import util.Transactions;

/**
 *
 * @author Lucas Fleitas
 */
public class RespuestaController {
    Transactions t = Transactions.getInstance();
    
    public void saveRespuesta(Respuesta rp){
        t.saveEntity(rp);
        LoggerUtil.logInfo("Registro Respuesta de Documentos Concluido Nª  `" + rp.getNumero() + "`");
    }
    
    public void saveSeguimiento(Seguimiento sg)
    {
        t.saveEntity(sg);
    }
    
    public List getSeguientoNoRespList(){
        //List l = t.getList("from Roles where administraconfiguraciones ='Si'");
        List l = t.getList("from Seguimiento where nuevoCampo ='No' and estadogeneral ='Concluido'");
//        List l = t.getList("from Seguimiento where estadogeneral '"+ "Concluido" +"' and nuevoCampo = '"+"No"+"'");
        return l;
    }
    
    //verifico que el numero de respuesta con el mismo tipo de documento ya no exista
    public List getNumRespuestaList(String numero, String idTipoDoc)
    {
        List l = t.getList("FROM Respuesta WHERE numero = '"+ numero +"' and idTipoDoc = '"+ idTipoDoc +"' ");
        return l;
    }
    
    //lista de claves foraneas
    public List getListFuncionarios()
    {
        List l = t.getList("from Funcionarios");
        return l;
    }
    
    public List getListTipodocumento()
    {
        List l = t.getList("from Tipodocumento");
        return l;
    }
    
    public Tipodocumento getTipodocumentoEntity(String id) {
        Tipodocumento tp = (Tipodocumento) t.getEntity("from Tipodocumento where id = '" + id + "'");
        return tp;
    }

    public Funcionarios getFuncionariooEntity(String ci) {
        Funcionarios f = (Funcionarios) t.getEntity("from Funcionarios where ci = '" + ci + "'");
        return f;
    }

    public Seguimiento getSeguimientoEntity(Long id) {
        Seguimiento sg = (Seguimiento) t.getEntity("from Seguimiento where id = '" + id + "'");
        return sg;
    }
    
}
