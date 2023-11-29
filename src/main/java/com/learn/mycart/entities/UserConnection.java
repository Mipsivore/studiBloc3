package com.learn.mycart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class UserConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CoId;
    private String uAdressIp;
    private LocalDateTime CoDateTime;
    
   
    public UserConnection() {
    }

    public UserConnection(int CoId, String uAdressIp, LocalDateTime CoDateTime) {
        this.CoId = CoId;
        this.uAdressIp = uAdressIp;
        this.CoDateTime = CoDateTime;
    }

    public UserConnection(String uAdressIp, LocalDateTime CoDateTime) {
        this.uAdressIp = uAdressIp;
        this.CoDateTime = CoDateTime;
    }
    
    

    public int getCoId() {
        return CoId;
    }

    public void setCoId(int CoId) {
        this.CoId = CoId;
    }

    public String getuAdressIp() {
        return uAdressIp;
    }

    public void setuAdressIp(String uAdressIp) {
        this.uAdressIp = uAdressIp;
    }

    public LocalDateTime getCoDateTime() {
        return CoDateTime;
    }

    public void setCoDateTime(LocalDateTime CoDateTime) {
        this.CoDateTime = CoDateTime;
    }

    
    @Override
    public String toString() {
        return "Connection{" + "CoId=" + CoId + ", uAdressIp=" + uAdressIp + ", CoDateTime=" + CoDateTime + '}';
    }
    
   
}
