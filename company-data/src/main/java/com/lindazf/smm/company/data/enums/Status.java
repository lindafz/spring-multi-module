package com.lindazf.smm.company.data.enums;

public enum Status {
    CREATED("Created"), LOGIN_ENABLED("Login Enabled"), LOCKED("Locked"), ACTIVE("Active"), SUSPENDED("Suspended"), DIABLED("Disabled");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}