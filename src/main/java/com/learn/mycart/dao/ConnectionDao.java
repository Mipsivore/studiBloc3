package com.learn.mycart.dao;

import com.learn.mycart.entities.UserConnection;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ConnectionDao {

    private SessionFactory factory;

    public ConnectionDao(SessionFactory factory) {
        this.factory = factory;
    }

    public int saveConnection(UserConnection uconnection) {
        
        int CoId=0;
        try {

            Session session = this.factory.openSession();
            Transaction tx = session.beginTransaction();

            CoId = (int) session.save(uconnection);

            tx.commit();
            session.close();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return CoId;
    }

    
    //Get the number of products
    public int getVisitorsNb() {
        Session s = this.factory.openSession();
        Query query = s.createQuery("from UserConnection");
        List<UserConnection> list = query.list();
        int Nb=list.size();
        return Nb;
    }
}
