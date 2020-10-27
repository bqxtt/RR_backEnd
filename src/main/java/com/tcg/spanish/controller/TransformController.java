package com.tcg.spanish.controller;

import com.alibaba.fastjson.JSON;
import com.tcg.spanish.entity.*;
import com.tcg.spanish.entity.dto.Tab;
import com.tcg.spanish.entity.dto.Table;
import com.tcg.spanish.service.TransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
        String old = null;
        for (Suffix suffix : suffixes) {
            if ((old = checkSuffix(word, suffix.getSuffixWord())) != null) {
                suffixId = suffix.getSuffixId();
                //System.out.println(suffix.getSuffixWord() + " " + old);
                break;
            }
        }

        List<Tab> tabs = new ArrayList<>();
        if (suffixId == null) {
            return JSON.toJSONString(tabs);
        }
        List<TenseTab> tenseTabs = transformService.getAllTenseTabs();
        for (TenseTab tenseTab : tenseTabs) {
            tabs.add(buildTab(tenseTab, suffixId, old));
        }
        return JSON.toJSONString(tabs);
    }

    private String checkSuffix(String word, String suffix) {
        Integer wordLength = word.length();
        Integer suffixLength = suffix.length();
        if (suffix.startsWith("_")) {
            if (wordLength < suffixLength) {
                return null;
            }
            if (word.endsWith(suffix.substring(1))) {
                return word.substring(0, wordLength - suffixLength + 1);
            } else {
                return null;
            }
        } else {
            if (word.equals(suffix)) {
                return "";
            } else {
                return null;
            }
        }
    }

    private Tab buildTab(TenseTab tenseTab, Integer suffixId, String old) {
        Tab tab = new Tab();
        tab.setTabName(tenseTab.getTenseTabName());
        List<Tense> tenses = transformService.getTensesByTenseTabId(tenseTab.getTenseTabId());
        Map<Integer, List<Tense>> tenseGroup = buildTenseGroup(tenses);
        List<Table> tables = new ArrayList<>();
        for (Map.Entry<Integer, List<Tense>> entry : tenseGroup.entrySet()) {
            Integer groupId = entry.getKey();
            List<Tense> tenseList = entry.getValue();
            List<CommonWord> commonWords = transformService.getCommonWordsByTenseGroupId(groupId);
            tables.add(buildTable(tenseList, commonWords, suffixId, old));
        }
        tab.setTables(tables);
        return tab;
    }

    private Table buildTable(List<Tense> tenses, List<CommonWord> commonWords, Integer suffixId, String old) {
        List<String> columns = new ArrayList<>();
        List<List<String>> rows = new ArrayList<>();
        columns.add("");
        for (CommonWord commonWord : commonWords) {
            List<String> row = new ArrayList<>();
            row.add(commonWord.getCommonWord());
            rows.add(row);
        }
        for (Tense tens : tenses) {
            columns.add(tens.getTenseName());
            for (int i = 0; i < commonWords.size(); ++i) {
                TransformSuffix transSuffix = transformService.getTransformSuffix(tens.getTenseId(), suffixId, commonWords.get(i).getCommonWordId());
                String suffix = transSuffix.getTransSuffix();
                rows.get(i).add(transform(old, suffix));
            }
        }
        Table table = new Table();
        table.setColumns(columns);
        table.setRows(rows);
        return table;
    }

    private String transform(String old, String suffix) {
        return suffix.replace("_", old);
    }

    private Map<Integer, List<Tense>> buildTenseGroup(List<Tense> tenses) {
        Map<Integer, List<Tense>> tenseGroup = new HashMap<>(tenses.size());
        for (Tense tens : tenses) {
            if (tenseGroup.containsKey(tens.getTenseGroupId())) {
                tenseGroup.get(tens.getTenseGroupId()).add(tens);
            } else {
                List<Tense> tmp = new ArrayList<>();
                tmp.add(tens);
                tenseGroup.put(tens.getTenseGroupId(), tmp);
            }
        }
        return tenseGroup;
    }

}
