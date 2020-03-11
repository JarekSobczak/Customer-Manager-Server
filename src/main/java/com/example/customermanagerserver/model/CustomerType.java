package com.example.customermanagerserver.model;

public enum CustomerType {
    Standard(0),
    Premium(1),
    VIP(2);
    private int value;

    CustomerType(int i) {
        value = i;
    }

    public int getValue() {
        return value;
    }
}
