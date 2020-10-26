package com.tcg.spanish.controller;

import com.alibaba.fastjson.JSON;
import com.sun.tracing.Probe;
import com.tcg.spanish.entity.Problem;
import com.tcg.spanish.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tcg
 * @date 2020/10/26
 */
@RestController
@RequestMapping("/problems")
public class ProblemController {
    @Autowired
    ProblemService problemService;

    @GetMapping("/getAllProblems")
    public String getAllProblems() {
        List<Problem> problems = problemService.getAllProblems();
        return JSON.toJSONString(problems);
    }

    @PostMapping("/getScore")
    public String getScore(String userOpenId) {
        return JSON.toJSONString(problemService.getMaxScoreByUserOpenId(userOpenId));
    }

    @PostMapping("updateScore")
    public void updateScore(String userOpenId,Integer score) {
        Integer old = problemService.getMaxScoreByUserOpenId(userOpenId);
        if(score > old) {
            problemService.updateMaxScoreByUserOpenId(userOpenId,score);
        }
    }
}
