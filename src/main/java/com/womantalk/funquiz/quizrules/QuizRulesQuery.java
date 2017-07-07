package com.womantalk.funquiz.QuizRules;

import org.springframework.stereotype.Repository;

@Repository
public class QuizRulesQuery {
    public static final String SQL_INSERT = "insert into t_quizRules (idRules, min, max, value, description, idQuiz) values (?, ?, ?, ?, ?, ?)";
    public static final String SQL_FIND_BY_ID = "select * from t_quizRules where idRules = ?";
    public static final String SQL_GET_ALL = "select * from t_quizRules";
}
