package com.lindazf.smm.company.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StringResponse {
    @JsonProperty("response")
    private final String response;

    public StringResponse(String response) {
        super();
        this.response = response;
    }
}