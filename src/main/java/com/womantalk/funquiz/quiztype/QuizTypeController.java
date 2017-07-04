package com.womantalk.funquiz.quiztype;


import com.womantalk.funquiz.quiztype.QuizTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuizTypeController {

    @Autowired
    private QuizTypeService quizTypeService;

    @RequestMapping(value = "/quiztype", method = RequestMethod.GET)
    public String QuizTypeList(ModelMap modelMap)
    {
        modelMap.put("quiztype", quizTypeService.findAll());
        return "quiztype";
    }

    @RequestMapping(value = "/quiztype/edit/{id}",method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model){
        model.addAttribute("quiztype", quizTypeService.findOne(id));
        return "formquiztype";
    }

    @RequestMapping(value = "/tambah",method = RequestMethod.POST)
    public String editData(QuizType quizType){
        quizTypeService.update(quizType);
        return "redirect:/quiztype";
    }

    @RequestMapping(value = "/quiztype/delete/{id}")
    public String delete(@PathVariable Integer id){
        quizTypeService.delete(id);
        return "redirect:/quiztype";
    }

}
