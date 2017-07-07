package com.womantalk.funquiz.Quiz;

import com.womantalk.funquiz.Quiz.Quiz;
import com.womantalk.funquiz.Quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;


    @Override
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz findById(int id) {
        return quizRepository.findOne(id);
    }

    @Override
    public List<Quiz> findAll() {
        List quizList = quizRepository.findAll();
        if (quizList != null) {
            return  quizList;
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(int id) {
        quizRepository.delete(id);
    }

    @Override
    public Quiz update(Quiz quiz) {
        Quiz quizUpdate = findById(quiz.getIdQuiz());
        quizUpdate.setJudulQuiz(quiz.getJudulQuiz());
        quizUpdate.setQuizType(quizUpdate.getQuizType());
        return quizRepository.saveAndFlush(quizUpdate);
    }
}
