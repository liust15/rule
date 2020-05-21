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

    public void createOrUpdate(String javaCode,  String javaFullName) throws FileNotFoundException {
        Object o=  LoadFlieUtils.dynamic(javaCode,ruleProperties.getFilePath(),javaFullName);
        STRINGMAP.put(javaFullName, (RuleService) o);
    }

    public RuleService getRule(String javaFullName){
        return STRINGMAP.get(javaFullName);
    }

    public RuleService remove(String javaFullName){
        return STRINGMAP.remove(javaFullName);
    }

}
