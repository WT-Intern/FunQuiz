package com.womantalk.funquiz.quiz;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by gloria on 07/07/2017.
 */
public interface QuizService
{
    Quiz addQuiz(Quiz quiz);
    Quiz findQuizById(int id_quiz);
    List<Quiz> getAllQuiz();
    Quiz deleteQuiz(int id_quiz);
    Quiz updateQuiz(Quiz quiz);
    Page<Quiz> findAllQuiz(int page);

}
