package com.learn.mycart.entities;

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
     * Contrôle l'email fournit sous forme de chaine, 
     * comme ayant un format conforme.
     * @param emailAsString email proposé en format chaîne.
     * @return True email au format valide, False email dont le format 
     * est invalide.
     */
    public boolean checkValidEmail(String emailAsString) {
        // Expression régulière de test de mail conforme 
        // (crée avec le site https://regex101.com/)
        // Idéalement il faut suivre cette préconnisation : RFC822
        
        // NB : L'expression régulière ci-dessous n'est pas parfaite et validera 
        // comme correct cette email : nom.@gmail.com
        
        // Le mail doit débuter avec une chaine composée de caractère 
        // de l'alphabet en majuscule/minuscule, 
        // du caractère souligné "_" 
        // et se finissant pas un caractère point "."
        // Présent au moins une fois.
        
        // suivi du caractère @ (présence obligatoire)
        
        // suivi d'un groupe d'une chaine composée de caractères 
        // de l'alphabet en majuscule/minuscule, 
        // du caractère souligné "_" et se finissant pas un caractère point "."
        // Présent au moins une fois.
        
        // se finissant d'un groupe d'une chaine composée de caractères 
        // de l'alphabet en majuscule/minuscule 
        // du caractère souligné "_" 
        // Avec une longueur de 2 au moins à 4 caratères au plus.
        String mailpattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        // Compilation
        Pattern p = Pattern.compile(mailpattern);
        
        // Analyse de correspondance
        Matcher m = p.matcher(emailAsString);
        return m.find();
    }
    
    public UserP() {
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
