package com.myzone.demomybatisplus.controller;

import com.myzone.demomybatisplus.entity.UserInfoEntity;
import com.myzone.demomybatisplus.service.IUserInfoService;
import com.myzone.demomybatisplus.utils.InsertConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class UserInfoController {

    @Autowired
    IUserInfoService userInfoServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String sayHello() {
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/add1")
    public String adds1() {
        long l = System.currentTimeMillis();

        UserInfoEntity demo = new UserInfoEntity();
        for (int i = 0; i < 400000; i++) {
            demo.setName("name" + i);
            demo.setAdress("adress" + i);
            demo.setAge("age" + i);
            demo.setEmail("email" + i);
            demo.setPhone("phone" + i);
            //第一种方式：
            userInfoServiceImpl.save(demo);//517084
        }
        log.info("耗时：" + (System.currentTimeMillis() - l));
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/add2")
    public String adds2() {
        long l = System.currentTimeMillis();

        List<UserInfoEntity> list = new ArrayList<>();
        for (int i = 0; i < 400000; i++) {
            UserInfoEntity demo = new UserInfoEntity();
            demo.setName("name" + i);
            demo.setAdress("adress" + i);
            demo.setAge("age" + i);
            demo.setEmail("email" + i);
            demo.setPhone("phone" + i);
            list.add(demo);
        }
        //第二种方式：
//        userInfoServiceImpl.saveBatch(list);//211085

        //第三种方式：
//        userInfoServiceImpl.saveList(list);//38060

        //第四种方式：
//        list.parallelStream().forEach(demo -> {
//            userInfoServiceImpl.save(demo);//181978
//        });

        //第五种方式：
//        InsertConsumer.insertData(list, userInfoServiceImpl::saveBatch);//84977

        //第六种方式：
        InsertConsumer.insertData(list, userInfoServiceImpl::saveList);//23656

        log.info("耗时：" + (System.currentTimeMillis() - l));
        return "success";
    }
}
