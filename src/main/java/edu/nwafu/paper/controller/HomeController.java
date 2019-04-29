package edu.nwafu.paper.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping("baidu")
    public String baidu(){
        System.out.println("你好");
        return"https://www.baidu.com";
    }
}
