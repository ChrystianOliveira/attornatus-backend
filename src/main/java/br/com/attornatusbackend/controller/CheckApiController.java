package br.com.attornatusbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-api")
public class CheckApiController {

    @GetMapping
    public String checkApi(){
        return "Api is running...";
    }

}
