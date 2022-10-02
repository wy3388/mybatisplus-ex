package com.github.mybatisplus.ex.query;

public enum QueryCondition {
    EQ("EQ"),
    LT("LT"),
    GT("GT"),
    LE("LE"),
    GE("GE"),
    LIKE("LIKE"),
    LIKE_LEFT("LIKE_LEFT"),
    LIKE_RIGHT("LIKE_RIGHT"),
    ISNULL("ISNULL"),
    NOTNULL("NOTNULL"),
    IN("IN"),
    NOT_IN("NOT_IN"),
    BETWEEN("BETWEEN");

    private final String value;

    QueryCondition(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
