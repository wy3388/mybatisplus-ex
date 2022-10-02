package com.github.mybatisplus.ex.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageBean {
    private Integer page = 1;

    private Integer pageSize = 20;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public <T> IPage<T> getIPage() {
        return new Page<>(this.page, this.pageSize);
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
