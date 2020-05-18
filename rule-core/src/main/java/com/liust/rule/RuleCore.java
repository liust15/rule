package com.liust.rule;

import com.liust.rule.service.RuleService;
import com.liust.rule.util.LoadFlieUtils;

import java.util.Map;

/*
*
* 核心脚本存放的地方
* */
public class RuleCore {

    private  Map<String, RuleService> STRINGMAP;

    public RuleCore(Map<String, RuleService> STRINGMAP) {
        this.STRINGMAP=STRINGMAP;
    }

    public void createOrUpdate(String javaCode, String filePath, String javaFuliName){
        LoadFlieUtils.dynamic(javaCode,filePath,javaFuliName);
    }

    public RuleService getRule(String temName){
        return STRINGMAP.get(temName);
    }

    public RuleService remove(String temName){
        return STRINGMAP.remove(temName);
    }

}
