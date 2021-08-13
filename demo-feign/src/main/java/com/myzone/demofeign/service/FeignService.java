package com.myzone.demofeign.service;

import com.myzone.demoutils.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//通过name指定调用的同意注册中心的模块名
//通过url指定调用的路径
@FeignClient(name = "mybatisplus", url = "${ngFileUrl}")
public interface FeignService {

//    //oss删除文件接口
//    @RequestMapping(value = "/oos/file/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    R delete(@RequestParam("objName") String objName);

    //调用mybatisplus项目中的get接口
    @RequestMapping(value = "/hello", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    String sayHello();
}
