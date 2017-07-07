package com.womantalk.funquiz.Quiz;


import java.util.List;

public interface QuizRepository {

    Quiz findOne(int id_quiz);

    Quiz add(Quiz quiz);

    List<Quiz> findAll();

    int update(Quiz quiz);

    int delete(Quiz quiz);
}
