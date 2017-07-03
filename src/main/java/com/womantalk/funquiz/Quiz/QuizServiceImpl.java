package com.womantalk.funquiz.Quiz;

import com.womantalk.funquiz.Quiz.Quiz;
import com.womantalk.funquiz.Quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    @Override
    public Quiz findById(int id) {
        return quizRepository.findById(id);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepository.getAllQuiz();
    }
}
