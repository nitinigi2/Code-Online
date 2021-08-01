package com.codeonline.controller;

import com.codeonline.entity.Code;
import com.codeonline.service.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompileController {

    @Autowired
    private Executor executor;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/run")
    public String run(@RequestBody Code code){
        return executor.runCode(code);
    }
}
