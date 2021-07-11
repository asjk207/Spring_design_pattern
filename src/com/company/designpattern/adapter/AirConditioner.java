package com.company.designpattern.adapter;

public class AirConditioner implements Electronic220V{

    // interface의 메소드를 재정의 하여 사용한다.
    @Override
    public void connect() {
        System.out.println("에어컨 200V on");
    }
}
