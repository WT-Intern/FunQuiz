package com.womantalk.funquiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Grace on 13/08/2017.
 */
@Controller
public class HomeController {
    @RequestMapping("index")
    public String home() {
        return "index";
    }
    @RequestMapping("addquiz")
    public String homeb() {
        return "addquiz";
    }
    @RequestMapping("result")
    public String homec(){
        return "result";
    }
    @RequestMapping("edit")
    public String homed() {
        return "edit";
    }
}
