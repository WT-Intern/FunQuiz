package com.womantalk.funquiz.quiztype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizTypeServiceImpl implements QuizTypeService {
    @Autowired
    private QuizTypeRepository quizTypeRepository;

    @Override
    public QuizType addQuiztype(QuizType quizType) {
        return  quizTypeRepository.save(quizType);
    }

    @Override
    public QuizType findQuiztypebyId(int id_quiztype) {
        return quizTypeRepository.findOne(id_quiztype);
    }

    @Override
    public List<QuizType> getAllQuiztype() {
        List quizTypeList = quizTypeRepository.findAll();
        if (quizTypeList != null) {
            return quizTypeList;
        } else {
            return null;
        }
    }

    @Override
    public QuizType deleteQuiztype(int id_quiztype) {
        QuizType quizType = findQuiztypebyId(id_quiztype);
        if(quizType!=null){
            quizTypeRepository.delete(id_quiztype);
            return quizType;
        }else {
            return null;
        }
    }

    @Override    public QuizType updateQuiztype(QuizType quizType) {
        QuizType quizTypeUpdate = findQuiztypebyId(quizType.getIdQuizType());
        quizTypeUpdate.setText(quizType.getText());
        return quizTypeRepository.saveAndFlush(quizTypeUpdate);
    }
}
