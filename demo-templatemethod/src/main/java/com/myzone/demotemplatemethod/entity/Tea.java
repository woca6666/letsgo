package com.myzone.demotemplatemethod.entity;

public class Tea extends Drinks {

    @Override
    void brew() {
        System.out.println("冲茶叶");
    }

    @Override
    void addCondiments() {
        System.out.println("加柠檬片");
    }

    //覆盖了钩子，提供了自己的询问功能，让用户输入是否需要加料
    boolean customerLike() {
        return true;
    }
}