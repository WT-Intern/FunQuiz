package com.womantalk.funquiz.Quiz;

import org.springframework.stereotype.Repository;

@Repository
public class QuizQuery {
    public static final String SQL_INSERT = "insert into t_quiz (idQuiz, judulQuiz, idQuizType) values (?, ?, ?)";
    public static final String SQL_FIND_BY_ID = "select * from t_quiz where idQuiz = ?";
    public static final String SQL_GET_ALL = "select * from t_quiz";
}
