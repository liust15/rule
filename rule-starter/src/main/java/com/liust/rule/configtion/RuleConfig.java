package com.liust.rule.configtion;

import com.liust.rule.properties.RuleProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;

@ConfigurationProperties("example.service")
public class RuleConfig implements RuleProperties {

    @Value("filePath")
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getFilePath() throws FileNotFoundException {
        if(StringUtils.isEmpty(filePath)){
            File file = ResourceUtils.getFile("classpath:template");
            filePath=file.getPath();
        }
        return filePath;
    }
}
