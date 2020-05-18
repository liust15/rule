package com.liust.rule;

import com.liust.rule.configtion.RuleConfig;
import com.liust.rule.service.RuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
*
* 核心脚本存放的地方
* */
@Configuration
@EnableConfigurationProperties(RuleConfig.class)
public class RuleAutoConfigtion {
    private final static Map<String, RuleService> STRING_MAP =new ConcurrentHashMap<>();
    @Autowired
    private RuleConfig ruleConfig;

    @Bean
    public RuleCore ruleCore() {
        return new RuleCore(STRING_MAP,ruleConfig);
    }


}
