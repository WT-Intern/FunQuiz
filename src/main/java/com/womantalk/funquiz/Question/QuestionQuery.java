package com.womantalk.funquiz.Question;

import org.springframework.stereotype.Repository;

@Repository
public class QuestionQuery {
    public static final String SQL_INSERT = "insert into t_question (idQuestion, question, idQuiz) values (?, ?, ?)";
    public static final String SQL_FIND_BY_ID = "select * from t_question where idQuestion = ?";
    public static final String SQL_GET_ALL = "select * from t_question";
}
