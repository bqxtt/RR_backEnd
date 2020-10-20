package com.tcg.spanish.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.tcg.spanish.entity.Book;
import com.tcg.spanish.entity.Comment;
import com.tcg.spanish.entity.Word;
import com.tcg.spanish.service.WordService;
import okhttp3.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.logging.log4j.util.Strings;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author tcg
 * @date 2020/10/17
 */
@RestController
@RequestMapping("/words")
public class WordController {

    @Autowired
    WordService wordService;

    private final String URL = "https://api.weixin.qq.com/sns/jscode2session?appid=";
    private final String APP_ID = "wxe12fe34c0c926447";
    private final String APP_SECRET = "7762dee5b68eb4806367f4364758c8fa";

    @GetMapping("/getUserOpenId/{userCode}")
    public String getUserOpenId(@PathVariable("userCode") String userCode) {
        String url = URL + APP_ID + "&secret=" + APP_SECRET + "&js_code=" + userCode + "&grant_type=authorization_code";
        String res = null;
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                res = JSON.parseObject(Objects.requireNonNull(response.body()).string()).getString("openid");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @GetMapping("/getAllWordsBookName")
    public String getAllWordsBookName() {
        List<Book> names = wordService.getAllWordsTableName();
        return JSON.toJSONString(names);
    }

    @PostMapping("/getWords")
    public String getWords(String wordBookId, String userOpenId) {
        List<Word> words = wordService.getWordsByWordBookId(wordBookId);
        if (!Strings.isBlank(userOpenId)) {
            List<Integer> wordIds = wordService.getMarkedWordIdsByUserOpenId(userOpenId);
            for (Word word : words) {
                if (wordIds.contains(word.getId())) {
                    word.setMarked(true);
                }
            }
        }
        return JSON.toJSONString(words);
    }

    @PostMapping("/addMark")
    public String addMarkedWord(Integer wordId, String userOpenId) {
        Integer result = wordService.addMarkedWord(wordId, userOpenId);
        if (result.equals(1)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @DeleteMapping("/deleteMark")
    public String deleteMarkedWord(Integer wordId, String userOpenId) {
        Integer result = wordService.deleteMarkedWord(wordId, userOpenId);
        if (result.equals(1)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping("/getMarkedWords")
    public String getMarkedWords(String userOpenId) {
        List<Word> words = wordService.getMarkedWordsByUserOpenId(userOpenId);
        return JSON.toJSONString(words);
    }

    @PostMapping("/addComment")
    public String addComment(Integer wordId, String userOpenId, String userNickname, String userAvatarUrl, String comment) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = formatter.format(currentTime);
        Comment comment1 = new Comment(wordId, userOpenId, userNickname, userAvatarUrl, comment, createTime);
        Integer result = wordService.addWordComment(comment1);
        if (result.equals(1)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @GetMapping("/getComments/{wordId}")
    public String getComments(@PathVariable("wordId") Integer wordId) {
        return JSON.toJSONString(wordService.getCommentsByWordId(wordId));
    }
}
