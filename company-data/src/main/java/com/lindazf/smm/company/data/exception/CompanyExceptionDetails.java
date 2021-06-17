package com.lindazf.smm.company.data.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompanyExceptionDetails extends CompanyException {
    private String type;

    public CompanyExceptionDetails(String message, String type) {
        super(message);
        this.type = type;
    }
}
