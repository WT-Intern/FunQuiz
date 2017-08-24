package com.womantalk.client.quiz;


import com.womantalk.client.option.OptionService;
import com.womantalk.client.quizrules.QuizRules;
import com.womantalk.client.quizrules.QuizRulesService;
import com.womantalk.client.quiztype.QuizTypeService;
import com.womantalk.client.tools.ModelToResponseMapper;
import com.womantalk.client.tools.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService
{


    @Autowired
    private QuizService quizService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private QuizRulesService quizRulesService;

    @Autowired
    private QuizRepository quizRepository;

    //Related Quiz
    @Autowired
    private QuizTypeService quizTypeService;

    @Override
    public List<Quiz> findAllQuizByStatus()
    {
        return quizRepository.getAllQuizByStatus();
    }

    @Override
    public List<Quiz> findQuizByIdQuiz(Integer idQuiz)
    {
        return quizRepository.getAllQuizByIdQuiz(idQuiz);
    }

    @Override
    public Response<List<Quiz>> getAllQuizByStatus
            (int offset, int limit)
    {

        List <Quiz> quizzes = quizService.findAllQuizByStatus();
        return ModelToResponseMapper.mapThisSuccess(quizzes);
    }

    @Override
    public Response<List<Quiz>> getAllQuizByIdQuiz(Integer idQuiz)
        {
        List<Quiz> quizzes = quizService.findQuizByIdQuiz(idQuiz);
        return ModelToResponseMapper.mapThisSuccess(quizzes);
    }

    @Override
    public Response<List<QuizRules>> showResult(long idQuiz, String idOptions)
    {

        String [] idOptionsArray = idOptions.split(",");
        int score = 0;
        int rightAnswer = 0;
        int totalQuestion = idOptionsArray.length;

        for (int indexIdOption = 0; indexIdOption < idOptionsArray.length;indexIdOption++)
        {
            score += optionService.findValueByIdOption(Integer.parseInt(idOptionsArray[indexIdOption]));
        }

        rightAnswer = score;
        List <QuizRules> allQuizRules = quizRulesService.findResult();
        List <QuizRules> quizRulesList = new ArrayList<QuizRules>();
        for (QuizRules quizRules : allQuizRules)
        {
            if( score >= quizRules.getMin() && score <= quizRules.getMax() && quizRules.getQuiz().getIdQuiz() == idQuiz)
            {
                quizRulesList.add(quizRules);
                quizRules.setRightAnswer(rightAnswer);
                quizRules.setTotalQuestion(totalQuestion);
            }
        }
        return ModelToResponseMapper.mapThisSuccess(quizRulesList);
    }

    @Override
    public List<Quiz> findTop3ByStatusOrderByIdQuizDesc  (String status, Integer lastId)
    {
        int idMax = 100000;
        List <Quiz> quizzes = quizRepository.getAllQuizByStatus();
        List <Quiz> quizList = new ArrayList<>();
        for (Quiz quiz : quizzes)
        {
            if ( lastId == null)
            {
                lastId = idMax;
                quizList=  quizRepository.findTop3ByIdQuizLessThanOrderByIdQuizDesc(lastId);
            }else
            {
                quizList=  quizRepository.findTop3ByIdQuizLessThanOrderByIdQuizDesc(lastId);
            }
        }
        return quizList;

    }


    @Override
    public List<Quiz> findQuizByIdQuizType(Integer idQuizType) {
        List<Quiz> quizzes = quizRepository.getAllQuiz();
        List<Quiz> quizByIdQuizType = new ArrayList<Quiz>();
        List <Quiz>quizzes1 = new ArrayList<Quiz>();
        for (Quiz quiz : quizzes)
        {

            if (quiz.getQuizType().getIdQuizType() == idQuizType)
            {
                quizByIdQuizType.add(quiz);
            }
        }
        if (quizByIdQuizType.size() > 6)
        {
            quizzes1 = quizByIdQuizType.subList(0, 5);
        }
        else
        {
            quizzes1 = quizByIdQuizType;
        }
           return quizzes1;
        }




    @Override
    public Response<List<Quiz>> getAllQuizByIdQuizType(Integer idQuizType)
    {
        List<Quiz> quizzes = quizService.findQuizByIdQuizType(idQuizType);
        return ModelToResponseMapper.mapThisSuccess(quizzes);
    }

}
