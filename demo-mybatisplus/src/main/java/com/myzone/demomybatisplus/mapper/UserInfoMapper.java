package com.myzone.demomybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myzone.demomybatisplus.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {

    void saveList(List<UserInfoEntity> list);
}
