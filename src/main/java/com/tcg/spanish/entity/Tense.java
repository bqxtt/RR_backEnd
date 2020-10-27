package com.tcg.spanish.entity;

/**
 * @author tcg
 * @date 2020/10/27
 */
public class Tense {
    public Integer tenseId;
    public Integer tenseTabId;
    public Integer tenseGroupId;
    public String tenseName;

    public Integer getTenseId() {
        return tenseId;
    }

    public void setTenseId(Integer tenseId) {
        this.tenseId = tenseId;
    }

    public Integer getTenseTabId() {
        return tenseTabId;
    }

    public void setTenseTabId(Integer tenseTabId) {
        this.tenseTabId = tenseTabId;
    }

    public Integer getTenseGroupId() {
        return tenseGroupId;
    }

    public void setTenseGroupId(Integer tenseGroupId) {
        this.tenseGroupId = tenseGroupId;
    }

    public String getTenseName() {
        return tenseName;
    }

    public void setTenseName(String tenseName) {
        this.tenseName = tenseName;
    }
}
