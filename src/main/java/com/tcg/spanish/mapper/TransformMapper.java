package com.tcg.spanish.mapper;

import com.tcg.spanish.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tcg
 * @date 2020/10/27
 */
@Mapper
@Component
public interface TransformMapper {
    /**
     * 获取时态标签
     *
     * @return
     */
    @Select("select * from tense_tab")
    List<TenseTab> getAllTenseTabs();

    /**
     * 获取tense
     *
     * @param tenseTabId
     * @return
     */
    @Select("select * from tense where tense_tab_id = #{tenseTabId}")
    List<Tense> getTensesByTenseTabId(Integer tenseTabId);

    /**
     * 获取tense group common word
     *
     * @param tenseGroupId
     * @return
     */
    @Select("select * from common_word where common_word_id in " +
            "(select common_word_id from tense_group_common where tense_group_id = #{tenseGroupId})")
    List<CommonWord> getCommonWordsByTenseGroupId(Integer tenseGroupId);

    /**
     * 获取变换后缀
     *
     * @param tenseId
     * @param suffixId
     * @param commonWordId
     * @return
     */
    @Select("select * from transform_suffix where common_word_id = #{commonWordId} and suffix_id = #{suffixId} and tense_id = #{tenseId}")
    List<TransformSuffix> getTransformSuffix(Integer tenseId, Integer suffixId, Integer commonWordId);

    /**
     * 获取所有后缀
     *
     * @return
     */
    @Select("select * from suffix")
    List<Suffix> getAllSuffix();
}
