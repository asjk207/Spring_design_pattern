package com.company.designpattern.decorator;

public class AudiDecorator implements ICar{
    // protected는 다른 클래스에서 접근이 불가능 하고 상속 받는 서브클래스 만이 접근이 가능하다.
    protected ICar audi;
    protected String modelName;
    protected int modelPrice;


    public AudiDecorator(ICar audi, String modelName, int modelPrice){
        this.audi = audi;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
    }

    @Override
    public int getPrice() {
        return audi.getPrice() + modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println(modelName + "의 가격은 " + getPrice() + "원 입니다.");
    }
}
