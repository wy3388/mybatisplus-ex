package com.github.mybatisplus.ex.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.mybatisplus.ex.query.PageList;
import com.github.mybatisplus.ex.query.QueryParams;

import java.util.List;

public interface BaseService<T> extends IService<T> {
    default T getOne(QueryParams queryParams) {
        return getOne(queryParams.toQueryWrapper());
    }

    default List<T> list(QueryParams queryParams) {
        return list(queryParams.toQueryWrapper());
    }

    default PageList<T> page(QueryParams queryParams) {
        IPage<T> iPage = page(new Page<>(queryParams.getPageBean().getPage(), queryParams.getPageBean().getPageSize()), queryParams.toQueryWrapper());
        return new PageList<>(iPage);
    }
}
