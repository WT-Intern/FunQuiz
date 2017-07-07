package com.womantalk.funquiz.quiz;

import com.womantalk.funquiz.quiztype.QuizTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuizTypeService quizTypeService;

    @RequestMapping(value = "/quiz")
    public String QuizList(Model model)
    {
        model.addAttribute("quiz", quizService.findAll());
        return "quiz";
    }

    @RequestMapping(value = "/quiz/edit/{id}",method = RequestMethod.GET)
    public String editDataForm(@PathVariable Integer id, Model model)
    {
        model.addAttribute("qt", quizTypeService.findAll());
        model.addAttribute("quiz", quizService.findOne(id));
        return "formquiz";
    }

    @RequestMapping(value = "/quiz/edit/{id}",method = RequestMethod.POST)
    public String editData(@PathVariable String id, Model model, Quiz quiz)
    {

        model.addAttribute("quiz", quizService.update(quiz));
        return "redirect:/quiz";
    }

    @RequestMapping(value = "/quiz/add" , method = RequestMethod.GET)
    public String viewForm(@Valid Quiz quiz,  Model model)
    {
        model.addAttribute("qt", quizTypeService.findAll());
        return "formquiz";
    }

    @RequestMapping(value = "/quiz/delete/{id}")
    public String delete(@PathVariable Integer id){
        quizService.delete(id);
        return "redirect:/quiz";
    }

    @RequestMapping(value = "/quiz/add",method = RequestMethod.POST)
    public String add (Quiz quiz)
    {
        quizService.save(quiz);
        return "redirect:/quiz";
    }


}
