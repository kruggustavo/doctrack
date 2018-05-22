/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class Transactions {
    private static Transactions instance;
    
    public static Transactions getInstance(){
        if (instance == null){
            instance = new Transactions();
        }
        return instance;
    }
    
    public void saveEntity(Object o){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();        
        s.beginTransaction();       
        s.saveOrUpdate(o);    
        s.getTransaction().commit(); 
    }
    
    public List getList(String hql){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();        
        s.beginTransaction();        
        List objects = s.createQuery(hql).list();
        s.getTransaction().commit(); 
        
        return objects;
    }
    
    public Object getEntity(String hql){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();        
        s.beginTransaction();       
        Object object = s.createSQLQuery(hql).list().get(0);
        s.getTransaction().commit(); 
        
        return object;
    }    
}
