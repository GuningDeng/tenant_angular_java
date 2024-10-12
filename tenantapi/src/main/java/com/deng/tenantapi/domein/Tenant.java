package com.deng.tenantapi.domein;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_tenant")
public class Tenant {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    private String idCard;

    private String mobile;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime rentDateTime;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Housing housing;

    public Tenant() {
    }

    public Tenant(String idCard, String mobile, LocalDateTime rentDateTime, Housing housing) {
        this.idCard = idCard;
        this.mobile = mobile;
        this.rentDateTime = rentDateTime;
        this.housing = housing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDateTime getRentDateTime() {
        return rentDateTime;
    }

    public void setRentDateTime(LocalDateTime rentDateTime) {
        this.rentDateTime = rentDateTime;
    }

    public Housing getHousing() {
        return housing;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
    }

    
    
}
