package com.womantalk.funquiz.Option;

import com.womantalk.funquiz.Question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OptionRepositoryImpl implements OptionRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Option option) {
        String query = OptionQuery.SQL_INSERT;
        jdbcTemplate.update(query);
    }

    @Override
    public Option findById(int id) {
        String query = OptionQuery.SQL_FIND_BY_ID;
        Option option = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Option>() {
            @Override
            public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
                Option option = new Option();
                Question question = new Question();
                option.setIdOption(rs.getInt("idOption"));
                option.setText(rs.getString("text"));
                option.setImageURL(rs.getString("imageURL"));
                option.setType(rs.getString("type"));
                option.setValue(rs.getInt("value"));
                question.setIdQuestion(rs.getInt("idQuestion"));
                option.setQuestion(question);

                return option;
            }
        });

        return option;
    }

    @Override
    public List<Option> getAllOption() {
        String query = OptionQuery.SQL_GET_ALL;
        List<Option> optionList = new ArrayList<Option>();
        List<Map<String, Object>> optionRows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> optionRow : optionRows) {
            Option option = new Option();
            Question question = new Question();
            option.setIdOption(Integer.parseInt(String.valueOf(optionRow.get("idOption"))));
            option.setText(String.valueOf(optionRow.get("text")));
            option.setImageURL(String.valueOf(optionRow.get("imageURL")));
            option.setType(String.valueOf(optionRow.get("type")));
            option.setValue(Integer.parseInt(String.valueOf(optionRow.get("value"))));
            question.setIdQuestion(Integer.parseInt(String.valueOf(optionRow.get("idQuestion"))));
            option.setQuestion(question);

            optionList.add(option);
        }

        return optionList;
    }
}
