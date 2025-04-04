package com.deng.tenantapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_housing")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Housing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
    @Column(name = "id")
    private Long id;

    @Column(name = "housNumber")
    private String housNumber;
    @Column(name = "owner")
    private String owner;
    @Column(name = "idCard")
    private String idCard;
    private Long tenantId;
        
}
