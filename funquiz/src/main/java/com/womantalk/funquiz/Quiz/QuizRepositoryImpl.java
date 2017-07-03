package com.womantalk.funquiz.Quiz;


import com.womantalk.funquiz.Quiz.Quiz;
import com.womantalk.funquiz.Quiz.QuizQuery;
import com.womantalk.funquiz.QuizType.QuizType;
import com.womantalk.funquiz.Quiz.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuizRepositoryImpl implements QuizRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Quiz quiz) {
        String query = QuizQuery.SQL_INSERT;
        jdbcTemplate.update(query);
    }

    @Override
    public Quiz findById(int id) {
        String query = QuizQuery.SQL_FIND_BY_ID;
        Quiz quiz = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Quiz>() {
            @Override
            public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
                Quiz quiz = new Quiz();
                QuizType quiztype = new QuizType();
                quiz.setIdQuiz(rs.getInt("idQuiz"));
                quiz.setJudulQuiz(rs.getString("judulQuiz"));
                quiztype.setIdQuizType(rs.getInt("idQuizType"));
                quiz.setQuizType(quiztype);

                return quiz;
            }
        });
        return quiz;
    }

    @Override
    public List<Quiz> getAllQuiz() {
        String query = QuizQuery.SQL_GET_ALL;
        List<Quiz> quizList = new ArrayList<Quiz>();
        List<Map<String, Object>> quizRows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> quizRow : quizRows) {
            Quiz quiz = new Quiz();
            QuizType quiztype = new QuizType();
            quiz.setIdQuiz(Integer.parseInt(String.valueOf(quizRow.get("idQuiz"))));
            quiz.setJudulQuiz(String.valueOf(quizRow.get("judulQuiz")));
            quiztype.setIdQuizType(Integer.parseInt(String.valueOf(quizRow.get("idQuizType"))));
            quiz.setQuizType(quiztype);

            quizList.add(quiz);
        }

        return quizList;
    }
}
