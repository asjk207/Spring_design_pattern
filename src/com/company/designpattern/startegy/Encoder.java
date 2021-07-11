package com.company.designpattern.startegy;

public class Encoder {

    private EncodingStrategy encodingstrategy;

    public String getMessage(String message){
        return this.encodingstrategy.encode(message);
    }

    public void setEncodingstrategy(EncodingStrategy encodingstrategy){
        this.encodingstrategy = encodingstrategy;
    }
}
