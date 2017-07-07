package com.womantalk.funquiz.Option;

import com.womantalk.funquiz.Option.Option;
import com.womantalk.funquiz.Option.OptionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OptionServiceImpl implements OptionService {
    @Autowired
    private  OptionRepository optionRepository;

    @Override
    public void save(Option option) {
        optionRepository.save(option);
    }

    @Override
    public Option findById(int id) {
        return optionRepository.findById(id);
    }

    @Override
    public List<Option> getAllOption() {
        return optionRepository.getAllOption();
    }
}
