package com.zillionsoftech.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {

    @GetMapping("/")
    public  String welcome() {
        return "index";
    }
}
