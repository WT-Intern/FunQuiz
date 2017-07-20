package com.womantalk.funquiz.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by gloria on 7/19/2017.
 */

@RestController
public class QuizAPIController {


    @Autowired
    QuizService quizService;

    @RequestMapping(value = "/getQuiz", method = RequestMethod.GET)
    public String QuizList(Model model)
    {
        model.addAttribute("quiz", quizService.findAll());
        return "quiz";
    }
}
