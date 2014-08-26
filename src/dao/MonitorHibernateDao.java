/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controle.MonitorControle;
import java.util.ArrayList;
import java.util.List;
import modelo.Monitor;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author manuela
 */
public class MonitorHibernateDao implements MonitorControle{

    @Override
    public void salvar(Monitor monitor) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.save(monitor);
        t.commit();
        session.close();
        
    }

    @Override
    public void excluir(Monitor monitor) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.delete(monitor);
        t.commit();
        session.close();
        
    }

    @Override
    public ArrayList<Monitor> listar() {
        
        
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Monitor.class);
        ArrayList<Monitor> listaMonitores = (ArrayList<Monitor>) criteria.list();
        
        session.close();
        
        return listaMonitores;
    }

    @Override
    public void atualizar(Monitor monitor) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.update(monitor);
        t.commit();
        session.close();
        
    }
    
}
 