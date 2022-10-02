package com.github.mybatisplus.ex.query;

public class FieldSort {
    private String key;

    private FieldDirection direction = FieldDirection.ASC;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public FieldDirection getDirection() {
        return direction;
    }

    public void setDirection(FieldDirection direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "FieldSort{" +
                "key='" + key + '\'' +
                ", direction=" + direction +
                '}';
    }
}
