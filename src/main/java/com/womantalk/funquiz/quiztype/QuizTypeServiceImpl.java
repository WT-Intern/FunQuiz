package com.womantalk.funquiz.quiztype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuizTypeServiceImpl implements QuizTypeService{

    @Autowired
    private QuizTypeRepository quizTypeRepository;

    @Override
    public QuizType findOne(int id_quiz_type) {
        return quizTypeRepository.findOne(id_quiz_type);
    }

    @Override
    public void add(QuizType quizType)
    {
        quizTypeRepository.add(quizType);
    }


    @Override
    public List<QuizType> findAll() {
        return quizTypeRepository.findAll();
    }

    @Override
    public int update(QuizType quizType) {
        return quizTypeRepository.update(quizType);
    }

    @Override
    public void delete(int quizType) {
        quizTypeRepository.delete(quizType);
    }
}
