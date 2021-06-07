package com.lindazf.smm.company.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class Auditable {

    @CreatedBy
    @JsonIgnore
    protected Long createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    protected Date createdDate;

    @LastModifiedBy
    @JsonIgnore
    protected Long lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    protected Date lastModifiedDate;

    public Auditable(Long createdBy) {
        this.createdBy = createdBy;
        this.lastModifiedBy = createdBy;
        this.createdDate = new Date();
        this.lastModifiedDate = new Date();
    }

    public void updateAuditable(Long lastModifiedBy) {
        this.setLastModifiedBy(lastModifiedBy);
        this.setLastModifiedDate(new Date());
    }
}
