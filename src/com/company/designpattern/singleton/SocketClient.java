package com.company.designpattern.singleton;

public class SocketClient {

    //Singleton 패턴은 자기 자신을 객체로 가지고 있어야만 한다.
    private static SocketClient socketClient = null;

    private SocketClient() {

    }
    // static 메소드이므로 어떤 클래스 에서도 접근이 가능하다.
    public static SocketClient getInstance() {
        // 객체가 없는 경우에만 생성.
        if(socketClient == null ){
           socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
