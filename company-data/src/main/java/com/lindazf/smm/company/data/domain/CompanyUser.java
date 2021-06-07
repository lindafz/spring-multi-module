package com.lindazf.smm.company.data.domain;

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
@Getter
@Setter
@NoArgsConstructor
public class  CompanyUser extends Auditable {

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

    @Column(name = "email_encrypted", nullable = false, unique = true)
    private String emailEncrypted;

    @Column(name = "email_hashed", nullable = false, unique = true)
    private String emailHashed;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "token", column = @Column(name = "activation_token")),
            @AttributeOverride(name = "expiredAt", column = @Column(name = "activation_token_expired_at")),
            @AttributeOverride(name = "resent", column = @Column(name = "activation_resent"))
    })

    @Column(name = "phone_number", columnDefinition = "VARCHAR(60)")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "password_status", columnDefinition = "VARCHAR(100)")
    private String passwordStatus;

    @Column(name = "failed_password_attempts", columnDefinition = "TINYINT")
    private Integer failedPasswordAttempts;

    public CompanyUser(Long createdBy)
    {
        super(createdBy);
    }
}

