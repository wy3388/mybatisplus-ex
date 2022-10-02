package com.github.mybatisplus.ex.query;

public enum FieldRelation {
    AND("AND"),
    OR("OR");

    private final String value;

    FieldRelation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
