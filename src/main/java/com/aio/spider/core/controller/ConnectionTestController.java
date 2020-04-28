package com.aio.spider.core.controller;

import com.aio.spider.common.pojo.JsonResult;
import com.aio.spider.common.pojo.JsonResultT;
import com.aio.spider.core.service.ConnectionTestService;
import com.aio.spider.core.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: 连接测试
 * @author: Mr.chen
 * @date: 2020/3/27 13:05
 * @version: 1.0
 */
@Controller
@RequestMapping("/connectionTest")
public class ConnectionTestController {

    @Autowired
    private ConnectionTestService connectionTestService;

    @GetMapping("/test")
    ModelAndView test(@RequestParam(value = "name",required = false,defaultValue = "test") String name,ModelAndView modelAndView){
        modelAndView.addObject("name",name);
        modelAndView.setViewName("test/test");
        return modelAndView;
    }

    @GetMapping("/testObj")
    @ResponseBody
    JsonResult testObj(){
        return JsonResult.ok("接口测试成功",null);
    }

    @GetMapping("/testList")
    @ResponseBody
    JsonResultT<UserVo> testList(){
        return JsonResultT.ok(connectionTestService.findUsers());
    }

}
