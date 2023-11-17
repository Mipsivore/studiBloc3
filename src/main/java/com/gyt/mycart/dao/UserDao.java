
package com.gyt.mycart.dao;

import com.gyt.mycart.entities.UserP;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


/**
 * Class used to perform CRUD operations for the User entity.
 * @author Arnaud GUYOT
 */
public class UserDao {
    private final SessionFactory factory;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    //get user by email and password
    public UserP getUserByEmailAndPassword(String email,String password)
    {
        UserP user=null;
        
        try {
            // Preparing the request
            String query="from UserP where userEmail =: e and userPassword=: p";
            try (Session session = this.factory.openSession()) {
                Query q = session.createQuery(query);
                q.setParameter("e", email);
                q.setParameter("p",password);
                user=(UserP) q.uniqueResult();
            }         
            
        } catch ( HibernateException e) {
            e.printStackTrace();
        }     
        
        return user;
    }
    
    
}
