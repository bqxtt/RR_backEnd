package com.tcg.spanish.service;

import com.tcg.spanish.entity.Problem;

import java.util.List;

/**
 * @author tcg
 * @date 2020/10/26
 */
public interface ProblemService {

    /**
     * 获取所有问题，并作好乱序
     *
     * @return
     */
    List<Problem> getAllProblems();

    /**
     * 获取历史最高分
     *
     * @param userOpenId
     * @return
     */
    Integer getMaxScoreByUserOpenId(String userOpenId);

    /**
     * 更新最高分
     *
     * @param userOpenId
     * @param maxScore
     * @return
     */
    Integer updateMaxScoreByUserOpenId(String userOpenId, Integer maxScore);
}
