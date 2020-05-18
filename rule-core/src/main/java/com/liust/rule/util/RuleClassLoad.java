package com.liust.rule.util;

import com.liust.rule.exception.RuleExcetion;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RuleClassLoad extends ClassLoader {

    private String rootPath;

    public RuleClassLoad(String rootPath) {
        this.rootPath = rootPath;
    }

    /**
     * 根据name来寻找该类
     */
    @Override
    protected Class<?> findClass(String name) {
        Class<?> c = findLoadedClass(name);
        if (c == null) { // 内存堆中还没加载该类
            return findRuleClass(name); // 自己实现加载类
        }
        return null;
    }

    /**
     * 加载该类
     *
     * @param name
     * @return
     */
    private Class<?> findRuleClass(String name) {
        byte[] bytes = getData(name);
        return this.defineClass(null, bytes, 0, bytes.length); // 调用父类方法，生成具体类

    }

    private byte[] getData(String className) {
        String path = rootPath + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try (InputStream is = new FileInputStream(path)) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num;
            while ((num = is.read(buffer)) != -1) {
                stream.write(buffer, 0, num);
            }
            return stream.toByteArray();
        } catch (IOException e) {
            throw new RuleExcetion("解析脚本失败！", e);
        }
    }
}
