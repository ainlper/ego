package com.ego.commons.pojo;

import java.util.List;

/**
 * 数据模板
 */
public class EasyUIDatagrid {
    private List<? extends Object> rows;
    private long total;


    public EasyUIDatagrid() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<? extends Object> getRows() {
        return rows;
    }

    public void setRows(List<? extends Object> rows) {
        this.rows = rows;
    }

    public EasyUIDatagrid(List<? extends Object> rows, long total) {
        this.rows = rows;
        this.total = total;
    }
}
