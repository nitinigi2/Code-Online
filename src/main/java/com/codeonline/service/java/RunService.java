package com.codeonline.service.java;

import com.codeonline.service.Run;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class RunService implements Run {

    @Override
    public String run(String fileName, String classPath) throws Exception {
        String runCommand = "java -cp " + classPath + "; " + fileName;

        System.out.println("runCommand::::::::::::::::::: " + runCommand);

        Process process = null;
        try {
            process = Runtime.getRuntime().exec(runCommand);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        BufferedReader stdOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String output = null;

        StringBuffer ans = new StringBuffer("");
        try {
            while ((output = stdOutput.readLine()) != null) {
                ans = ans.append(output + "\n");
            }
        } catch (Exception e) {
            System.out.println("runtime error");
        }

        return ans.toString();
    }
}
