package com.liust.rule;

import com.liust.rule.properties.RuleProperties;
import com.liust.rule.service.RuleService;
import com.liust.rule.util.LoadFlieUtils;

import java.io.FileNotFoundException;
import java.util.Map;

/*
*
* 核心脚本存放的地方
* */
public class RuleCore {

    private  Map<String, RuleService> STRINGMAP;

    private RuleProperties ruleProperties;

    public RuleCore(Map<String, RuleService> STRINGMAP,RuleProperties ruleProperties) {
        this.STRINGMAP=STRINGMAP;
        this.ruleProperties=ruleProperties;
    }

    public void createOrUpdate(String javaCode,  String javaFuliName) throws FileNotFoundException {
        Object o=  LoadFlieUtils.dynamic(javaCode,ruleProperties.getFilePath(),javaFuliName);
        STRINGMAP.put(javaFuliName, (RuleService) o);
    }

    public RuleService getRule(String temName){
        return STRINGMAP.get(temName);
    }

    public RuleService remove(String temName){
        return STRINGMAP.remove(temName);
    }

}
