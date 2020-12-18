package com.myzone.demomybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("demo")
public class UserInfoEntity implements Serializable {

    @TableId
    private int id;

    private String name;

    private String age;

    private String adress;

    private String email;

    private String phone;


}
