package com.liust.rule.configtion;

import com.liust.rule.properties.RuleProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;

@ConfigurationProperties(prefix = "rule.file",ignoreInvalidFields = true)
public class RuleConfig implements RuleProperties {

    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getFilePath() throws FileNotFoundException {
        if(StringUtils.isEmpty(filePath)){
            filePath= ResourceUtils.getFile("classpath:").getPath();
        }
        return filePath;
    }
}
