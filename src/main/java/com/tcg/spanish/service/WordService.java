package com.tcg.spanish.service;

import com.tcg.spanish.entity.Book;
import com.tcg.spanish.entity.Comment;
import com.tcg.spanish.entity.Word;
import com.tcg.spanish.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tcg
 * @date 2020/10/17
 */
public interface WordService {
    /**
     * 获取所有词典
     *
     * @return
     */
    List<Book> getAllWordsTableName();

    /**
     * 获取所有单词
     *
     * @param wordBookId
     * @return
     */
    List<Word> getWordsByWordBookId(String wordBookId);

    /**
     * 获取用户标记单词id
     *
     * @param userOpenId
     * @return
     */
    List<Integer> getMarkedWordIdsByUserOpenId(String userOpenId);

    /**
     * 获取用户标记单词
     *
     * @param userOpenId
     * @return
     */
    List<Word> getMarkedWordsByUserOpenId(String userOpenId);

    /**
     * 新增标记单词
     *
     * @param wordId
     * @param userOpenId
     * @return
     */
    Integer addMarkedWord(Integer wordId, String userOpenId);

    /**
     * 删除标记单词
     *
     * @param wordId
     * @param userOpenId
     * @return
     */
    Integer deleteMarkedWord(Integer wordId, String userOpenId);

    /**
     * 新增笔记
     *
     * @param comment
     * @return
     */
    Integer addWordComment(Comment comment);

    /**
     * 获取单词笔记
     *
     * @param wordId
     * @return
     */
    List<Comment> getCommentsByWordId(Integer wordId);
}
