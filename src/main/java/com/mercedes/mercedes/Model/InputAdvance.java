package com.mercedes.mercedes.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;



public class InputAdvance {


    @JsonProperty(value = "Total Test Cases")
    String totalCases;



HashMap<String,Input> input;
}
