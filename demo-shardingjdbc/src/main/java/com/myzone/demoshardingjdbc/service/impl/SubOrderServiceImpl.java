package com.myzone.demoshardingjdbc.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myzone.demoshardingjdbc.entity.SubOrderEntity;
import com.myzone.demoshardingjdbc.mapper.SubOrderDao;
import com.myzone.demoshardingjdbc.service.SubOrderService;
import com.myzone.demoshardingjdbc.vo.SubOrderEntityVo;
import com.myzone.demoutils.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class SubOrderServiceImpl extends ServiceImpl<SubOrderDao, SubOrderEntity> implements SubOrderService {

    @Resource
    SubOrderDao subOrderDao;

    @Autowired
    SubOrderServiceImpl subOrderServiceImpl;

    @Override
    public List<SubOrderEntity> querySubOrderByPage(){

        QueryWrapper<SubOrderEntity> queryWrapper = new QueryWrapper<SubOrderEntity>()
                .ne("order_status","CREATE");


        List<SubOrderEntity> subList = subOrderDao.selectList(queryWrapper);

        return subList;
    }


}
