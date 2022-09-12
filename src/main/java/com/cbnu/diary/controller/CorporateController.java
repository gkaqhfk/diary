package com.cbnu.diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("corporate")
public class CorporateController {

    @GetMapping
    public String corporate() {
        return "corporate";
    }

}
