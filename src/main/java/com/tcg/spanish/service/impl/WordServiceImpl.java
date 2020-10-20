package com.tcg.spanish.service.impl;

import com.tcg.spanish.entity.Book;
import com.tcg.spanish.entity.Comment;
import com.tcg.spanish.entity.Word;
import com.tcg.spanish.mapper.WordMapper;
import com.tcg.spanish.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tcg
 * @date 2020/10/17
 */
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    WordMapper wordMapper;

    @Override
    public List<Word> getWordsByWordBookId(String wordBookId) {
        return wordMapper.getWordsByWordBookId(wordBookId);
    }

    @Override
    public List<Integer> getMarkedWordIdsByUserOpenId(String userOpenId) {
        return wordMapper.getMarkedWordIdsByUserOpenId(userOpenId);
    }

    @Override
    public List<Word> getMarkedWordsByUserOpenId(String userOpenId) {
        List<Word> words = wordMapper.getMarkedWordsByUserOpenId(userOpenId);
        for (Word word : words) {
            word.setMarked(true);
        }
        return words;
    }

    @Override
    public List<Book> getAllWordsTableName() {
        return wordMapper.getAllWordsTableName();
    }

    @Override
    public Integer addMarkedWord(Integer wordId, String userOpenId) {
        return wordMapper.addMarkedWord(wordId,userOpenId);
    }

    @Override
    public Integer addWordComment(Comment comment) {
        return wordMapper.addWordComment(comment);
    }

    @Override
    public Integer deleteMarkedWord(Integer wordId, String userOpenId) {
        return wordMapper.deleteMarkedWord(wordId,userOpenId);
    }

    @Override
    public List<Comment> getCommentsByWordId(Integer wordId) {
        return wordMapper.getCommentsByWordId(wordId);
    }
}
