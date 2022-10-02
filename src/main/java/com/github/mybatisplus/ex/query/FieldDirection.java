package com.github.mybatisplus.ex.query;

public enum FieldDirection {

    ASC("ASC"),
    DESC("DESC");

    private final String value;

    FieldDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
