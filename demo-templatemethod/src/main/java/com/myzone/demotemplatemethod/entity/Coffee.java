package com.myzone.demotemplatemethod.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coffee extends Drinks {
    @Override
    void brew() {
        System.out.println("冲咖啡粉");
    }

    @Override
    void addCondiments() {
        System.out.println("加奶加糖");
    }

    //覆盖了钩子，提供了自己的询问功能，让用户输入是否需要加料
    boolean customerLike() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    //处理用户的输入
    private String getUserInput() {
        String answer = null;
        System.out.println("您想要加奶加糖吗？输入 YES 或 NO");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}