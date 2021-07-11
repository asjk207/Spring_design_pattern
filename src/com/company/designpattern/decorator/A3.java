package com.company.designpattern.decorator;

public class A3 extends AudiDecorator{
    // super를 이용하여 AudiDecorator에 변수를 생성한다.
    // super() 슈퍼클래스의 생성자를 서브클래스에서 반드시 생성해야한다.( 자바의 규칙 )
    public A3(ICar audi, String modelName) { super(audi, modelName, 1000); }
}
