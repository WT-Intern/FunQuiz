package com.womantalk.funquiz.QuizType;

import com.womantalk.funquiz.QuizType.QuizType;
import com.womantalk.funquiz.QuizType.QuizTypeQuery;
import com.womantalk.funquiz.QuizType.QuizTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuizTypeRepositoryImpl implements QuizTypeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(QuizType quiztype) {
        String query = QuizTypeQuery.SQL_INSERT;
        jdbcTemplate.update(query);
    }

    @Override
    public QuizType findById(int id) {
        String query = QuizTypeQuery.SQL_FIND_BY_ID;
        QuizType quiztype = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<QuizType>() {
            @Override
            public QuizType mapRow(ResultSet rs, int rowNum) throws SQLException {
                QuizType quiztype = new QuizType();
                quiztype.setIdQuizType(rs.getInt("idQuizType"));
                quiztype.setTypeName(rs.getString("typeName"));

                return quiztype;
            }
        });

        return quiztype;
    }

    @Override
    public List<QuizType> getAllQuizType() {
        String query = QuizTypeQuery.SQL_GET_ALL;
        List<QuizType> quizTypeList = new ArrayList<QuizType>();
        List<Map<String, Object>> quizTypeRows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> quizTypeRow : quizTypeRows) {
            QuizType quiztype = new QuizType();
            quiztype.setIdQuizType(Integer.parseInt(String.valueOf(quizTypeRow.get("idQuizType"))));
            quiztype.setTypeName(String.valueOf(quizTypeRow.get("typeName")));

            quizTypeList.add(quiztype);
        }

        return quizTypeList;
    }
}
