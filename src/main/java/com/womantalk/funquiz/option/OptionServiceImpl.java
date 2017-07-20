package com.womantalk.funquiz.option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    OptionRepository optionRepository;

    @Override
    public List<Option> getAllOptionByIdQuestion(int id)
    {
        return optionRepository.findByQuestionIdQuestion(id);
    }
}
