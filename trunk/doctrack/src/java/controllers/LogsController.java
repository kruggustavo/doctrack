/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Logs;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.SQLQuery;
import util.HibernateUtil;
import util.Transactions;

/**
 *
 * @author usuario
 */
public class LogsController {
    Transactions t = Transactions.getInstance();
        
    public List getLogs() throws ParseException{
        List result = null;
        
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        
        SQLQuery query = HibernateUtil.getSession().createSQLQuery("SELECT u.alias, log.fecha_hora, log.mensaje, log.nivel FROM (SELECT * FROM Logs l WHERE l.fecha_hora >= :start) AS log LEFT JOIN usuarios u ON log.idUsuario = u.id ORDER BY log.fecha_hora DESC");
        query.setParameter("start", c.getTime());

        List<Object[]> rows = query.setMaxResults(60).list();
        
        if (rows.size() > 0){
            result = new ArrayList();
            for(Object[] row : rows){
                Logs l = new Logs();
                l.setIdUsuario(row[0].toString());
                l.setFechaHora(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(row[1].toString()));
                l.setMensaje(row[2].toString());
                l.setNivel(row[3].toString());         
                result.add(l);
            }
        }
        return result;
    }
}
