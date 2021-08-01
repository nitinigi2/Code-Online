package com.codeonline.service;

import com.codeonline.service.java.CompileService;
import com.codeonline.service.java.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ExecuteJavaCode {

    @Autowired
    private CompileService compileService;

    @Autowired
    private RunService runService;

    public String execute(String data) {
        String filePath = getFilePath();
        String classPath = getClassPath();
        String fileName = "Main";

        System.out.println("filePath:::::::::::: " + filePath);
        System.out.println("classPath::::::::::: " + classPath);

        FileWritingService.write(filePath, data);

        String output = "No Output";
        try {
            output = compileService.compile(filePath);

            if(!output.isEmpty()) {
                return output;
            }
            output = runService.run(fileName, classPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(output);

        return output;
    }

    public String getFilePath(){
        String rootPathForTheProject = System.getProperty("user.dir");
        String fileName = "Main.java";
        String fileDir = rootPathForTheProject + "\\CompiledAndRunnapleCode\\";

        return fileDir + fileName;
    }

    public String getClassPath(){
        String rootPathForTheProject = System.getProperty("user.dir");
        String classDir = rootPathForTheProject + "\\CompiledAndRunnapleCode\\classes";

        return classDir;
    }
}
