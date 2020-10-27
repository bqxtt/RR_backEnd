package com.tcg.spanish.entity;

import org.jetbrains.annotations.NotNull;

/**
 * @author tcg
 * @date 2020/10/27
 */
public class Suffix implements Comparable {
    public Integer suffixId;
    public String suffixWord;

    public Integer getSuffixId() {
        return suffixId;
    }

    public void setSuffixId(Integer suffixId) {
        this.suffixId = suffixId;
    }

    public String getSuffixWord() {
        return suffixWord;
    }

    public void setSuffixWord(String suffixWord) {
        this.suffixWord = suffixWord;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        if(o instanceof Suffix) {
            Suffix s = (Suffix) o;
            if(this.suffixWord.length() < s.suffixWord.length()) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}
