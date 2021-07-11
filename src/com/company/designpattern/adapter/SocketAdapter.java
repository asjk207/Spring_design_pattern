package com.company.designpattern.adapter;

public class SocketAdapter implements Electronic110V{

    private Electronic220V electronic220V;

    // 변환을 위해 생성자를 통해 220V객체를 받는다.
    public SocketAdapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }

    //220V객체의 connect메소드 를 호출하여 변환을 한다.
    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
