package com.company.designpattern.startegy;

public class AppendStrategy implements EncodingStrategy{
    @Override
    public String encode(String text) {
        return "ABCD"+text;
    }
}
