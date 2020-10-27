package com.tcg.spanish.entity.dto;

import java.util.List;

/**
 * @author tcg
 * @date 2020/10/27
 */
public class Table {
    public List<String> columns;
    public List<List<String>> rows;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }
}
