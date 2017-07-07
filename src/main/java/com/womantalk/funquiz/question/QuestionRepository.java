package com.womantalk.funquiz.Question;


import java.util.List;

public interface QuestionRepository {

    Question findOne(int id_option);

    Question add(Question question);

    List<Question> findAll();

    int update(Question question);

    int delete(Question question);
}
