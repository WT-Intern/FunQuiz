package com.womantalk.funquiz.Question;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Question findOne(int id_option) {
        String SQL = QuestionQuery.QUESTION_BY_ID;
        Question question = jdbcTemplate.queryForObject(SQL, new Object[]{id_option}, new BeanPropertyRowMapper<>(Question.class));
        return question;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public List<Question> findAll() {
        String SQL = QuestionQuery.ALL_QUESTION;
        List question = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(Question.class));
        return question;
    }

    @Override
    public int update(Question question) {
        return 0;
    }

    @Override
    public int delete(Question question) {
        return 0;
    }
}
