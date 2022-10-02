package com.github.mybatisplus.ex.query;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public class PageList<T> {

    private Long page;

    private Long pageSize;

    private List<T> rows;

    private Long total;

    public PageList() {
    }

    public PageList(IPage<T> iPage) {
        this.page = iPage.getCurrent();
        this.pageSize = iPage.getPages();
        this.total = iPage.getTotal();
        this.rows = iPage.getRecords();
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageList{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", rows=" + rows +
                ", total=" + total +
                '}';
    }
}
