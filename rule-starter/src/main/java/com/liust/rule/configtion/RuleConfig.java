package com.liust.rule.configtion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

import lombok.Data;

@Data
@ConfigurationProperties("example.service")
public class RuleConfig {

    private String dataId;

    private String versionId;

    private String other;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) throws FileNotFoundException {
        ResourceUtils.getFile("classpath:template");
        this.dataId = dataId;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
