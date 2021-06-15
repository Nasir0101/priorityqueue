package com.example.priorityqueue.DbModel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visainformation")
public class VisaInformation {

    @Id
    @Column(name = "cnic")
    private String cnic;

    @Column(name = "name")
    private String username;


    @Column(name = "status")
    private String status;

    @Column(name = "Country")
    private String country;

    public VisaInformation() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
