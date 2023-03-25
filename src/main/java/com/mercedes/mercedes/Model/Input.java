package com.mercedes.mercedes.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;



public class Input implements Serializable {
    // we can use lombok too :)
    @JsonProperty
    int N;
    @JsonProperty
    int[] S;

    public Input(int N, int[] S) {
        this.N = N;
        this.S = S;
    }

    public Input(){}

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public int[] getS() {
        return S;
    }

    public void setS(int[] S) {
        this.S = S;
    }
}
