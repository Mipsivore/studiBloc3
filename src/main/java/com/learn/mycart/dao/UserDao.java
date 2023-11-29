    
package com.learn.mycart.dao;

import com.learn.mycart.entities.UserP;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UserDao {
    private SessionFactory factory;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    //get user by email and password
    public UserP getUserByEmailAndPassword(String email,String password)
    {
        UserP user=null;
        
        try {
            
            String query="from UserP where userEmail =: e and userPassword=: p";
            Session session = this.factory.openSession();
            Query q = session.createQuery(query);
            q.setParameter("e", email);
            q.setParameter("p",password);            
            user=(UserP) q.uniqueResult();         
            session.close();         
            
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }     
        
        
        
        
        return user;
    }
    
    
}
