package com.lindazf.smm.company.data.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company_member")
@Data
@NoArgsConstructor
public class  CompanyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_member_id")
    private Long companyMemberId;

    @Column(name = "first_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String lastName;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(60)")
    private String phoneNumber;


}

