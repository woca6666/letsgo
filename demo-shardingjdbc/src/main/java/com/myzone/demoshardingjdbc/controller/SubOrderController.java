package com.myzone.demoshardingjdbc.controller;


import com.myzone.demoshardingjdbc.entity.SubOrderEntity;
import com.myzone.demoshardingjdbc.service.SubOrderService;
import com.myzone.demoshardingjdbc.vo.SubOrderEntityVo;
import com.myzone.demoutils.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/subOrder")
@Slf4j
public class SubOrderController {

    @Autowired
    private SubOrderService subOrderService;

    @PostMapping("/querySubOrderByPage")
    public List<SubOrderEntity> getSubOrderByPage() {

        List<SubOrderEntity> pageUtils = subOrderService.querySubOrderByPage();
        return pageUtils;
    }

}
