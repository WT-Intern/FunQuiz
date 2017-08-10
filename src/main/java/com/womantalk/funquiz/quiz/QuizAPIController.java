package com.womantalk.funquiz.Quiz;

import com.fasterxml.jackson.annotation.JsonView;
import com.womantalk.funquiz.option.Option;
import com.womantalk.funquiz.option.OptionService;
import com.womantalk.funquiz.question.Question;
import com.womantalk.funquiz.question.QuestionService;
import com.womantalk.funquiz.quizrules.QuizRules;
import com.womantalk.funquiz.quizrules.QuizRulesService;
import com.womantalk.funquiz.tools.ModelToResponseMapper;
import com.womantalk.funquiz.option.Option;
import com.womantalk.funquiz.tools.View;
import org.springframework.beans.factory.annotation.Autowired;
import com.womantalk.funquiz.tools.Response;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

/**
 * Created by gloria on 7/19/2017.
 */

@RestController
public class QuizAPIController {

    @Autowired
    QuizService quizService;

    @Autowired
    QuestionService questionService;

    @Autowired
    OptionService optionService;

    @Autowired
    QuizRulesService quizRulesService;

    @JsonView(View.Public.class)
    @RequestMapping(value = "api-delete-quiz", method = RequestMethod.POST,
    headers = "Accept=application/json")
    public Response<Quiz> deleteQuiz(@ModelAttribute Quiz quiz){
      quizService.deleteQuiz(quiz.getIdQuiz());
      return ModelToResponseMapper.mapThisSuccess(quiz);
    }

    @JsonView(View.Public.class)
    @RequestMapping(value = "api-quiz", method = RequestMethod.GET)
    public Response<List<Quiz>> getListAllQuiz()
    {
        List<Quiz> quizzes = quizService.getAllQuiz();
        return ModelToResponseMapper.mapThisSuccess(quizzes);
    }

    @JsonView(View.Public.class)
    @RequestMapping(value = "api-create-quiz",method = RequestMethod.POST)
    public Response<Quiz> createQuiz(@ModelAttribute Quiz quiz, @ModelAttribute Question question,
                                     @ModelAttribute Option option,@ModelAttribute QuizRules rules,
                                     MultipartFile fileQuestion, MultipartFile fileOption,
                                     MultipartFile fileQuiz, MultipartFile fileResult)
    {
        //Quiz
       quizService.addQuiz(quiz,fileQuiz);
       quiz.setTotal_question(questionService.getQuestionByIdQuiz(quiz.getIdQuiz()).size()+1);
       quizService.addQuiz(quiz,fileQuiz);

       //Question
       question.setQuiz(quizService.findQuizById(quiz.getIdQuiz()));
       questionService.addQuestion(question,fileQuestion);

       //Option
        option.setQuestion(questionService.findQuestionById(question.getIdQuestion()));
        optionService.addOption(option,fileOption);

       //Result
        rules.setQuiz(quizService.findQuizById(quiz.getIdQuiz()));
        quizRulesService.addQuizRules(rules,fileResult);

        return ModelToResponseMapper.mapThisSuccess(quiz);

    }


    @RequestMapping(value = "api-update-quiz", method = RequestMethod.POST)
    public Response<Quiz> updateQuiz(@ModelAttribute Quiz quiz, @ModelAttribute Question question,
                                     @ModelAttribute Option option, @ModelAttribute QuizRules quizRules)
    {
        quizService.findQuizById(quiz.getIdQuiz());
        quizService.updateQuiz(quiz);

        questionService.getQuestionByIdQuiz(quiz.getIdQuiz());
        questionService.updateQuestion(question);

        optionService.getOptionByIdQuestion(question.getIdQuestion());
        optionService.updateOption(option);

        return  ModelToResponseMapper.mapThisSuccess(quiz);
    }
}
