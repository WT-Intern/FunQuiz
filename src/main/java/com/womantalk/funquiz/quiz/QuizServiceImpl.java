package com.womantalk.funquiz.quiz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {


    @Autowired
    private QuizRepository quizRepository;


    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();

    @Override
    public Quiz addQuiz(Quiz quiz, MultipartFile fileQuiz) {

        quiz.setStatus("draft");
        quiz.setCreated_date(dateFormat.format(date));

        if(!fileQuiz.isEmpty()) {
            quiz.setImageURL(fileQuiz.getOriginalFilename());
            String name = fileQuiz.getOriginalFilename();
            try {
                byte[] bytes = fileQuiz.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File("C:/Users/gloria/Documents/GVM/image/quiz/" + name)));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                return null;
            }
        }

        return quizRepository.save(quiz);
    }

    @Override
    public Quiz findQuizById(int id_quiz) {
        return quizRepository.findOne(id_quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> quizList = quizRepository.findAll();
        if(quizList!=null) {
            return quizList;
        }else {
            return null;
        }
    }

    @Override
    public Quiz deleteQuiz(int id_quiz) {
        Quiz quiz = findQuizById(id_quiz);
        if(quiz!=null){
            quizRepository.delete(id_quiz);
            return quiz;
        }else {
            return null;
        }
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        Quiz quizUpdate = findQuizById(quiz.getIdQuiz());
        quizUpdate.setJudulQuiz(quiz.getJudulQuiz());
        quizUpdate.setImageURL(quiz.getImageURL());
        quizUpdate.setPublished_date(quiz.getPublished_date());
        quizUpdate.setTotal_question(quiz.getTotal_question());
        quizUpdate.setQuizType(quizUpdate.getQuizType());
        return quizRepository.saveAndFlush(quizUpdate);
    }

    @Override
    public Page<Quiz> findAllQuiz(int page) {
        return quizRepository.findAllByOrderByIdQuizDesc(new PageRequest(page -1,10));
    }
}
