package com.example.demo.model;

import javax.persistence.*;
import java.util.Arrays;


@Entity
@Table(name = "Alien")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ad;
    private  String soyad;
    private String email;
    private String actCode;
    private String sifre;
    private boolean valid = false;



    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public long getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getActCode() { return actCode; }

    public void setActCode(String actCode) { this.actCode = actCode; }

    public boolean isValid() { return valid; }

    public void setValid(boolean valid) { this.valid = valid; }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + ad + '\'' +
                ", lastname='" + soyad + '\'' +
                ", email='" + email + '\'' +
                ", actCode='" + actCode + '\'' +
                ", password='" + sifre + '\'' +
                ", valid=" + valid +
                '}';
    }
}
