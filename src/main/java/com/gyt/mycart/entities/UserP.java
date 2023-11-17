package com.gyt.mycart.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, name = "user_id")
    private int userId;
    
    @Column(length = 100, name = "user_name")
    private String userName;
    @Column(length = 100, name = "user_email")
    private String userEmail;
    @Column(length = 100, name = "user_password")
    private String userPassword;
    @Column(length = 12, name = "user_phone")
    private String userPhone;
    @Column(length = 1500, name = "user_pic")
    private String userPic;
    @Column(length = 1500, name = "user_address")
    private String userAddress;
    @Column(name="user_type")
    private String userType;
    
    
    public UserP() {
    }
        
    public UserP(int userId, String userName, String userEmail, String userPassword, String userPhone, String userPic, String userAddress,String userType) {
        this.userId = userId;
        
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userPic = userPic;
        this.userAddress = userAddress;
        this.userType=userType;
        
    }

    public UserP(String userName, String userEmail, String userPassword, String userPhone, String userPic, String userAddress,String userType) {
        
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userPic = userPic;
        this.userAddress = userAddress;
        this.userType=userType;
        
    }

    /**
     * Controls the email provided in the form of a chain, 
     * as having a compliant format.
     * @param email as String email offered in string format.
     * @return True email in valid format, False email in invalid format.
     */
    public boolean checkValidEmail(String emailAsString) {
        // Compliant email test regular expression
        // (created using https://regex101.com/)
        // Ideally we should follow this recommendation : RFC822
        
        // NB : The regular expression below is not perfect and will validate 
        // as correct this email : name.@gmail.com
        
        // The email must begin with a string composed of characters
         // the alphabet in upper/lower case,
         // of the underlined character "_"
         // and ending with a period character "."
         // Present at least once.
        
         // followed by the @ character (obligatory presence)
        
         // followed by a group of a string composed of characters
         // the alphabet in upper/lower case,
         // of the underscore character "_" and ending with a period character "."
         // Present at least once.
        
         // ending with a group of a string composed of characters
         // uppercase/lowercase alphabet
         // of the underlined character "_"
         // With a length of at least 2 to 4 characters at most.
        String mailpattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        // Compilation
        Pattern p = Pattern.compile(mailpattern);
        
        // Comparison Analysis
        Matcher m = p.matcher(emailAsString);
        return m.find();
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userPhone=" + userPhone + ", userPic=" + userPic + ", userAddress=" + userAddress + '}';
    }
    
}
