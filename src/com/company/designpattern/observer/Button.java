package com.company.designpattern.observer;

public class Button {

    private String name;
    private IButtonListener buttonListener;

    public Button(String name){
        this.name = name;
    }

    // 이벤트가 발생하면 clickEvent 메소드를 호출한다.
    public void click(String message){
        buttonListener.clickEvent(message);
    }
    // 리스너를 등록한다.
    public void addListener(IButtonListener iButtonListener) {
        this.buttonListener = iButtonListener;
    }
}
