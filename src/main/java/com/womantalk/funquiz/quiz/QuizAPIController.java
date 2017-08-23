package com.womantalk.funquiz.quiz;

import com.fasterxml.jackson.annotation.JsonView;
import com.womantalk.funquiz.option.Option;
import com.womantalk.funquiz.option.OptionService;
import com.womantalk.funquiz.question.Question;
import com.womantalk.funquiz.question.QuestionService;
import com.womantalk.funquiz.quiz.QuizService;
import com.womantalk.funquiz.quizrules.QuizRules;
import com.womantalk.funquiz.quizrules.QuizRulesService;
import com.womantalk.funquiz.tools.ModelToResponseMapper;
import com.womantalk.funquiz.tools.Response;
import com.womantalk.funquiz.tools.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired
    QuizRepository quizRepository;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();

    //delete quiz
    @JsonView(View.Public.class)
    @RequestMapping(value = "api-delete-quiz", method = RequestMethod.POST, headers = "Accept=application/json")
    public Response<Quiz> deleteQuiz(@ModelAttribute Quiz quiz){
        quizService.deleteQuiz(quiz.getIdQuiz());
        return ModelToResponseMapper.mapThisSuccess(quiz);
    }

    //get All quiz
    @JsonView(View.Public.class)
    @RequestMapping(value = "api-quiz", method = RequestMethod.GET)
    public Response<List<Quiz>> getListAllQuiz()
    {
        List<Quiz> quizzes = quizService.getAllQuiz();
        return ModelToResponseMapper.mapThisSuccess(quizzes);
    }

    //set status when click button
    @RequestMapping(value = "api-status", method = RequestMethod.POST)
    public @ResponseBody String statusQuiz(@ModelAttribute Quiz quiz)
    {
        Quiz quizs = quizService.findQuizById(quiz.getIdQuiz());
        quizs.setStatus("published");
        quizs.setPublished_date(dateFormat.format(date));
       // System.out.println(quizs.getStatus());
        quizService.updateQuiz(quizs);
        return "Quiz publish";
    }

    //Upload image
    @JsonView(View.Public.class)
    @RequestMapping(value = "/api-upload", method = RequestMethod.POST)
    public @ResponseBody String uploadFileHandler(@RequestParam("type") String type,
                                                  @RequestParam("multipartFile") MultipartFile multipartFile) {
        if(type.equals("quiz")){
            if(!multipartFile.isEmpty())
            {
                try
                {
                    String name = multipartFile.getOriginalFilename();
                    String path =  "E:/KP/Project KP/end_user_project/src/main/resources/static/images/quiz/"+name;
                    byte[] bytes = multipartFile.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(new File(path)));
                    stream.write(bytes);
                    stream.close();

                    return path;

                }catch (Exception e)
                {
                    return "Your quiz uploaded fail";
                }

            }
        }
        else if(type.equals("question ")){
            if(!multipartFile.isEmpty())
            {
                try{
                    String name = multipartFile.getOriginalFilename();
                    String path =  "G:/question/"+name;
                    multipartFile.transferTo(new File(path));

                    return path;
                }catch (Exception e)
                {
                    return "Your question uploaded fail";
                }
            }
        }

        else if(type.equals("result")){
            if(!multipartFile.isEmpty())
            {
                try{
                    String name = multipartFile.getOriginalFilename();
                    String path =  "G:/result/"+name;
                    multipartFile.transferTo(new File(path));

                    return path;
                }catch (Exception e)
                {
                    return "Your result uploaded fail";
                }
            }
        }

        else {
            if(!multipartFile.isEmpty())
            {
                try{
                    String name = multipartFile.getOriginalFilename();
                    String path =  "G:/option/"+name;
                    multipartFile.transferTo(new File(path));
                    return path;
                }catch (Exception e)
                {
                    return "Your option uploaded fail";
                }
            }
        }
        return "Uploaded Success";
    }

    //Update process
    @JsonView(View.Public.class)
    @RequestMapping(value = "api-update-quiz",method = RequestMethod.POST)
    public Quiz updateQuiz(@RequestBody Quiz quiz){

        quizService.findQuizById(quiz.getIdQuiz());
        quiz.setModified_date(dateFormat.format(date));
        quiz.setTotal_question(quiz.getQuestions().size());
        quizService.updateQuiz(quiz);

        int questionLength = quiz.getQuestions().size();
        for(int i=0; i<questionLength ; i++)
        {
            Question question = quiz.getQuestions().get(i);
            questionService.findQuestionById(question.getIdQuestion());
            question.setQuiz(quiz);
            questionService.updateQuestion(question);

            int optionLength = question.getOptions().size();
            for (int j=0; j<optionLength ; j++)
            {
                Option option = question.getOptions().get(j);
                optionService.findOptionById(option.getIdOption());
                option.setQuestion(question);
                optionService.updateOption(option);
            }
        }

        int resultLength = quiz.getQuizRules().size();
        for (int i=0; i<resultLength; i++)
        {
            QuizRules quizRules = quiz.getQuizRules().get(i);
            quizRulesService.findQuizRulesById(quizRules.getIdRules());
            quizRules.setQuiz(quiz);
            quizRulesService.updateQuizRules(quizRules);
        }
        return quiz;
    }

    //Create Process

    @JsonView(View.Public.class)

    @RequestMapping(value = "api-create-quiz",method = RequestMethod.POST)

    public Quiz createQuiz(@RequestBody Quiz quiz){

        quizService.addQuiz(quiz);

        quiz.setTotal_question(quiz.getQuestions().size());

        int questionLength = quiz.getQuestions().size();

        for(int i=0; i<questionLength ; i++)
        {

            Question question = quiz.getQuestions().get(i);

            question.setQuiz(quiz);

            questionService.addQuestion(question);



            int optionLength = question.getOptions().size();

            for (int j=0; j<optionLength ; j++)

            {

                Option option = question.getOptions().get(j);

                option.setQuestion(question);

                optionService.addOption(option);

            }

        }



        int resultLength = quiz.getQuizRules().size();

        for (int i=0; i<resultLength; i++)

        {

            QuizRules quizRules = quiz.getQuizRules().get(i);

            quizRules.setQuiz(quiz);

            quizRulesService.addQuizRules(quizRules);

        }

        return quiz;

    }


    //update with sent json
    @JsonView(View.Public.class)
    @RequestMapping(value = "api-quiz-getAllById/{id}", method = RequestMethod.GET)
    public Response <Quiz> getQuizById(@PathVariable Integer id, @ModelAttribute Quiz quiz)
    {
        Quiz kuis = quizService.findQuizById(id);
        return ModelToResponseMapper.mapThisSuccess(kuis);
    }
}
