package com.codeonline.service;

import com.codeonline.entity.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Executor {

    @Autowired
    private ExecuteJavaCode executeJavaCode;

    public String runCode(Code code) {
        String language = code.getLanguage();
        String program = code.getCode();
        System.out.println(code);
        String output = "";

        if (language == "" || language == null) return "Something went wrong";

        switch (language) {
            case "java":
                output = executeJavaCode.execute(program);
                break;
            default:
                break;
        }

        return output;
    }
}
