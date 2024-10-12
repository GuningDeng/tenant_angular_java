package com.deng.tenantapi.domein;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_housing")
public class Housing {
    @Id
    @GeneratedValue
    private Long id;

    private String housNumber;
    private String owner;
    private String idCard;
    public Housing() {
    }
    public Housing(String housNumber, String owner, String idCard) {
        this.housNumber = housNumber;
        this.owner = owner;
        this.idCard = idCard;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getHousNumber() {
        return housNumber;
    }
    public void setHousNumber(String housNumber) {
        this.housNumber = housNumber;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    
    
}
