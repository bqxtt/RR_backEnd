package com.tcg.spanish.controller;

import com.alibaba.fastjson.JSON;
import com.tcg.spanish.entity.Suffix;
import com.tcg.spanish.entity.TenseTab;
import com.tcg.spanish.entity.dto.Tab;
import com.tcg.spanish.entity.dto.Table;
import com.tcg.spanish.service.TransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tcg
 * @date 2020/10/27
 */
@RestController
@RequestMapping("/transform")
public class TransformController {
    @Autowired
    TransformService transformService;

    @PostMapping("/getResult")
    public String getResult(String word) {
        List<Suffix> suffixes = transformService.getAllSuffix();
        Collections.sort(suffixes);
        Integer suffixId = null;
        for (Suffix suffix : suffixes) {
            if(checkSuffix(word,suffix.getSuffixWord())) {
                suffixId = suffix.getSuffixId();
                break;
            }
        }
        List<Tab> tabs = new ArrayList<>();
        if(suffixId == null) {
            return JSON.toJSONString(tabs);
        }
        List<TenseTab> tenseTabs = transformService.getAllTenseTabs();
        for (TenseTab tenseTab : tenseTabs) {
            Tab tab = new Tab();
            tab.setTabName(tenseTab.getTenseTabName());
            List<Table> tables = new ArrayList<>();

        }
        return JSON.toJSONString(suffixes);
    }

    private boolean checkSuffix(String word,String suffix){
        if(suffix.startsWith("_")) {
            if(word.length() < suffix.length()) {
                return false;
            }
            return word.endsWith(suffix.substring(1));
        } else {
            return word.equals(suffix);
        }
    }
}
