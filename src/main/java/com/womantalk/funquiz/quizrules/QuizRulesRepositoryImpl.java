package com.womantalk.funquiz.QuizRules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizRulesRepositoryImpl implements QuizRulesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public QuizRules findOne(int id_rules) {
        String SQL = QuizRulesQuery.QUIZ_RULES_BY_ID;
        QuizRules quizRules = jdbcTemplate.queryForObject(SQL, new Object[]{id_rules}, new BeanPropertyRowMapper<QuizRules>(QuizRules.class));
        return quizRules;
    }

    @Override
    public QuizRules add(QuizRules quizRules) {
        return null;
    }

    @Override
    public List<QuizRules> findAll() {
        String SQL = QuizRulesQuery.ALL_QUIZ_RULES;
        List quizRules = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<QuizRules>(QuizRules.class));
        return quizRules;
    }

    @Override
    public int update(QuizRules quizRules) {
        return 0;
    }

    @Override
    public int delete(QuizRules quizRules) {
        return 0;
    }
}
