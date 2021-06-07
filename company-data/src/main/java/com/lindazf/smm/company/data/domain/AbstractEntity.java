package com.lindazf.smm.company.data.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class AbstractEntity implements  Serializable{
    private static final long serialVersionUID = 3237123637790006295L;
}

