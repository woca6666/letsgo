package com.myzone.demotemplatemethod.entity;

import lombok.Data;

public abstract class Drinks {

    void boilWater() {
        System.out.println("将水煮沸");
    }

    abstract void brew();

    void pourInCup() {
        System.out.println("倒入杯子");
    }

    abstract void addCondiments();

    //定义一个空的缺省方法，只返回 true
    boolean customerLike() {
        return true;
    }

    public final void makingDrinks() {
        //热水
        boilWater();
        //冲泡
        brew();
        //倒进杯子
        pourInCup();
        //加料
        if (customerLike()) {
            addCondiments();
        }
    }

    public static void main(String[] args) {
        Drinks coffee = new Coffee();
        coffee.makingDrinks();
        System.out.println();
        Drinks tea = new Tea();
        tea.makingDrinks();
    }
}
