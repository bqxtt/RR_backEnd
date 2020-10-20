package com.tcg.spanish.entity;

/**
 * @author tcg
 * @date 2020/10/17
 */
public class Book {
    public Integer id;
    public String wordBookId;
    public String wordBookName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWordBookId() {
        return wordBookId;
    }

    public void setWordBookId(String wordBookId) {
        this.wordBookId = wordBookId;
    }

    public String getWordBookName() {
        return wordBookName;
    }

    public void setWordBookName(String wordBookName) {
        this.wordBookName = wordBookName;
    }
}
