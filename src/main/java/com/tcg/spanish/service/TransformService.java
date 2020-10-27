package com.tcg.spanish.service;

import com.tcg.spanish.entity.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author tcg
 * @date 2020/10/27
 */
public interface TransformService {

    /**
     * 获取时态标签
     *
     * @return
     */
    List<TenseTab> getAllTenseTabs();

    /**
     * 获取tense
     *
     * @param tenseTabId
     * @return
     */
    List<Tense> getTensesByTenseTabId(Integer tenseTabId);

    /**
     * 获取tense group common word
     *
     * @param tenseGroupId
     * @return
     */
    List<CommonWord> getCommonWordsByTenseGroupId(Integer tenseGroupId);

    /**
     * 获取变换后缀
     *
     * @param tenseId
     * @param suffixId
     * @param commonWordId
     * @return
     */
    TransformSuffix getTransformSuffix(Integer tenseId, Integer suffixId, Integer commonWordId);

    /**
     * 获取所有后缀
     *
     * @return
     */
    List<Suffix> getAllSuffix();
}
