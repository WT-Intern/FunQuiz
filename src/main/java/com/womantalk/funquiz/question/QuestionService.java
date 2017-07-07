package com.womantalk.funquiz.Question;

import java.util.List;

public interface QuestionService
{
    Question findOne(int id_question);

    void save (Question question);

    List<Question> findAll();

    List<Question> getAllQuestionByIdQuiz (Integer id_quiz);

    Question delete(int id_question);

    Question updateQuestion (Question question);

}
