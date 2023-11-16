package com.gyt.mycart.entities;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Arnaud GUYOT
 */

public class UserTest {
    
    @Test
    public void emailTest() {
        UserP user = new UserP();
        
        // Test d'email conforme
        String emailAsStringCorrect1 = "nom.@gmail.com";
        // assertTrue : Affirme que la réponse doit être true
        Assert.assertTrue(user.checkValidEmail(emailAsStringCorrect1));

        // Test d'email non conforme
        String emailAsStringIncorrect1 = "@gmail.com";
        // assertTrue : Affirme que la réponse doit être false
        Assert.assertFalse(user.checkValidEmail(emailAsStringIncorrect1));
    }
    
}
