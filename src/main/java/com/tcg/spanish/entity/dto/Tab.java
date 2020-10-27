package com.tcg.spanish.entity.dto;

import java.util.List;

/**
 * @author tcg
 * @date 2020/10/27
 */
public class Tab {
    public String tabName;
    public List<Table> tables;

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
