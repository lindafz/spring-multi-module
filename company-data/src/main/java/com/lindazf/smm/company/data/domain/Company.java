package com.lindazf.smm.company.data.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.lindazf.smm.company.data.enums.Status;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
public class Company extends Auditable implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "owner_key", nullable = false, unique = true)
    private String ownerKey;

    @Column(name = "company_name", nullable = false, unique = true)
    private String companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "company_note", columnDefinition = "text")
    private String companyNote;

    @Column(name = "company_status", columnDefinition = "VARCHAR(60)")
    private String companyStatus;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(60)")
    private String phoneNumber;

    @Column(name = "country_name", columnDefinition = "VARCHAR(60)")
    private String countryName;

    @Column(name = "city")
    private String city;

    @Column(name = "state_name", columnDefinition = "VARCHAR(60)")
    private String stateName;

    @Column(name = "postal_code", columnDefinition = "VARCHAR(60)")
    private String postalCode;

    @Column(name = "industry_name")
    private String industryName;

    @Column(name = "employee_number", columnDefinition = "INT")
    private Integer employeeNumber;

    @Column(name = "status", columnDefinition = "VARCHAR(60)")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CompanyUser> companyMembers = new HashSet<>();

}
