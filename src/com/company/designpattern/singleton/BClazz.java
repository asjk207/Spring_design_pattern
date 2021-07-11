package com.company.designpattern.singleton;

public class BClazz {

    private SocketClient socketClient;

    public BClazz() {
        // SocketClient 생성자는 private으로 막아 놓았으므로, getInstance()를 통해 받아온다.
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
