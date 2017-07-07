package com.womantalk.funquiz.quiz;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    @Override
    public Quiz findOne(int id_quiz) {
        return quizRepository.findOne(id_quiz);
    }

    @Override
    public Quiz add(Quiz quiz) {
        return null;
    }

    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public int update(Quiz quiz) {
        return 0;
    }

    @Override
    public int delete(Quiz quiz) {
        return 0;
    }
}
