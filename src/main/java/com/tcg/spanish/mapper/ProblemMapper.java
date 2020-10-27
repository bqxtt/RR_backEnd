package com.tcg.spanish.mapper;

import com.tcg.spanish.entity.Answer;
import com.tcg.spanish.entity.Problem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2020/10/26
 */

@Mapper
@Component
public interface ProblemMapper {
    /**
     * 获取所有问题
     *
     * @return problems
     */
    @Select("select * from problem")
    List<Problem> getAllProblems();

    /**
     * 获取问题答案
     *
     * @param problemId
     * @return answers
     */
    @Select("select * from answer where problem_id = #{problemId}")
    List<Answer> getAnswersByProblemId(Integer problemId);

    /**
     * 获取历史最高分
     *
     * @param userOpenId
     * @return score
     */
    @Select("select max_score from game_score where user_open_id = #{userOpenId}")
    Integer getMaxScoreByUserOpenId(String userOpenId);

    /**
     * 更新最高分
     *
     * @param userOpenId
     * @param maxScore
     * @return
     */
    @Insert("insert into game_score(user_open_id,max_score) values(#{userOpenId},#{maxScore}) ON DUPLICATE KEY UPDATE max_score = #{maxScore}")
    Integer updateMaxScoreByUserOpenId(String userOpenId, Integer maxScore);
}
