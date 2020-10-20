package com.tcg.spanish.entity;

/**
 * @author tcg
 * @date 2020/10/17
 */
public class Word {

    public Integer id;
    public String word;
    public String categoria;
    public String chinese;
    public String english;
    public String wordBookId;
    public boolean isMarked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getWordBookId() {
        return wordBookId;
    }

    public void setWordBookId(String wordBookId) {
        this.wordBookId = wordBookId;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }
}
