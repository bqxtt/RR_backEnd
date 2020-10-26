package com.tcg.spanish.service.impl;

import com.tcg.spanish.entity.Answer;
import com.tcg.spanish.entity.Problem;
import com.tcg.spanish.mapper.ProblemMapper;
import com.tcg.spanish.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author tcg
 * @date 2020/10/26
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    ProblemMapper problemMapper;

    @Override
    public List<Problem> getAllProblems() {
        List<Problem> problems = problemMapper.getAllProblems();
        Collections.shuffle(problems);
        for (Problem problem : problems) {
            List<Answer> answers = problemMapper.getAnswersByProblemId(problem.getProblemId());
            Collections.shuffle(answers);
            problem.setAnswers(answers);
        }
        return problems;
    }

    @Override
    public Integer getMaxScoreByUserOpenId(String userOpenId) {
        Integer maxScore = problemMapper.getMaxScoreByUserOpenId(userOpenId);
        return maxScore == null ? 0 : maxScore;
    }

    @Override
    public Integer updateMaxScoreByUserOpenId(String userOpenId, Integer maxScore) {
        return problemMapper.updateMaxScoreByUserOpenId(userOpenId,maxScore);
    }
}
