package com.womantalk.funquiz.quiztype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizTypeRepositoryImpl implements QuizTypeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public QuizType findOne(int id_quiz_type) {
        String SQL = QuizTypeQuery.QUIZ_TYPE_BY_ID ;
        QuizType quizType = jdbcTemplate.queryForObject(SQL, new Object[]{id_quiz_type}, new BeanPropertyRowMapper<QuizType>(QuizType.class));
        return quizType;
    }
    @Override
    public QuizType add(QuizType quizType) {
        return null;
    }

    @Override
    public List<QuizType> findAll() {
        String SQL = QuizTypeQuery.ALL_QUIZ_TYPE;
        List quizType = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<QuizType>(QuizType.class));
        return quizType;
    }

    @Override
    public int update(QuizType quizType) {
        return 0;
    }

    @Override
    public int delete(QuizType quizType) {
        return 0;
    }
}
