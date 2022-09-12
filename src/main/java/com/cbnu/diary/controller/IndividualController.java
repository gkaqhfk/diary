package com.cbnu.diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("individual")
public class IndividualController {

    @GetMapping
    public String individual() {
        return "individual";
    }

}
