package com.tcg.spanish.mapper;

import com.tcg.spanish.entity.Book;
import com.tcg.spanish.entity.Comment;
import com.tcg.spanish.entity.Word;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2020/10/17
 */
@Mapper
@Component
public interface WordMapper {

    /**
     * 获取所有词典表名
     *
     * @return
     */
    @Select("select * from word_books")
    List<Book> getAllWordsTableName();

    /**
     * 获取所有单词
     *
     * @param wordBookId
     * @return
     */
    @Select("select * from all_words where word_book_id = #{wordBookId}")
    List<Word> getWordsByWordBookId(String wordBookId);

    /**
     * wordId获取word
     *
     * @param wordId
     * @return
     */
    @Select("select * from all_words where id = #{wordId}")
    Word getWordByWordId(Integer wordId);


    /**
     * 根据一组wordId获取一组word
     *
     * @param wordIds
     * @return
     */
    @Select({
            "<script>"
                    + "select * from all_words where id in"
                    + "<foreach item='item' index='index' collection='wordIds' open='(' separator=',' close=')'>"
                    + "#{item}"
                    + "</foreach>"
                    + "</script>"
    })
    List<Word> getWordsByWordIds(@Param(value = "wordIds") List<Integer> wordIds);

    /**
     * 获取用户标记单词
     *
     * @param userOpenId
     * @return
     */
    @Select("select * from all_words where id in (select word_id from marked_word where user_open_id = #{userOpenId})")
    List<Word> getMarkedWordsByUserOpenId(String userOpenId);

    /**
     * 获取用户标记单词id
     *
     * @param userOpenId
     * @return
     */
    @Select("select word_id from marked_word where user_open_id = #{userOpenId}")
    List<Integer> getMarkedWordIdsByUserOpenId(String userOpenId);

    /**
     * 获取单词笔记
     *
     * @param wordId
     * @return
     */
    @Select("select * from word_comment where word_id = #{wordId} order by id")
    List<Comment> getCommentsByWordId(Integer wordId);

    /**
     * 增加标记单词
     *
     * @param wordId
     * @param userOpenId
     * @return
     */
    @Insert("insert into marked_word(word_id,user_open_id) values(#{wordId},#{userOpenId})")
    Integer addMarkedWord(Integer wordId, String userOpenId);

    /**
     * 新增评论
     *
     * @param comment
     * @return
     */
    @Insert("insert into word_comment(word_id,user_open_id,user_nickname,user_avatar_url,comment,create_time) " +
            "values(#{wordId},#{userOpenId},#{userNickname},#{userAvatarUrl},#{comment},#{createTime})")
    Integer addWordComment(Comment comment);

    /**
     * 删除标记单词
     *
     * @param wordId
     * @param userOpenId
     * @return
     */
    @Delete("delete from marked_word where word_id = #{wordId} and user_open_id = #{userOpenId}")
    Integer deleteMarkedWord(Integer wordId, String userOpenId);
}
