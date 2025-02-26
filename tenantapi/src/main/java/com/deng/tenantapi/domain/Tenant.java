package com.deng.tenantapi.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_tenant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "idCard")
    private String idCard;

    @Column(name = "mobile")
    private String mobile;

    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "rentDateTime")
    private LocalDateTime rentDateTime;

    // @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToOne
    @JoinColumn(name = "housing_id", referencedColumnName = "id") // Foreign key column
    private Housing housing;

    
}
