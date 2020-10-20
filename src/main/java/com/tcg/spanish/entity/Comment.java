package com.tcg.spanish.entity;

/**
 * @author tcg
 * @date 2020/10/19
 */
public class Comment {
    public Integer id;
    public Integer wordId;
    public String userOpenId;
    public String userNickname;
    public String userAvatarUrl;
    public String comment;
    public String createTime;

    public Comment(Integer wordId, String userOpenId, String userNickname, String userAvatarUrl, String comment, String createTime) {
        this.wordId = wordId;
        this.userOpenId = userOpenId;
        this.userNickname = userNickname;
        this.userAvatarUrl = userAvatarUrl;
        this.comment = comment;
        this.createTime = createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
