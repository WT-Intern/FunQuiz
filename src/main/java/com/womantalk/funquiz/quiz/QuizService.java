package com.womantalk.funquiz.quiz;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by gloria on 07/07/2017.
 */
public interface QuizService
{
    Quiz addQuiz(Quiz quiz, @RequestParam("fileQuiz")MultipartFile fileQuiz);
    Quiz findQuizById(int id_quiz);
    List<Quiz> getAllQuiz();
    Quiz deleteQuiz(int id_quiz);
    Quiz updateQuiz(Quiz quiz);
    Page<Quiz> findAllQuiz(int page);

}
