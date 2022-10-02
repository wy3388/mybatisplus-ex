package com.github.mybatisplus.ex.query;

public class QueryField {
    private String key;

    private Object value;

    private QueryCondition condition = QueryCondition.EQ;

    private FieldRelation relation = FieldRelation.AND;

    private String group = "main";

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public QueryCondition getCondition() {
        return condition;
    }

    public void setCondition(QueryCondition condition) {
        this.condition = condition;
    }

    public FieldRelation getRelation() {
        return relation;
    }

    public void setRelation(FieldRelation relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "QueryField{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", condition=" + condition +
                ", relation=" + relation +
                ", group='" + group + '\'' +
                '}';
    }
}
