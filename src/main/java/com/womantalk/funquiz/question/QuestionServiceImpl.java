package com.womantalk.funquiz.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService
{
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question findOne(int id_question)
    {
        return questionRepository.findOne(id_question);
    }

    @Override
    public void save(Question question)
    {
        questionRepository.save(question);

    }

    @Override
    public List<Question> findAll()
    {
        List<Question> questionList = questionRepository.findAll();
        if (questionList != null)
        {
            return questionList;
        }else
        {
            return null;
        }
    }

    @Override
    public List<Question> getAllQuestionByIdQuiz(Integer id_quiz)
    {
        List <Question> questionListByIdQuiz = questionRepository.getAllQuestionByIdQuiz(id_quiz);
        if (questionListByIdQuiz != null)
        {
            return questionListByIdQuiz;
        }else
        {
            return null;
        }
    }

    @Override
    public Question delete(int id_question)
    {
        Question question = findOne(id_question);
        if (question != null)
        {
            questionRepository.delete(id_question);
            return question;
        }else
        {
            return  null;
        }
    }

    @Override
    public Question updateQuestion(Question question)
    {
        Question updateQuestion = findOne(question.getIdQuestion());
        updateQuestion.setQuestion(question.getQuestion());
        updateQuestion.setOptions(question.getOptions());
        updateQuestion.setQuiz(question.getQuiz());
        return questionRepository.saveAndFlush(updateQuestion);
    }


}
