package com.company.designpattern.adapter;

public class HairDryer implements  Electronic110V{

    // interface의 메소드를 재정의 하여 사용한다.
    @Override
    public void powerOn() {
        System.out.println("헤어 드라이기 110v on");
    }
}
