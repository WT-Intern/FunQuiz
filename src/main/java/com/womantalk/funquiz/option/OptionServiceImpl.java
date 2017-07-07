package com.womantalk.funquiz.Option;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OptionServiceImpl implements OptionService {

    @Autowired
    OptionRepository optionRepository;

    @Override
    public Option findOne(int id_option) {
        return optionRepository.findOne(id_option);
    }

    @Override
    public Option add(Option option) {
        return null;
    }

    @Override
    public List<Option> findAll() {
        return optionRepository.findAll();
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
