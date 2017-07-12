package com.womantalk.funquiz.quiz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {


    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz findOne(int id_quiz) {
        return quizRepository.findOne(id_quiz);
    }

    @Override
    public List<Quiz> findAll() {
        List<Quiz> quizList = quizRepository.findAll();
        if(quizList!=null) {
            return quizList;
        }else {
            return null;
        }
    }

/*    @Override
    public List<Quiz> findAllByIdQuizType(int IdQuizType)
    {
        return quizRepository.findAllByQuizType_IdQuizType(IdQuizType);
    }*/

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz delete(int id_quiz) {
        Quiz quiz = findOne(id_quiz);
        if(quiz!=null){
            quizRepository.delete(id_quiz);
            return quiz;
        }else {
            return null;
        }
    }

    @Override
    public Quiz update(Quiz quiz) {
        Quiz quizUpdate = findOne(quiz.getIdQuiz());
        quizUpdate.setJudulQuiz(quiz.getJudulQuiz());
        quizUpdate.setQuizType(quizUpdate.getQuizType());
        return quizRepository.saveAndFlush(quizUpdate);
    }
}
