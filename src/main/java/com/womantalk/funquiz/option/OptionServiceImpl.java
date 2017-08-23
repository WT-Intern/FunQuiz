package com.womantalk.funquiz.option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    OptionRepository optionRepository;

    @Override
    public List<Option> getOptionByIdQuestion(int id)
    {
        return optionRepository.findAllByQuestion_IdQuestion(id);
    }

    @Override
    public Option addOption(Option option) {

        return optionRepository.save(option);
    }

    @Override
    public List<Option> getAllOption() {
        List<Option> optionList = optionRepository.findAll();
        if(optionList!=null) {
            return optionList;
        }else {
            return null;
        }
    }

    @Override
    public Option findOptionById(int id_option) {
        return optionRepository.findOne(id_option);
    }

    @Override
    public Option updateOption(Option option) {
        Option optionUpdate =findOptionById(option.getIdOption());
        optionUpdate.setText(option.getText());
        optionUpdate.setImageURL(option.getImageURL());
        optionUpdate.setType(option.getType());
        optionUpdate.setValue(option.getValue());
        optionUpdate.setQuestion(option.getQuestion());
        return optionRepository.saveAndFlush(optionUpdate);
    }
}
