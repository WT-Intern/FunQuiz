package com.womantalk.funquiz.Question;

import com.womantalk.funquiz.Quiz.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionRepositoryImpl implements QuestionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Question question) {
        String query = QuestionQuery.SQL_INSERT;
        jdbcTemplate.update(query);
    }

    @Override
    public Question findById(int id) {
        String query = QuestionQuery.SQL_FIND_BY_ID;
        Question question = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                Question question = new Question();
                Quiz quiz = new Quiz();
                question.setIdQuestion(rs.getInt("idQuestion"));
                question.setQuestion(rs.getString("question"));
                quiz.setIdQuiz(rs.getInt("idQuiz"));
                question.setQuiz(quiz);

                return question;
            }
        });

        return question;
    }

    @Override
    public List<Question> getAllQuestion() {
        String query = QuestionQuery.SQL_GET_ALL;
        List<Question> questionList = new ArrayList<Question>();
        List<Map<String, Object>> questionRows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> questionRow : questionRows) {
            Question question = new Question();
            Quiz quiz = new Quiz();
            question.setIdQuestion(Integer.parseInt(String.valueOf(questionRow.get("idQuestion"))));
            question.setQuestion(String.valueOf(questionRow.get("question")));
            quiz.setIdQuiz(Integer.parseInt(String.valueOf(questionRow.get("idQuiz"))));
            question.setQuiz(quiz);

            questionList.add(question);
        }

        return questionList;
    }
}
