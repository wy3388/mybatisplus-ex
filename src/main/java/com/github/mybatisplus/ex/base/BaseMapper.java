package com.github.mybatisplus.ex.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.mybatisplus.ex.query.QueryParams;

import java.util.List;

public interface BaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {

    default List<T> selectList(QueryParams queryParams) {
        return selectList(queryParams.toQueryWrapper());
    }

    default IPage<T> selectPage(QueryParams queryParams) {
        return selectPage(queryParams.getIPage(), queryParams.toQueryWrapper());
    }
}
