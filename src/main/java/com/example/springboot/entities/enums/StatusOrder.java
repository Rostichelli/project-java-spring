package com.example.springboot.entities.enums;

public enum StatusOrder {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private StatusOrder(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static StatusOrder valueOf(int code) {
        for (StatusOrder value : StatusOrder.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid StatusOrder code");
    }
}
