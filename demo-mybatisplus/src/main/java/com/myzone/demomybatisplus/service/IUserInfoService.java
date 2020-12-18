package com.myzone.demomybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myzone.demomybatisplus.entity.UserInfoEntity;

import java.util.List;

public interface IUserInfoService extends IService<UserInfoEntity> {

    void saveList(List<UserInfoEntity> list);
}
