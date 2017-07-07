package com.womantalk.funquiz.QuizType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizTypeServiceImpl implements QuizTypeService {
    @Autowired
    private QuizTypeRepository quizTypeRepository;


    @Override
    public QuizType save(QuizType quiztype) {
        return  quizTypeRepository.save(quiztype);

    }

    @Override
    public QuizType findById(int id) {
        return quizTypeRepository.findOne(id);
    }

    @Override
    public List<QuizType> findAll() {
        List quizTypeList = quizTypeRepository.findAll();
        if (quizTypeList != null) {
            return quizTypeList;
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(int id) {
        quizTypeRepository.delete(id);
    }

    @Override
    public QuizType update(QuizType quizType) {
        QuizType quizTypeUpdate = findById(quizType.getIdQuizType());
        quizTypeUpdate.setTypeName(quizType.getTypeName());
        return quizTypeRepository.saveAndFlush(quizTypeUpdate);
    }
}
