package com.womantalk.funquiz.quiz;

import java.util.List;

public interface QuizService {

    Quiz findOne(int id_quiz);

    List<Quiz> findAll();

    Quiz save(Quiz quiz);

    Quiz delete(int quiz);

    Quiz update(Quiz quiz);

}
