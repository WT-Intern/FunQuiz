package com.womantalk.funquiz.Question;

import com.womantalk.funquiz.Question.Question;
import com.womantalk.funquiz.Question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionServiceImpl implements QuestionService{
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question findById(int id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.getAllQuestion();
    }
}
