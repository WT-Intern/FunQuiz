package com.womantalk.funquiz.QuizRules;


import com.womantalk.funquiz.Quiz.Quiz;
import com.womantalk.funquiz.QuizRules.QuizRules;
import com.womantalk.funquiz.QuizRules.QuizRulesQuery;
import com.womantalk.funquiz.QuizRules.QuizRulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuizRulesRepositoryImpl implements QuizRulesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(QuizRules quizrules) {
        String query = QuizRulesQuery.SQL_INSERT;
        jdbcTemplate.update(query);
    }

    @Override
    public QuizRules findById(int id) {
        String query = QuizRulesQuery.SQL_FIND_BY_ID;
        QuizRules quizrules = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<QuizRules>() {
            @Override
            public QuizRules mapRow(ResultSet rs, int rowNum) throws SQLException {
                QuizRules quizrules = new QuizRules();
                Quiz quiz = new Quiz();
                quizrules.setIdRules(rs.getInt("idRules"));
                quizrules.setMin(rs.getInt("min"));
                quizrules.setMax(rs.getInt("max"));
                quizrules.setValue(rs.getInt("value"));
                quizrules.setDescription(rs.getString("description"));
                quiz.setIdQuiz(rs.getInt("idQuiz"));
                quizrules.setQuiz(quiz);

                return quizrules;
            }
        });
        return quizrules;
    }

    @Override
    public List<QuizRules> getAllQuizRules() {
        String query = QuizRulesQuery.SQL_GET_ALL;
        List<QuizRules> quizRulesList = new ArrayList<QuizRules>();
        List<Map<String, Object>> quizRulesRows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> quizRulesRow : quizRulesRows) {
            QuizRules quizrules = new QuizRules();
            Quiz quiz = new Quiz();
            quizrules.setIdRules(Integer.parseInt(String.valueOf(quizRulesRow.get("idRules"))));
            quizrules.setMin(Integer.parseInt(String.valueOf(quizRulesRow.get("min"))));
            quizrules.setMax(Integer.parseInt(String.valueOf(quizRulesRow.get("max"))));
            quizrules.setValue(Integer.parseInt(String.valueOf(quizRulesRow.get("value"))));
            quizrules.setDescription(String.valueOf(quizRulesRow.get("description")));
            quiz.setIdQuiz(Integer.parseInt(String.valueOf(quizRulesRow.get("idQuiz"))));
            quizrules.setQuiz(quiz);

            quizRulesList.add(quizrules);
        }

        return quizRulesList;
    }
}
