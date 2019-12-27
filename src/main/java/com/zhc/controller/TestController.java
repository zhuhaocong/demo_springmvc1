package com.zhc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("测试成功");
        return "success";
    }

    @RequestMapping("/test1")
    public ModelAndView test1(){
        System.out.println("返回ModelAndView");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","zhc");
        modelAndView.setViewName("success");
        return modelAndView;
    }

}
