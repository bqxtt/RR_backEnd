package com.tcg.spanish.entity;

/**
 * @author tcg
 * @date 2020/10/27
 */
public class TransformSuffix {
    public Integer commonWordId;
    public Integer suffixId;
    public Integer tenseId;
    public Integer transSuffix;

    public Integer getCommonWordId() {
        return commonWordId;
    }

    public void setCommonWordId(Integer commonWordId) {
        this.commonWordId = commonWordId;
    }

    public Integer getSuffixId() {
        return suffixId;
    }

    public void setSuffixId(Integer suffixId) {
        this.suffixId = suffixId;
    }

    public Integer getTenseId() {
        return tenseId;
    }

    public void setTenseId(Integer tenseId) {
        this.tenseId = tenseId;
    }

    public Integer getTransSuffix() {
        return transSuffix;
    }

    public void setTransSuffix(Integer transSuffix) {
        this.transSuffix = transSuffix;
    }
}
