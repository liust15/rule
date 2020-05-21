package com.liust.rule;

import com.liust.rule.service.RuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RuleApplication {


    public static void main(String[] args) {
        SpringApplication.run(RuleApplication.class, args);
    }

    @Autowired
    private RuleCore ruleCore;

    @PostConstruct
    public void test() throws FileNotFoundException {
        String javaFullName = "com.liust.RuleServiceTest";
        String javaCode = "import com.liust.rule.service.RuleService;\n" +
				"\n" +
				"public class RuleServiceTest<T> extends RuleService<T> {\n" +
				"    @Override\n" +
				"    public T run(Object object) {\n" +
				"        System.out.println(object);\n" +
				"        return (T) object;\n" +
				"    }\n" +
				"}\n";
        ruleCore.createOrUpdate(javaCode, javaFullName);
        RuleService rule = ruleCore.getRule(javaFullName);
        rule.run("测试 我是1");
    }
}
