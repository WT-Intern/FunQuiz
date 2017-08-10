package com.womantalk.funquiz.Quiz;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {

    @RequestMapping(value = "/index")
    public String viewIndex()

    {
      return "index";
    }

    @RequestMapping(value = "/add")
    public String viewForm()
    {
        return "AddQuiz";
    }

    @RequestMapping(value = "/result")
    public String viewResultForm()
    {
        return "Result";
    }

}
