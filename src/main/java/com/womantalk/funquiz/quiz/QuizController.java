package com.womantalk.funquiz.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dewi Kartika on 07/07/2017.
 */
@Controller
public class QuizController {
    @Autowired
    QuizService quizService;

    @RequestMapping(value = "/quiz", method = RequestMethod.GET)
    public String quizTypeList(ModelMap modelMap)
    {
        modelMap.put("quiz", quizService.findAll());
        return "quizHome";
    }

    @RequestMapping(value = "/quiz/delete/{id}")
    public String delete(@PathVariable Integer id){
        quizService.deleteById(id);
        return "redirect:/quiz";
    }

    @RequestMapping(value = "/quiz/update",method = RequestMethod.POST)
    public String update(Quiz quiz){
        quizService.update(quiz);
        return "redirect:/quiz";
    }

    @RequestMapping(value = "/quiz/update/{id}",method = RequestMethod.GET)
    public String updateForm(@PathVariable Integer id, Model model){
        model.addAttribute("quiz", quizService.findById(id));
        return "quizUpdate";
    }

    @RequestMapping(value = "/quiz/add", method = RequestMethod.POST)
    public String add(@PathVariable Model model, Quiz quiz) {
        model.addAttribute("quiz", quizService.save(quiz));
        return "redirect:/quiz";
    }

    @RequestMapping(value = "/quiz/add", method = RequestMethod.GET)
    public String addForm(@PathVariable Model model, Quiz quiz)
    {
        model.addAttribute("quiz", new Quiz());
        return "quizAdd";
    }
}
