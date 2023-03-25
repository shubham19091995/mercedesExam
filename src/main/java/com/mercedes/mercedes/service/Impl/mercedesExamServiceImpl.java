package com.mercedes.mercedes.service.Impl;



import com.mercedes.mercedes.Model.Input;
import com.mercedes.mercedes.service.mercedesExamService;
import org.springframework.stereotype.Service;

@Service
public class mercedesExamServiceImpl implements mercedesExamService {
    @Override
    public int getData(Input input) {

return  algorithm(input.getS());

    }


}
