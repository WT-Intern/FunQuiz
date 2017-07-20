package com.womantalk.funquiz.quiz;

import java.util.List;

/**
 * Created by gloria on 07/07/2017.
 */
public interface QuizService
{
    Quiz save(Quiz quiz);
    Quiz findOne(int id_quiz);
    List<Quiz> findAll();
  //  List<Quiz> findAllByIdQuizType (int id_quiz_type);
    Quiz delete(int id_quiz);
    Quiz update(Quiz quiz);

}
