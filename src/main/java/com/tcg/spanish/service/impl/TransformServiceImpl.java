package com.tcg.spanish.service.impl;

import com.tcg.spanish.entity.*;
import com.tcg.spanish.mapper.TransformMapper;
import com.tcg.spanish.service.TransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tcg
 * @date 2020/10/27
 */
@Service
public class TransformServiceImpl implements TransformService {

    @Autowired
    TransformMapper transformMapper;

    @Override
    public List<TenseTab> getAllTenseTabs() {
        return transformMapper.getAllTenseTabs();
    }

    @Override
    public List<Tense> getTensesByTenseTabId(Integer tenseTabId) {
        return transformMapper.getTensesByTenseTabId(tenseTabId);
    }

    @Override
    public List<CommonWord> getCommonWordsByTenseGroupId(Integer tenseGroupId) {
        return transformMapper.getCommonWordsByTenseGroupId(tenseGroupId);
    }

    @Override
    public List<TransformSuffix> getTransformSuffix(Integer tenseId, Integer suffixId, Integer commonWordId) {
        return transformMapper.getTransformSuffix(tenseId,suffixId,commonWordId);
    }

    @Override
    public List<Suffix> getAllSuffix() {
        return transformMapper.getAllSuffix();
    }
}
