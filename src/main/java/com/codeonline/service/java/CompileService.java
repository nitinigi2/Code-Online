package com.codeonline.service.java;

import com.codeonline.service.Compile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CompileService implements Compile {

    private String compileLocation = compiledFileLocation();

    @Override
    public String compile(String filePath) throws Exception{
        String compileCommand = "javac -d " + compileLocation + "classes " + filePath;

        System.out.println("compileCommand:::::::::::::: " + compileCommand);

        Process process = null;

        try {
            process = Runtime.getRuntime().exec(compileCommand, null);
        } catch (IOException e1) {
            System.out.println("Exception while compiling java code:::::::::::" + e1);
            throw e1;
        }

        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        String output;
        StringBuffer compileErrorMessage = new StringBuffer("");

        try {
            while ((output = stdError.readLine()) != null) {
                compileErrorMessage = compileErrorMessage.append(output + "\n");
            }
        } catch (Exception e) {
            throw e;
        }

        System.out.println(compileErrorMessage);
        return compileErrorMessage.toString();
    }

    private String compiledFileLocation(){
        String rootPathForTheProject = System.getProperty("user.dir");
        return rootPathForTheProject + "\\CompiledAndRunnapleCode\\";
    }
}
