package com.womantalk.funquiz.quiz;

import java.util.List;

public interface QuizService {

    Quiz findOne(int id_quiz);

    Quiz add(Quiz quiz);

    List<Quiz> findAll();

    int update(Quiz quiz);

    int delete(Quiz quiz);

}