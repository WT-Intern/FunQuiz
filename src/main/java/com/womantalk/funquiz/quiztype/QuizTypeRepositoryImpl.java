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
    public void add(QuizType quizType)
    {
        String sql = QuizTypeQuery.INSERT_QUIZ_TYPE;
        jdbcTemplate.update(sql, quizType.getTypeName());

    }


    @Override
    public List<QuizType> findAll() {
        String SQL = QuizTypeQuery.ALL_QUIZ_TYPE;
        List quizType = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<QuizType>(QuizType.class));
        return quizType;
    }

    @Override
    public int update(QuizType quizType) {
        String SQL = QuizTypeQuery.UPDATE_QUIZ_TYPE;
        return jdbcTemplate.update(SQL, quizType.getTypeName(), quizType.getIdQuizType());
    }

    @Override
    public void delete(int quizType) {
        String SQL = QuizTypeQuery.DELETE_QUIZ_TYPE;
        jdbcTemplate.update(SQL, new Object[] { Integer.valueOf(quizType) });
    }
}
