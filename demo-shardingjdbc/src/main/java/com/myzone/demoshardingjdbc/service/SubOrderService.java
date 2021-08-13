package com.myzone.demoshardingjdbc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myzone.demoshardingjdbc.entity.SubOrderEntity;
import com.myzone.demoshardingjdbc.vo.SubOrderEntityVo;
import com.myzone.demoutils.utils.R;

import java.util.List;


/**
* 子订单服务接口
*/
public interface SubOrderService extends IService<SubOrderEntity> {

    List<SubOrderEntity> querySubOrderByPage();
}
