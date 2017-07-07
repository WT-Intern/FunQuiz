package com.womantalk.funquiz.Question;


import java.util.List;

public interface QuestionService {

    Question findOne(int id_option);

    Question add(Question question);

    List<Question> findAll();

    int update(Question question);

    int delete(Question question);

    void save(Question question);
}
