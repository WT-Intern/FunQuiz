package com.womantalk.funquiz.quiz;

import com.womantalk.funquiz.question.Question;
import com.womantalk.funquiz.question.QuestionService;
import com.womantalk.funquiz.quizrules.QuizRules;
import com.womantalk.funquiz.quizrules.QuizRulesService;
import com.womantalk.funquiz.quiztype.QuizTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuizTypeService quizTypeService;

    @Autowired
    private QuestionService questionService;



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
    public String add(Quiz quiz, Question question, @RequestParam("file") MultipartFile file, Model model)
    {

        if(!file.isEmpty()){
            question.setImageURL(file.getOriginalFilename());
            String name = file.getOriginalFilename();
            try{
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("C:/Users/gloria/Documents/GVM/question/"+name)));
                        stream.write(bytes);
                        stream.close();
            }catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        quiz.setStatus("Draft");
        quizService.save(quiz);


        question.setQuiz(quiz);
       // model.addAttribute("que",questionService.save(question));
        questionService.save(question);
        return "redirect:/quiz";
    }

    @RequestMapping(value = "/publish/quiz/{id}")
    public String publishQuiz(@PathVariable Integer id)
    {
        Quiz quiz = quizService.findOne(id);
        quiz.setStatus("Published");
        quizService.save(quiz);
        return "redirect:/quiz";
    }

}
