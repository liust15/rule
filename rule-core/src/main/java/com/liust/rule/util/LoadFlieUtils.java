package com.liust.rule.util;

import com.liust.rule.exception.RuleExcetion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class LoadFlieUtils {

    private final static String JAVA_EXC=".java";
    //public static final String javaCode = "package classload;public class HelloWorld2 {public HelloWorld2() {System.out.println(\"Hello World\");}}";
    public static Object dynamic(String javaCode, String filePath,String javaFuliName) {
        // 把 java String 存储到文件
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        try (FileWriter fw = new FileWriter(new File(filePath+javaFuliName.replace(".","/")+ JAVA_EXC));
             StandardJavaFileManager standardFileManager = javaCompiler.getStandardFileManager(null, null, null)) {
            fw.write(javaCode);
            fw.flush();
            fw.close();

            Iterable<? extends JavaFileObject> iterable = standardFileManager.getJavaFileObjects(filePath);

            // 执行编译任务
            CompilationTask task = javaCompiler.getTask(null, standardFileManager, null, null, null, iterable);
            task.call();
            standardFileManager.close();

            // 把编译后的 class 文件加载到内存
            Class c = new RuleClassLoad(filePath).loadClass(javaFuliName);
            return c.newInstance();
        }  catch (IOException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            throw new RuleExcetion("加载文件失败！",e);
        }
    }


}
