/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import org.hibernate.HibernateException;
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
        s.getTransaction().begin();       
        s.saveOrUpdate(o);    
        s.getTransaction().commit();        
    }
    
    public List getList(String hql){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();        
        s.getTransaction().begin();      
        List objects = s.createQuery(hql).list();
        s.getTransaction().commit(); 
        
        return objects;
    }
    
    public Object getEntity(String hql){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();        
        s.getTransaction().begin();     
        Object object = s.createQuery(hql).list().get(0);
        s.getTransaction().commit(); 
        
        return object;
    }    
    
    public void deleteEntity(Object o){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();        
        s.getTransaction().begin();       
        s.delete(o);
        s.getTransaction().commit();         
    }
    
    public void executeSqlQuery(String sql){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();    
        try {
            s.getTransaction().begin();
            s.createSQLQuery(sql).executeUpdate();
            s.getTransaction().commit();
        }
        catch (HibernateException err){
            s.getTransaction().rollback();
        }finally{
            
        }         
    }
}
