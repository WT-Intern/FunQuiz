package com.womantalk.client.quiz;

import com.fasterxml.jackson.annotation.JsonView;
import com.womantalk.client.option.OptionService;
import com.womantalk.client.quizrules.QuizRules;
import com.womantalk.client.quizrules.QuizRulesService;
import com.womantalk.client.tools.ModelToResponseMapper;
import com.womantalk.client.tools.Response;
import com.womantalk.client.tools.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizAPIController
{
    @Autowired
    QuizService quizService;

    @Autowired
    OptionService optionService;

    @Autowired
    QuizRulesService quizRulesService;


    @JsonView (View.AllQuiz.class)
    @RequestMapping(value ="/API/Quiz/getQuiz/{idQuiz}", method = RequestMethod.GET)
    public Response<List<Quiz>> getAllQuizByIdQuiz (@PathVariable Integer idQuiz)
    {
      return quizService.getAllQuizByIdQuiz(idQuiz);
    }


    @JsonView(View.QuizRules.class)
    @RequestMapping (value ="API/Quiz/ShowResultQuiz", method = RequestMethod.POST)
    @ResponseBody
    public Response <List<QuizRules>> showResult
            (@RequestParam ("idQuiz")long idQuiz, @RequestParam ("idOption") String idOptions)
    {
        return quizService.showResult(idQuiz, idOptions);
    }


    @JsonView (View.Quiz.class)
    @RequestMapping(value ="/API/Quiz/getAllQuizByStatus")
    public Response<List<Quiz>> getAllQuizByStatus(String status, @RequestParam ("idQuiz") Integer id)
    {
        List <Quiz> quizzes = quizService.findTop3ByStatusOrderByIdQuizDesc(status, id);
        return ModelToResponseMapper.mapThisSuccess(quizzes);
    }

    //related quiz

    @JsonView (View.Quiz.class)
    @RequestMapping(value ="/API/Quiz/getQuizByIdQuizType", method = RequestMethod.POST)
    public Response<List<Quiz>> getAllQuizByIdQuizType (@RequestParam ("idQuizType")Integer idQuizType)
    {
        return quizService.getAllQuizByIdQuizType(idQuizType);
    }

}
