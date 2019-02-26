package com.zoo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author:Dustyhandhe Date: 2019-02-26
 * Time: 19:45
 */
public class PageResult implements Serializable {
    private long total;

    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
