package com.womantalk.funquiz.quiztype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dewi Kartika on 06/07/2017.
 */
@Controller
public class QuizTypeController {
    @Autowired
    QuizTypeService quizTypeService;

    @RequestMapping(value = "/quiztype", method = RequestMethod.GET)
    public String quizTypeList(ModelMap modelMap)
    {
        modelMap.put("quiztype", quizTypeService.findAll());
        return "quizTypeHome";
    }

    @RequestMapping(value = "/quiztype/delete/{id}")
    public String delete(@PathVariable Integer id){
       quizTypeService.deleteById(id);
       return "redirect:/quiztype";
    }

    @RequestMapping(value = "/quiztype/update",method = RequestMethod.POST)
    public String update(QuizType quizType){
        quizTypeService.update(quizType);
        return "redirect:/quiztype";
    }

    @RequestMapping(value = "/quiztype/update/{id}",method = RequestMethod.GET)
    public String updateForm(@PathVariable Integer id, Model model){
        model.addAttribute("quiztype", quizTypeService.findById(id));
        return "quizTypeUpdate";
    }

    @RequestMapping(value = "/quiztype/add", method = RequestMethod.POST)
<<<<<<< HEAD
    public String add(Model model, QuizType quizType) {
=======
    public String add(@PathVariable Model model, QuizType quizType) {
>>>>>>> 6825a95797fd57f686d42ddf0cefa960619a72b3
        model.addAttribute("quiztype", quizTypeService.save(quizType));
        return "redirect:/quiztype";
    }

    @RequestMapping(value = "/quiztype/add", method = RequestMethod.GET)
<<<<<<< HEAD
    public String addForm( Model model, QuizType quizType)
=======
    public String addForm(@PathVariable Model model, QuizType quizType)
>>>>>>> 6825a95797fd57f686d42ddf0cefa960619a72b3
    {
        model.addAttribute("quiztype", new QuizType());
        return "quizTypeAdd";
    }

}
