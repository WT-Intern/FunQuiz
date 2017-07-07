package com.womantalk.funquiz.Option;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OptionRepositoryImpl implements OptionRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Option findOne(int id_option) {
        String SQL = OptionQuery.OPTION_BY_ID;
        Option option = jdbcTemplate.queryForObject(SQL, new Object[] {id_option}, new BeanPropertyRowMapper<Option>(Option.class));
        return option;
    }

    @Override
    public Option add(Option option) {
        return null;
    }

    @Override
    public List<Option> findAll() {
        String SQL = OptionQuery.ALL_OPTION;
        List option = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<Option>(Option.class));
        return option;
    }

    @Override
    public int update(Option option) {
        return 0;
    }

    @Override
    public int delete(Option option) {
        return 0;
    }
}
