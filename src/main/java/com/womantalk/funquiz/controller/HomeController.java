package com.womantalk.funquiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("index")
    public String home() {
        return "index";
    }

    @RequestMapping("data")
    public String homea() {
        return "data";
    }

    @RequestMapping("addQuiz")
    public String homeb() {
        return "addQuiz";
    }

    @RequestMapping("edit")
    public String homec() {
        return "edit";
    }
}
