package com.womantalk.funquiz.QuizType;

import com.womantalk.funquiz.QuizType.QuizType;
import com.womantalk.funquiz.QuizType.QuizTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuizTypeServiceImpl implements QuizTypeService{
    @Autowired
    private QuizTypeRepository quizTypeRepository;

    @Override
    public void save(QuizType quiztype) {
        quizTypeRepository.save(quiztype);
    }

    @Override
    public QuizType findById(int id) {
        return quizTypeRepository.findById(id);
    }

    @Override
    public List<QuizType> getAllQuizType() {
        return quizTypeRepository.getAllQuizType();
    }
}
