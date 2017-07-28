package com.womantalk.funquiz.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService
{
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getQuestionByIdQuiz(int idQuiz)

    {
        return questionRepository.findAllByQuiz_IdQuiz(idQuiz);
    }

    @Override
    public Question addQuestion(Question question, MultipartFile fileQuestion) {

        if(!fileQuestion.isEmpty())
        {
            question.setImageURL(fileQuestion.getOriginalFilename());
            String name = fileQuestion.getOriginalFilename();
            try{
                byte[] bytes = fileQuestion.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("C:/Users/gloria/Documents/GVM/image/question/"+name)));
                stream.write(bytes);
                stream.close();
            }catch (Exception e)
            {
                return null;
            }
        }
        return questionRepository.save(question);
    }

    @Override
    public Question findQuestionById(int id_question) {
        return questionRepository.findOne(id_question);
    }

    @Override
    public List<Question> getAllQuestion() {
        List<Question> questionList = questionRepository.findAll();
        if(questionList!=null) {
            return questionList;
        }else {
            return null;
        }
    }

    @Override
    public Question updateQuestion(Question question) {
        Question questionUpdate = findQuestionById(question.getIdQuestion());
        questionUpdate.setText(question.getText());
        questionUpdate.setImageURL(question.getImageURL());
        questionUpdate.setQuiz(question.getQuiz());
        return questionRepository.saveAndFlush(questionUpdate);
    }
}
