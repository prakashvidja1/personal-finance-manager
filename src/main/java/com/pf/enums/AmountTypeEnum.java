package com.pf.enums;

import com.pf.enums.AmountType;

public enum AmountTypeEnum implements AmountType {

    I("Income"),
    E("Expense");

    private final String text;

    AmountTypeEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static String getName(String type) {
        return switch (type) {
            case "I" -> AmountTypeEnum.I.name();
            case "E" -> AmountTypeEnum.E.name();
            default -> throw new IllegalArgumentException("Unexpected token: " + type);
        };
    }

    public static String getText(String type) {
        return switch (type) {
            case "I" -> AmountTypeEnum.I.getText();
            case "E" -> AmountTypeEnum.E.getText();
            default -> throw new IllegalArgumentException("Unexpected token: " + type);
        };
    }

    public static AmountTypeEnum fromName(String name) {
        for (AmountTypeEnum a : AmountTypeEnum.values()) {
            if (a.name().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }

    public static AmountTypeEnum fromText(String text) {
        for (AmountTypeEnum a : AmountTypeEnum.values()) {
            if (a.text.equalsIgnoreCase(text)) {
                return a;
            }
        }
        return null;
    }
}
