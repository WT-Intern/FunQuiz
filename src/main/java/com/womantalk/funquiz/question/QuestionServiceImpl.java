package com.womantalk.funquiz.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService
{


    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestionByIdQuiz(int idQuiz)

    {
        return questionRepository.findByQuizIdQuiz(idQuiz);
    }

    @Override
    public Question save(Question question)
    {
        return questionRepository.save(question);
    }
}
