package com.womantalk.funquiz.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question findOne(int id_option) {
        return questionRepository.findOne(id_option);
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public int update(Question question) {
        return 0;
    }

    @Override
    public int delete(Question question) {
        return 0;
    }
}
