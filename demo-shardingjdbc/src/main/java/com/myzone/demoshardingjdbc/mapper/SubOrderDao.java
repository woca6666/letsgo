package com.myzone.demoshardingjdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myzone.demoshardingjdbc.entity.SubOrderEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubOrderDao extends BaseMapper<SubOrderEntity> {
}
