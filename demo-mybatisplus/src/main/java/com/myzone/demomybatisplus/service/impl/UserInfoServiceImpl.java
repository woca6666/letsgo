package com.myzone.demomybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myzone.demomybatisplus.entity.UserInfoEntity;
import com.myzone.demomybatisplus.mapper.UserInfoMapper;
import com.myzone.demomybatisplus.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoEntity> implements IUserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public void saveList(List<UserInfoEntity> list) {
        userInfoMapper.saveList(list);
    }
}
