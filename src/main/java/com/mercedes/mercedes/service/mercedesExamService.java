package com.mercedes.mercedes.service;

import com.mercedes.mercedes.Model.Input;
import com.mercedes.mercedes.Model.ResponseOutput;

import java.util.Arrays;
import java.util.HashMap;

public interface mercedesExamService {


    int getData(Input input);

    default int algorithm(int [] arr){
        Arrays.sort(arr);
        int n = arr.length;
        int minVal = arr[0];
        int maxVal = arr[n-1];
        int sumDiff = maxVal - minVal;
        while (n > 1) {
            if (maxVal - arr[0] < arr[n-2] - minVal) {
                minVal = arr[1];
                maxVal = arr[n-1];
                sumDiff += maxVal - arr[0];
                arr = Arrays.copyOfRange(arr, 1, n);
            } else {
                minVal = arr[0];
                maxVal = arr[n-2];
                sumDiff += maxVal - minVal;
                arr = Arrays.copyOfRange(arr, 0, n-1);
            }
            n--;
        }
        return sumDiff;
    }

}
