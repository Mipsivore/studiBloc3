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
        
        // Compliant Email Test
        String emailAsStringCorrect1 = "nom.@gmail.com";
        // assertTrue : Asserts that the answer must be true
        Assert.assertTrue(user.checkValidEmail(emailAsStringCorrect1));

        // Non-compliant email test
        String emailAsStringIncorrect1 = "@gmail.com";
        // assertTrue : Asserts that the answer must be false
        Assert.assertFalse(user.checkValidEmail(emailAsStringIncorrect1));
    }
    
}
