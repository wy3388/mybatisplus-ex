package com.github.mybatisplus.ex.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.*;
import java.util.stream.Collectors;

public class QueryParams {
    private List<QueryField> query = new ArrayList<>();

    private List<FieldSort> sort = new ArrayList<>();

    private PageBean pageBean = new PageBean();

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public QueryParams addQuery(String key, String value) {
        return addQuery(key, value, QueryCondition.EQ);
    }

    public  <T> IPage<T> getIPage() {
        return this.getPageBean().getIPage();
    }

    public QueryParams addQuery(String key, String value, QueryCondition condition) {
        return addQuery(key, value, condition, FieldRelation.AND);
    }

    public QueryParams addQuery(String key, String value, QueryCondition condition, FieldRelation relation) {
        QueryField queryField = new QueryField();
        queryField.setKey(key);
        queryField.setValue(value);
        queryField.setCondition(condition);
        queryField.setRelation(relation);
        query.add(queryField);
        return this;
    }

    public QueryParams addSort(String key) {
        return addSort(key, FieldDirection.ASC);
    }

    public QueryParams addSort(String key, FieldDirection direction) {
        FieldSort fieldSort = new FieldSort();
        fieldSort.setKey(key);
        fieldSort.setDirection(direction);
        sort.add(fieldSort);
        return this;
    }

    public <T> QueryWrapper<T> toQueryWrapper() {
        return convertQueryField();
    }

    private <T> QueryWrapper<T> convertQueryField() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        Map<String, List<QueryField>> group = getGroup();
        Set<String> keySet = group.keySet();
        keySet.forEach(s -> {
            if (s.equals("main")) {
                convertQueryField(queryWrapper, group.get(s));
            } else {
                queryWrapper.nested(wrapper -> convertQueryField(wrapper, group.get(s)));
            }
        });
        sort.forEach(fieldSort -> {
            if (fieldSort.getDirection().equals(FieldDirection.ASC)) {
                queryWrapper.orderByAsc(fieldSort.getKey());
            }
            if (fieldSort.getDirection().equals(FieldDirection.DESC)) {
                queryWrapper.orderByDesc(fieldSort.getKey());
            }
        });
        return queryWrapper;
    }

    private <T> void convertQueryField(QueryWrapper<T> queryWrapper, List<QueryField> queryFieldList) {
        queryFieldList.forEach(queryField -> {
            switch (queryField.getCondition()) {
                case EQ:
                    queryWrapper.eq(queryField.getKey(), queryField.getValue());
                    break;
                case LT:
                    queryWrapper.lt(queryField.getKey(), queryField.getValue());
                    break;
                case GT:
                    queryWrapper.gt(queryField.getKey(), queryField.getValue());
                    break;
                case LE:
                    queryWrapper.le(queryField.getKey(), queryField.getValue());
                    break;
                case GE:
                    queryWrapper.ge(queryField.getKey(), queryField.getValue());
                    break;
                case LIKE:
                    queryWrapper.like(queryField.getKey(), queryField.getValue());
                    break;
                case LIKE_LEFT:
                    queryWrapper.likeLeft(queryField.getKey(), queryField.getValue());
                    break;
                case LIKE_RIGHT:
                    queryWrapper.likeRight(queryField.getKey(), queryField.getValue());
                    break;
                case ISNULL:
                    queryWrapper.isNull(queryField.getKey());
                    break;
                case NOTNULL:
                    queryWrapper.isNotNull(queryField.getKey());
                    break;
                case IN:
                    queryWrapper.in(queryField.getKey(), queryField.getValue());
                    break;
                case NOT_IN:
                    queryWrapper.notIn(queryField.getKey(), queryField.getValue());
                    break;
                case BETWEEN:
                    Object[] objects = (Object[]) queryField.getValue();
                    if (objects.length == 2) {
                        queryWrapper.between(queryField.getKey(), objects[0], objects[1]);
                    }
                    break;
            }
            if (queryField.getRelation().equals(FieldRelation.OR)) {
                queryWrapper.or();
            }
        });
    }

    public Map<String, List<QueryField>> getGroup() {
        Set<String> group = query.stream().map(QueryField::getGroup).collect(Collectors.toSet());
        Map<String, List<QueryField>> listMap = new HashMap<>();
        group.forEach(s -> {
            List<QueryField> fieldList = query.stream().filter(queryField -> queryField.getGroup().equals(s)).collect(Collectors.toList());
            listMap.put(s, fieldList);
        });
        return listMap;
    }

    public List<QueryField> getQuery() {
        return query;
    }

    public void setQuery(List<QueryField> query) {
        this.query = query;
    }

    public List<FieldSort> getSort() {
        return sort;
    }

    public void setSort(List<FieldSort> sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Query{" +
                "query=" + query +
                ", sort=" + sort +
                '}';
    }
}
