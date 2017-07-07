package com.womantalk.funquiz.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizRepositoryImpl implements  QuizRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Quiz findOne(int id_quiz) {
        String SQL = QuizQuery.QUIZ_BY_ID;
        Quiz quiz = jdbcTemplate.queryForObject(SQL, new Object[]{id_quiz}, new BeanPropertyRowMapper<>(Quiz.class));
        return quiz;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return null;
    }

    @Override
    public List<Quiz> findAll() {
        String SQL = QuizQuery.ALL_QUIZ;
        List quiz = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Quiz.class));
        return quiz;
    }

    @Override
    public int update(Quiz quiz) {
        return 0;
    }

    @Override
    public int delete(Quiz quiz) {
        return 0;
    }
}
