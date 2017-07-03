package com.womantalk.funquiz.QuizType;

import org.springframework.stereotype.Repository;

@Repository
public class QuizTypeQuery {
    public static final String SQL_INSERT = "insert into t_quizType (idQuizType, typeName) values (?, ?)";
    public static final String SQL_FIND_BY_ID = "select * from t_quizType where idQuizType = ?";
    public static final String SQL_GET_ALL = "select * from t_quizType";
}
